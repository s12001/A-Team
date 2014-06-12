package jp.ac.it_college.std.sms.java;


public class LoginWindowController extends BaseController {

    public void Login() {
        mMain.changePrimaryStageScene(mMain.getPrimaryStage(), "学生一覧", "StudentListWindow");
    }
}
