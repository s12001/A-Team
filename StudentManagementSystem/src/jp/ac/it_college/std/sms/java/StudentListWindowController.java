package jp.ac.it_college.std.sms.java;

public class StudentListWindowController extends BaseController {

    public void Logout() {
        mMain.changeScene(mMain.getPrimaryStage(), "ログイン", "LoginWindow");
    }

    public void Close() {
        mMain.getPrimaryStage().close();
    }
}
