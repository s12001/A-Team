package jp.ac.it_college.std.sms.java;

abstract class BaseController {
    protected Main mMain;
    protected User mUser;

    public void setMain(Main main) {
        mMain = main;
    }

    public void setUser(User user) {
        mUser = user;
    }

}
