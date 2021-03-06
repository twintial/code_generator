package cn.hailuo.generator;

import cn.hailuo.TemplateCodeFactory;

import java.util.Map;

public class ServiceimplCodeGenerator extends JavaAbstractCodeGenerator {
    @Override
    protected String getTemplateName() {
        return "ServiceImpl";
    }

    @Override
    protected String getPackageName() {
        return TemplateCodeFactory.getConfigInfo().getPackageRoot() + ".service.impl";
    }

    @Override
    protected boolean checkModel(String tableName, Map<String, Object> model) {
        if (Integer.parseInt(String.valueOf(model.get("keyNum"))) < 1) {
            System.err.println("Table " + tableName + " hasn't a primary key, " +
                    "fail to create its ServiceImpl");
            return false;
        } else if (Integer.parseInt(String.valueOf(model.get("keyNum"))) > 1) {
            System.err.println("Table " + tableName + " has more than one primary keys, " +
                    "fail to create its ServiceImpl");
            return false;
        }
        return true;
    }
}
