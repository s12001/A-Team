package jp.ac.it_college.std.sms;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AttendanceWindowController extends BaseController {
    public static final String TITLE = "出席画面";
    public static final String FXML = "AttendanceWindow";
    @FXML private Label hourLabel;
    @FXML private Label minuteLabel;
    @FXML private Label secondLabel;
    @FXML private TextField idTextField;
    @FXML private PasswordField passwordField;
    @FXML private Label resultLabel;

    public void inTimeHandle() {
    }

    public void outTimeHandle() {
    }

    public void closeHandle() {
        Stage stage = (Stage) hourLabel.getScene().getWindow();
        stage.close();
    }
}
