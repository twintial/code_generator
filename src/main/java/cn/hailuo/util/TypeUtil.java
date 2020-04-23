package cn.hailuo.util;
public class TypeUtil {

    // 没检验过：3,-7,没有对照二进制类型，如blob
    public static String getQualifiedType(Integer typeCode) {
        switch (typeCode){
            case -6:
            case 5:
            case 4:
                return "java.lang.Integer";
            case -5:
                return "java.lang.Long";
            case 6:
                return "java.lang.Float";
            case 8:
                return "java.lang.Double";
            case 3:
                return "java.math.BigDecimal";
            case 91:
            case 92:
            case 93:
                return "java.util.Date";
            case 16:
            case -7:
                return "java.lang.Boolean";
            case 1:
            case 12:
            case -1:
            default:
                return "java.lang.String";
        }
    }
}
