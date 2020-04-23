package cn.hailuo;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://cdb-ezjh4cma.bj.tencentcdb.com:10210/changgou_user?useSSL=false";
        String user = "root";
        String password = "abcd1234";
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        DatabaseMetaData metaData = connection.getMetaData();

        // 获取数据库类型
        System.out.println(metaData.getDatabaseProductName());
        // 数据库实例名字
        System.out.println(connection.getCatalog());
        // 获取数据库实例中的所有表
        ResultSet tables = metaData.getTables(connection.getCatalog(), null,
                "tb_%", new String[]{"TABLE"});
        printResultSet(tables, 20);
        tables.first();

        ResultSet columns = metaData.getColumns(connection.getCatalog(), null,
                tables.getString("TABLE_NAME"), "%");
        printResultSet(columns, 20);
        tables.first();

        tables.next();

        ResultSet primaryKeys = metaData.getPrimaryKeys(connection.getCatalog(), null, tables.getString("TABLE_NAME"));
        printResultSet(primaryKeys, 20);

    }

    static void printResultSet(ResultSet set, int offset) throws SQLException {
        for (int i = 1; i <= set.getMetaData().getColumnCount(); i++) {
            System.out.format("%" + offset + "s", set.getMetaData().getColumnName(i));
        }
        System.out.println();
        while (set.next()) {
            for (int i = 1; i <= set.getMetaData().getColumnCount(); i++) {
                System.out.format("%" + offset + "s", set.getString(i));
            }
            System.out.println();
        }
        System.out.println();
        set.beforeFirst();
    }
}
