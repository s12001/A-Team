package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {
    public static final String TITLE = "ログイン";
    public static final String WINDOW_FXML_NAME = "LoginWindow";
    @FXML private AnchorPane loginWindow;
    @FXML private TextField student_id;
    @FXML private PasswordField password;
    @FXML private Label error;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginWindow.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                Login();
            }
        });
    }

    public void Login() {
        if (checkPassWord()) {
            mMain.changeScene(mMain.getPrimaryStage(), StudentListWindowController.TITLE, StudentListWindowController.WINDOW_FXML_NAME);
        }
    }

    public void PassWordChangeHandler() {
        if (checkPassWord()) {
            mMain.changeScene(new Stage(), PassWordChangeWindowController.TITLE, PassWordChangeWindowController.WINDOW_FXML_NAME);
        }
    }

    private boolean checkPassWord() {
        boolean result = false;
        try {
            ResultSet resultSetPassword = DataBaseConnection.getInstance().getStatement().executeQuery(
                    "select password from student where id = '" + student_id.getText() + "';"
            );

            String resultPassWord = null;
            while (resultSetPassword.next()) {
                resultPassWord = resultSetPassword.getString("password");
            }
            if (getEncryptedPassWord().equals(resultPassWord)) {
                mUser.setId(student_id.getText());
                result = true;
            } else {
                error.setText("IDかパスワードが間違っています");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    private String getEncryptedPassWord() {
        Encryption encryption = new Encryption();
        byte[] bytes = encryption.toHashValue(password.getText());
        return encryption.toEncryptedString(bytes);
    }
}
