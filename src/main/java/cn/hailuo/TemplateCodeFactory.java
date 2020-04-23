package cn.hailuo;

import cn.hailuo.catcher.MetaCatcher;
import cn.hailuo.entity.ConfigInfo;

import java.io.*;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import static cn.hailuo.util.StringUtil.*;

public class TemplateCodeFactory {

    private static ConfigInfo configInfo;

    public static void generatorAll() {
        configInfo = getConfigInfo();
        String className = firstLetterUpperCase(configInfo.getDbName().toLowerCase()) + "MetaCatcher";
        Class<?> metaCatcherClass;
        try {
            metaCatcherClass = Class.forName(Path.CATCHER + "." + className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("fail to find such database", e);
        }
        MetaCatcher metaCatcher;
        try {
            metaCatcher = (MetaCatcher) metaCatcherClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("fail to create the meta catcher", e);
        }

        Map<String, Map<String, Object>> models;
        // 构造model
        try {
            models = metaCatcher.createModels();
        } catch (SQLException e) {
            throw new RuntimeException("fail to create models with meta data", e);
        }

        // 生成代码
        configInfo.getGenerators().forEach(generator -> generator.generate(models));
    }

    public static ConfigInfo getConfigInfo() {
        if (configInfo == null) {
            Properties props = new Properties();
            try(InputStream is = new BufferedInputStream(new FileInputStream(Path.CONFIG_FILE))) {
                //创建Properties对象
                props.load(is);
            } catch (IOException e) {
                throw new RuntimeException("fail to read application.properties", e);
            }

            configInfo = new ConfigInfo(props.getProperty("datasource.name"),
                    props.getProperty("datasource.url"),
                    props.getProperty("datasource.username"),
                    props.getProperty("datasource.password"),
                    props.getProperty("package.name"),
                    props.getProperty("code.path"),
                    props.getProperty("author.name"),
                    props.getProperty("swagger.enable").equals("true"),
                    props.getProperty("code.template").split("[^a-zA-Z]+"));

        }
        return configInfo;
    }
}
