package org.forten.code.builder;

import static org.forten.code.model.Const.context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.forten.code.model.Const;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DbBuilder {
	public static boolean buildFile() throws IOException,
			TemplateException, SQLException {
		String basePath = Const.getResourcesPath()+"system/";
		File file = new File(basePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		basePath = basePath + "db.properties";
		file = new File(basePath);
		if (file.exists()) {
			return false;
		}

		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(context.getTemplatePath()));
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		Map<String, Object> root = new HashMap<>();

		Template temp = cfg.getTemplate("db.ftl");
		Writer out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		temp.process(root, out);
		out.flush();
		out.close();
		return true;
	}
}
