package jp.ac.it_college.std.sms;

abstract public class BaseController {
    protected Main main;
    protected User user;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
