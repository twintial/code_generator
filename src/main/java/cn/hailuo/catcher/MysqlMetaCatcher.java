package cn.hailuo.catcher;

import cn.hailuo.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MysqlMetaCatcher extends AbstractMetaCatcher {

    @Override
    public void loadDriver() throws ClassNotFoundException {
        Class.forName(Driver.MySQL.getDriver());
    }

    @Override
    protected ResultSet getTables() throws SQLException {
        return getMetaData().getTables(
                getConnection().getCatalog(),
                null,
                "%",
                new String[]{"TABLE"});
    }

    @Override
    protected ResultSet getCols(String tableName) throws SQLException {
        return getMetaData().getColumns(
                getConnection().getCatalog(),
                null,
                tableName,
                "%");
    }

    @Override
    protected ResultSet getPrimaryKeySet(String tableName) throws SQLException {
        return getMetaData().getPrimaryKeys(
                getConnection().getCatalog(),
                null,
                tableName);
    }
}
