package jp.ac.it_college.std.sms;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class PasswordChangeWindowController extends BaseController {
    public static final String TITLE = "パスワード変更画面";
    public static final String FXML = "PasswordChangeWindow";
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField newPasswordConfirmationField;
    @FXML private Label resultLabel;


    public void closeHandle() {
        Stage stage = (Stage) newPasswordField.getScene().getWindow();
        stage.close();
    }

    public void applyHandle() {
    }
}
