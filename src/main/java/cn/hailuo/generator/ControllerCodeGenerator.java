package cn.hailuo.generator;

import cn.hailuo.Path;
import cn.hailuo.TemplateCodeFactory;
import cn.hailuo.entity.ConfigInfo;
import cn.hailuo.util.StringUtil;

import java.io.File;
import java.util.Map;

import static cn.hailuo.util.StringUtil.*;

public class ControllerCodeGenerator extends JavaAbstractCodeGenerator {
    @Override
    protected String getTemplateName() {
        return "Controller";
    }

    @Override
    protected String getPackageName() {
        return TemplateCodeFactory.getConfigInfo().getPackageRoot() + ".controller";
    }

    @Override
    protected boolean checkModel(String tableName, Map<String, Object> model) {
        if (Integer.parseInt(String.valueOf(model.get("keyNum"))) < 1) {
            System.err.println("Table " + tableName + " hasn't a primary key, " +
                    "fail to create its Controller");
            return false;
        } else if (Integer.parseInt(String.valueOf(model.get("keyNum"))) > 1) {
            System.err.println("Table " + tableName + " has more than one primary keys, " +
                    "fail to create its Controller");
            return false;
        }
        return true;
    }

}
