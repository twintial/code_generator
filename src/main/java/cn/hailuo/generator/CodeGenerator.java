package cn.hailuo.generator;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

public interface CodeGenerator {

    void generate(Map<String, Map<String, Object>> model);
    // 决定生成的代码类型
    String getSuffix();
}
