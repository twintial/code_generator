package cn.hailuo.catcher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface MetaCatcher {

    void loadDriver() throws ClassNotFoundException;

    Map<String, Map<String, Object>> createModels() throws SQLException;
}
