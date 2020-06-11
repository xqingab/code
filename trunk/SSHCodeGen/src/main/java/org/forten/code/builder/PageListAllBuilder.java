package org.forten.code.builder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.forten.code.db.MetaDataReader;
import org.forten.code.model.Const;
import org.forten.code.model.EntityMetaModel;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import static org.forten.code.model.Const.context;
public class PageListAllBuilder {
	public static boolean buildFile(String tableName) throws IOException,
			TemplateException, SQLException {
		String basePath = Const.getProjectPath()+"web/WEB-INF/pages/";
		EntityMetaModel emm = MetaDataReader.getMeta(tableName);
		basePath = basePath+emm.getClassName().toLowerCase()+"/";
		File file = new File(basePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		basePath = basePath + "list-all.jsp";
		file = new File(basePath);
		if (file.exists()) {
			return false;
		}

		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(context.getTemplatePath()));
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		Map<String, Object> root = new HashMap<>();
		root.put("fields", emm.getFieldModelList());

		Template temp = cfg.getTemplate("page-list-all.ftl");
		Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		temp.process(root, out);
		out.flush();
		out.close();
		return true;
	}
}
