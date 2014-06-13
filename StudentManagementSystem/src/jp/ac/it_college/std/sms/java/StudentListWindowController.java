package jp.ac.it_college.std.sms.java;

import javafx.stage.Stage;

public class StudentListWindowController extends BaseController {

    public void Logout() {
        mMain.changeScene(mMain.getPrimaryStage(), "ログイン", "LoginWindow");
    }

    public void Close() {
        DataBaseConnection.getInstance().closeConnection();
        mMain.getPrimaryStage().close();
    }

    public void StudentAddHandler() {
        Stage stage = new Stage();
        stage.initOwner(mMain.getPrimaryStage());
        mMain.changeScene(stage, "学生追加", "StudentAddWindow");
    }

    public void AttendanceHandler() {
        Stage stage = new Stage();
        stage.initOwner(mMain.getPrimaryStage());
        mMain.changeScene(stage, "出席", "AttendanceWindow");
    }
}
