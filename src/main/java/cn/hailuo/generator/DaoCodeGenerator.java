package cn.hailuo.generator;

import cn.hailuo.TemplateCodeFactory;

import java.util.Map;

public class DaoCodeGenerator extends JavaAbstractCodeGenerator {
    @Override
    protected String getTemplateName() {
        return "Mapper";
    }

    @Override
    protected String getPackageName() {
        return TemplateCodeFactory.getConfigInfo().getPackageRoot() + ".dao";
    }

    @Override
    protected boolean checkModel(String tableName, Map<String, Object> model) {
        return true;
    }
}
