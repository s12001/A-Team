package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AttendanceWindowController extends BaseController {
    public static final String TITLE = "出席";
    public static final String WINDOW_FXML_NAME = "AttendanceWindow";
    @FXML private AnchorPane attendanceWindow;

    public void Close() {
        Stage stage = (Stage) attendanceWindow.getScene().getWindow();
        stage.close();
    }
}
