package jp.ac.it_college.std.sms.java;

import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    public void Login() {
        mMain.changeScene(mMain.getPrimaryStage(), "学生一覧", "StudentListWindow");
    }

    public void PassWordChangeHandler() {
        Stage stage = new Stage();
        stage.initOwner(mMain.getPrimaryStage());
        mMain.changeScene(stage, "パスワード変更", "PassWordChangeWindow");
    }
}
