package jp.ac.it_college.std.sms.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jp.ac.it_college.std.sms.Authentication;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {
    public static final String TITLE = "ログイン画面";
    public static final String FXML = "LoginWindow";
    @FXML private AnchorPane loginWindow;
    @FXML private TextField idTextField;
    @FXML private PasswordField passwordField;
    @FXML private Label resultLabel;

    private static final String RESULT_MESSAGE = "IDかパスワードが間違っています";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginWindow.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                loginHandle();
            }
        });
    }

    public void loginHandle() {
        if (idTextField.getText().equals("") || passwordField.getText().equals("")) {
            resultLabel.setText(RESULT_MESSAGE);
            return;
        }
        user.setId(idTextField.getText());
        user.setPassword(passwordField.getText());
        if (Authentication.isAuthenticated(user)) {
            if (user.isStudent()) {
                main.changeScene(main.getPrimaryStage(), ATeamController.TITLE, ATeamController.FXML);
            } else {
                main.changeScene(main.getPrimaryStage(), StudentListWindowController.TITLE, StudentListWindowController.FXML);
            }
        } else {
            resultLabel.setText(RESULT_MESSAGE);
        }
    }

    public void changePasswordHandle() {
        if (idTextField.getText().equals("") || passwordField.getText().equals("")) {
            resultLabel.setText(RESULT_MESSAGE);
            return;
        }
        user.setId(idTextField.getText());
        user.setPassword(passwordField.getText());
        if (Authentication.isAuthenticated(user)) {
            main.changeScene(new Stage(), PasswordChangeWindowController.TITLE, PasswordChangeWindowController.FXML);
        } else {
            resultLabel.setText(RESULT_MESSAGE);
        }
    }
}
