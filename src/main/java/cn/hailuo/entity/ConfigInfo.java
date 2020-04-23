package cn.hailuo.entity;

import cn.hailuo.Path;
import cn.hailuo.generator.CodeGenerator;
import cn.hailuo.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static cn.hailuo.util.StringUtil.*;

public class ConfigInfo {

    public ConfigInfo(String dbName, String url, String username, String password,
                      String packageRoot, String codePath, String authorName,
                      boolean swagger, String[] generatorNames) {
        this.dbName = dbName;
        this.url = url;
        this.username = username;
        this.password = password;
        this.packageRoot = packageRoot;
        this.codePath = codePath;
        this.authorName = authorName;
        this.swagger = swagger;

        generators = new ArrayList<>();
        for (String name : generatorNames) {
            String className = firstLetterUpperCase(name.toLowerCase()) + "CodeGenerator";
            try {
                Class<?> generator = Class.forName(Path.GENERATOR + "." + className);
                generators.add((CodeGenerator) generator.newInstance());
            } catch (Exception e) {
                System.err.println("fail to find and create " + className);
            }
        }
    }

    private boolean swagger;

    private String dbName;

    private String url;

    private String username;

    private String password;

    private String packageRoot;

    private String codePath;

    private String authorName;

    private List<CodeGenerator> generators;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPackageRoot() {
        return packageRoot;
    }

    public void setPackageRoot(String packageName) {
        this.packageRoot = packageName;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public List<CodeGenerator> getGenerators() {
        return generators;
    }

    public void setGenerators(List<CodeGenerator> generators) {
        this.generators = generators;
    }

    public boolean isSwagger() {
        return swagger;
    }

    public void setSwagger(boolean swagger) {
        this.swagger = swagger;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
