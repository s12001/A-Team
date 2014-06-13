package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PassWordChangeWindowController extends BaseController {
    public static final String TITLE = "パスワード変更";
    public static final String WINDOW_FXML_NAME = "PassWordChangeWindow";
    @FXML private Label resultLabel;
    @FXML private AnchorPane passWordChangeWindow;
    @FXML private PasswordField newPassWord;
    @FXML private PasswordField newPassWordConfirmation;

    public void Close() {
        Stage stage = (Stage) passWordChangeWindow.getScene().getWindow();
        stage.close();
    }

    public void Apply() {
        if (newPassWord.getText().equals(newPassWordConfirmation.getText())) {
            Encryption encryption = new Encryption();
            byte[] bytes = encryption.toHashValue(newPassWordConfirmation.getText());
            String result = encryption.toEncryptedString(bytes);
            try {
                DataBaseConnection.getInstance().getStatement().executeUpdate(
                        "update student set password = '" + result + "' where id = '" + mUser.getId() + "';"
                );
                resultLabel.setText("パスワード変更しました");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else {
            resultLabel.setText("パスワードが一致しません");
        }
    }
}
