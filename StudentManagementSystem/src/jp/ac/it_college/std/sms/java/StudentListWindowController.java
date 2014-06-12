package jp.ac.it_college.std.sms.java;

public class StudentListWindowController extends BaseController {

    public void Logout() {
        mMain.changePrimaryStageScene("ログイン", "LoginWindow");
    }

    public void Close() {
        mMain.getPrimaryStage().close();
    }
}
