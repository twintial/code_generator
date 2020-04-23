package cn.hailuo.generator;

import cn.hailuo.Path;
import cn.hailuo.TemplateCodeFactory;
import cn.hailuo.entity.ConfigInfo;
import cn.hailuo.util.StringUtil;

import java.io.File;
import java.util.Map;

import static cn.hailuo.util.StringUtil.firstLetterUpperCase;
import static cn.hailuo.util.StringUtil.namingOfDBToJava;

public class PojoCodeGenerator extends JavaAbstractCodeGenerator {
    @Override
    protected String getTemplateName() {
        return "Pojo";
    }

    @Override
    protected String getPackageName() {
        return TemplateCodeFactory.getConfigInfo().getPackageRoot() + ".pojo";
    }

    @Override
    protected String getGeneratedClassName(String tableName) {
        return firstLetterUpperCase(namingOfDBToJava(tableName));
    }

    @Override
    protected boolean checkModel(String tableName, Map<String, Object> model) {
        return true;
    }
}
