package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AttendanceWindowController extends BaseController {
    @FXML private AnchorPane attendanceWindow;

    public void Close() {
        Stage stage = (Stage) attendanceWindow.getScene().getWindow();
        stage.close();
    }
}
