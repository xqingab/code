package org.forten.code.db;

import static org.forten.code.model.Const.context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.forten.code.model.EntityMetaModel;
import org.forten.code.model.FieldMetaModel;
import org.forten.code.util.DataTypeConvertor;
import org.forten.code.util.JdbcHelper;
import org.forten.code.util.NameUtil;

public class MetaDataReader {
	private static final String sql = "SELECT c.COLUMN_NAME,c.DATA_TYPE,c.CHARACTER_MAXIMUM_LENGTH,c.NUMERIC_PRECISION,c.NUMERIC_SCALE,c.IS_NULLABLE,c.COLUMN_COMMENT,c.ORDINAL_POSITION FROM columns c where c.table_name=? order by c.ORDINAL_POSITION";

	public static EntityMetaModel getMeta(String tableName) throws SQLException {
		EntityMetaModel emm = new EntityMetaModel();
		Connection conn = JdbcHelper.getConnection(context.getJdbcDriverClass(),
				"jdbc:mysql://localhost:3306/information_schema?useUnicode=true&characterEncoding=UTF-8", context.getJdbcUsername(), context.getJdbcPassword());
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, tableName);
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			emm.setTableName(tableName);
			emm.setClassName(NameUtil.buildClassName(tableName));
			FieldMetaModel fmm = new FieldMetaModel();
			fmm.setColumnName(rs.getString(1));
			fmm.setFieldName(NameUtil.buildFieldName(rs.getString(1)));
			fmm.setDataType(DataTypeConvertor.convertToJavaType(rs.getString(2)));
			emm.addFieldModel(fmm);
		}
		JdbcHelper.close(conn, stat, rs);
		return emm;
	}
}
