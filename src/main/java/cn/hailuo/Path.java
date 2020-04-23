package cn.hailuo;

import java.io.File;

public class Path {
    // java目录
    public final static String PROJECT_SRC_PATH = System.getProperty("user.dir") + File.separator + "src";
    // 资源目录
    public final static String RESOURCE = PROJECT_SRC_PATH + File.separator + "main" + File.separator + "resources";
    // 配置文件
    public final static String CONFIG_FILE = RESOURCE + File.separator + "application.properties";
    // catcher
    public final static String CATCHER = "cn.hailuo.catcher";
    // generator
    public final static String GENERATOR = "cn.hailuo.generator";
}
