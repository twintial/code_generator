package cn.hailuo.catcher;

import cn.hailuo.Driver;
import cn.hailuo.TemplateCodeFactory;
import cn.hailuo.entity.ConfigInfo;
import cn.hailuo.entity.FieldInfo;
import cn.hailuo.util.StringUtil;
import cn.hailuo.util.TypeUtil;

import java.sql.*;
import java.util.*;

import static cn.hailuo.util.StringUtil.firstLetterUpperCase;
import static cn.hailuo.util.StringUtil.namingOfDBToJava;

public abstract class AbstractMetaCatcher implements MetaCatcher {

    private Connection connection;

    private DatabaseMetaData metaData;

    @Override
    public Map<String, Map<String, Object>> createModels() throws SQLException {
        ResultSet tables = getTables();
        Map<String, Map<String, Object>> models = new HashMap<>();
        Map<String, Object> model;
        while (tables.next()) {
            List<FieldInfo> fieldInfoList = new ArrayList<>();
            Set<String> javaQualifiedTypeSet = new HashSet<>();
            model = new HashMap<>();
            Set<String> keySet = new HashSet<>();

            String tableName = tables.getString("TABLE_NAME");

            ResultSet primaryKeySet = getPrimaryKeySet(tableName);
            while (primaryKeySet.next()) {
                keySet.add(primaryKeySet.getString("COLUMN_NAME"));
            }
            // 加入主键数量
            model.put("keyNum", keySet.size());

            ResultSet cols = getCols(tableName);
            while (cols.next()) {
                Integer typeCode = Integer.parseInt(cols.getString("DATA_TYPE"));
                String qualifiedName = TypeUtil.getQualifiedType(typeCode);
                FieldInfo info = new FieldInfo(cols.getString("TABLE_NAME"),
                        cols.getString("COLUMN_NAME"),
                        StringUtil.qualifiedToSimple(qualifiedName),
                        cols.getString("REMARKS"),
                        cols.getString("IS_AUTOINCREMENT"));

                if (keySet.contains(info.getOriginColumnName())) {
                    info.setPrimaryKey(true);
                    model.put("keyType", info.getSimpleType());
                    model.put("keySetMethod", "set" + info.getUpperColumnName());
                }

                // 添加info
                fieldInfoList.add(info);
                // 添加包名，如java.lang.Integer
                javaQualifiedTypeSet.add(qualifiedName);
            }

            // 与元数据有关的数据
            model.put("fieldList", fieldInfoList);
            model.put("qualifiedTypeSet", javaQualifiedTypeSet);
            model.put("originTableName", tableName);
            model.put("upperTableName", firstLetterUpperCase(namingOfDBToJava(tableName)));
            model.put("camelTableName", namingOfDBToJava(tableName));
            models.put(tableName, model);
        }
        return models;
    }

    protected abstract ResultSet getTables() throws SQLException;

    protected abstract ResultSet getCols(String tableName) throws SQLException;

    protected abstract ResultSet getPrimaryKeySet(String tableName) throws SQLException;

    protected Connection getConnection() {
        if (connection == null) {
            try {
                loadDriver();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("fail to load database driver, please download the JDBC", e);
            }

            ConfigInfo info = TemplateCodeFactory.getConfigInfo();
            try {
                connection = DriverManager.getConnection(info.getUrl(), info.getUsername(), info.getPassword());
            } catch (SQLException e) {
                throw new RuntimeException("fail to connect to database", e);
            }
        }
        return connection;
    }

    protected DatabaseMetaData getMetaData() {
        if (metaData == null) {
            try {
                metaData = getConnection().getMetaData();
            } catch (SQLException e) {
                throw new RuntimeException("fail to get database meta data", e);
            }
        }
        return metaData;
    }
}
