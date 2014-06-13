package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginWindowController extends BaseController {
    @FXML private TextField student_id;
    @FXML private PasswordField password;
    @FXML private Label error;

    public void Login() {
        String id = student_id.getText();
        String pw = password.getText();
        String resultPassWord = null;

        try {
            ResultSet resultSet = DataBaseConnection.getInstance().getStatement().executeQuery(
                    "select password from student where id = '" + id + "';");
            while (resultSet.next()) {
                resultPassWord = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (pw.equals(resultPassWord)) {
            mMain.changeScene(mMain.getPrimaryStage(), "学生一覧", "StudentListWindow");
        } else {
            error.setText("パスワードが間違っています");
        }
    }

    public void PassWordChangeHandler() {
        Stage stage = new Stage();
        stage.initOwner(mMain.getPrimaryStage());
        mMain.changeScene(stage, "パスワード変更", "PassWordChangeWindow");
    }
}
