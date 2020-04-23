package cn.hailuo.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String qualifiedToSimple(String qualifiedName) {
        return qualifiedName.substring(qualifiedName.lastIndexOf(".") + 1);
    }

    public static String toCamelCase(String underScoreCase) {
        StringBuffer s = new StringBuffer();
        Pattern p = Pattern.compile("_(\\w)");
        Matcher m = p.matcher(underScoreCase);
        while (m.find()) {
            m.appendReplacement(s, m.group(1).toUpperCase());
        }
        m.appendTail(s);
        return s.toString();
    }

    public static String removeTB(String str) {
        return str.replaceFirst("(?i)^tb_+", "");
    }

    public static String namingOfDBToJava(String DBStr) {
        return toCamelCase(removeTB(DBStr));
    }

    public static String firstLetterUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
