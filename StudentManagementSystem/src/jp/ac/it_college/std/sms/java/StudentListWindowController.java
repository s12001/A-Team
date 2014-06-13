package jp.ac.it_college.std.sms.java;

import javafx.stage.Stage;

public class StudentListWindowController extends BaseController {
    public static final String TITLE = "学生一覧";
    public static final String WINDOW_FXML_NAME = "StudentListWindow";

    public void Logout() {
        mMain.changeScene(mMain.getPrimaryStage(), LoginWindowController.TITLE, LoginWindowController.WINDOW_FXML_NAME);
    }

    public void Close() {
        DataBaseConnection.getInstance().closeConnection();
        mMain.getPrimaryStage().close();
    }

    public void StudentAddHandler() {
        mMain.changeScene(new Stage(), StudentAddWindowController.TITLE, StudentAddWindowController.WINDOW_FXML_NAME);
    }

    public void AttendanceHandler() {
        mMain.changeScene(new Stage(), AttendanceWindowController.TITLE, AttendanceWindowController.WINDOW_FXML_NAME);
    }
}
