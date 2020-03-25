package first;

public class MainClassField {
    private String Url;
    private String login;
    private String password;
    private String driver;
    private int field;

    public void setUrl(String url) {
        Url = url;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String getUrl() {
        return Url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }

    public int getField() {
        return field;
    }
}
