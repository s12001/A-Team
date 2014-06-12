package jp.ac.it_college.std.sms.java;


public class LoginWindowController extends BaseController {

    public void Login() {
        mMain.changeScene(mMain.getPrimaryStage(), "学生一覧", "StudentListWindow");
    }
}
