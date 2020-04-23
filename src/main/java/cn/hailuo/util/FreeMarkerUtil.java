package cn.hailuo.util;

import cn.hailuo.Path;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerUtil {

    private static Configuration cfg;

    public static void build(Map<String, Object> model, String templateName, String filePath) {
        Template temp;
        try {
            temp = getConfiguration().getTemplate(templateName);
        } catch (IOException e) {
            throw new RuntimeException("fail to find template file", e);
        }

        // 可以不用写out.close
        try(Writer out = new FileWriter(new File(filePath))) {
            temp.process(model, out);
        } catch (IOException e) {
            throw new RuntimeException("fail to find target file path", e);
        } catch (TemplateException e) {
            throw new RuntimeException("fail to generator template code", e);
        }
    }

    public static Configuration getConfiguration() {
        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_30);
            try {
                cfg.setDirectoryForTemplateLoading(new File(Path.RESOURCE + File.separator + "template"));
            } catch (IOException e) {
                throw new RuntimeException("fail to find template resources path", e);
            }
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }
        return cfg;
    }
}
