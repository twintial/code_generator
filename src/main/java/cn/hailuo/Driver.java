package cn.hailuo;

public enum Driver {
    MySQL("com.mysql.cj.jdbc.Driver");

    private String driver;

    Driver(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }
}