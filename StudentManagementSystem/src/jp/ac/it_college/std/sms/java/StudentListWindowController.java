package jp.ac.it_college.std.sms.java;

import javafx.stage.Stage;

public class StudentListWindowController extends BaseController {

    public void Logout() {
        mMain.changeScene(mMain.getPrimaryStage(), "ログイン", "LoginWindow");
    }

    public void Close() {
        mMain.getPrimaryStage().close();
    }

    public void StudentAdd() {
        Stage stage = new Stage();
        stage.initOwner(mMain.getPrimaryStage());
        mMain.changeScene(stage, "学生追加", "StudentAddWindow");
    }

    public void Attendance() {
        Stage stage = new Stage();
        stage.initOwner(mMain.getPrimaryStage());
        mMain.changeScene(stage, "出席", "AttendanceWindow");
    }
}
