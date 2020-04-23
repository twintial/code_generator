package cn.hailuo.generator;

import cn.hailuo.Path;
import cn.hailuo.TemplateCodeFactory;
import cn.hailuo.entity.ConfigInfo;
import cn.hailuo.util.FileUtil;
import cn.hailuo.util.FreeMarkerUtil;
import cn.hailuo.util.StringUtil;
import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import static cn.hailuo.TemplateCodeFactory.*;
import static cn.hailuo.util.StringUtil.*;

public abstract class JavaAbstractCodeGenerator implements CodeGenerator {

    // models的key为tableName，后面为生成文件所需的信息
    @Override
    public void generate(Map<String, Map<String, Object>> models) {
        models.forEach((tableName, model) -> {
            if (!checkModel(tableName, model)) return;
            model.put("packageName", getPackageName());
            // 额外的数据
            model.put("date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            model.put("authorName", getConfigInfo().getAuthorName());
            model.put("swagger", getConfigInfo().isSwagger());
            FreeMarkerUtil.build(model, getTemplateName() + getSuffix(), getFilePath(tableName));
        });
    }
    // 获得模版的名称
    protected abstract String getTemplateName();
    // 获得包名
    protected abstract String getPackageName();

    protected abstract boolean checkModel(String tableName, Map<String, Object> model);
    // 获得生成的类名
    protected String getGeneratedClassName(String tableName) {
        return firstLetterUpperCase(namingOfDBToJava(tableName) + getTemplateName());
    }

    // 获得模版后缀
    @Override
    public String getSuffix() {
        return ".java";
    }

    // 包括文件名
    protected String getFilePath(String tableName) {
        ConfigInfo info = getConfigInfo();
        String path = info.getCodePath().isEmpty() ? Path.PROJECT_SRC_PATH : info.getCodePath();
        String className = getGeneratedClassName(tableName) + getSuffix();
        String dirPath = path + File.separator + getPackageName().replace(".", File.separator);
        try {
            FileUtil.createFile(dirPath);
        } catch (IOException e) {
            throw new RuntimeException("fail to create target java file", e);
        }
        return dirPath + File.separator + className;
    }
}
