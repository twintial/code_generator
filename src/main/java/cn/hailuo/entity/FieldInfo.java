package cn.hailuo.entity;

import static cn.hailuo.util.StringUtil.*;

public class FieldInfo {

    public FieldInfo(String originTableName, String originColumnName,
                     String simpleType, String remarks, String autoIncrement) {
        this.simpleType = simpleType;
        this.remarks = remarks;
        this.autoIncrement = autoIncrement;
//        this.primaryKey = autoIncrement.equals("YES");

        this.originColumnName = originColumnName;
        this.camelColumnName = namingOfDBToJava(originColumnName);
        this.upperColumnName = firstLetterUpperCase(camelColumnName);

        this.camelTableName = namingOfDBToJava(originTableName);
        this.upperTableName = firstLetterUpperCase(camelTableName);

    }

    private String originColumnName;
    // 驼峰
    private String camelTableName;
    // 驼峰
    private String camelColumnName;
    // 首字母大写
    private String upperTableName;
    // 首字母大写
    private String upperColumnName;

    private String simpleType;

    private String remarks;

    private boolean primaryKey;

    // YES为是，NO为否
    // 是自增的一定是主键
    private String autoIncrement;

    public String getOriginColumnName() {
        return originColumnName;
    }

    public void setOriginColumnName(String originColumnName) {
        this.originColumnName = originColumnName;
    }

    public String getCamelTableName() {
        return camelTableName;
    }

    public void setCamelTableName(String camelTableName) {
        this.camelTableName = camelTableName;
    }

    public String getCamelColumnName() {
        return camelColumnName;
    }

    public void setCamelColumnName(String camelColumnName) {
        this.camelColumnName = camelColumnName;
    }

    public String getUpperTableName() {
        return upperTableName;
    }

    public void setUpperTableName(String upperTableName) {
        this.upperTableName = upperTableName;
    }

    public String getUpperColumnName() {
        return upperColumnName;
    }

    public void setUpperColumnName(String upperColumnName) {
        this.upperColumnName = upperColumnName;
    }

    public String getSimpleType() {
        return simpleType;
    }

    public void setSimpleType(String simpleType) {
        this.simpleType = simpleType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(String autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

}
