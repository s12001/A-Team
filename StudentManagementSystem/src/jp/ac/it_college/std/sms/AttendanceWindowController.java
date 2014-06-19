package jp.ac.it_college.std.sms;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class AttendanceWindowController extends BaseController implements Initializable {
    public static final String TITLE = "出席画面";
    public static final String FXML = "AttendanceWindow";
    @FXML private Label currentTime;
    @FXML private TextField idTextField;
    @FXML private PasswordField passwordField;
    @FXML private Label resultLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance(Locale.JAPAN);
        //calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> currentTime.setText(
                        new SimpleDateFormat("HH:mm:ss")
                                .format(Calendar.getInstance().getTime())));
            }
        }, calendar.getTime(), 100L);
    }

    public void inTimeHandle() {
        user.setId(idTextField.getText());
        user.setPassword(passwordField.getText());
        Calendar calendar = Calendar.getInstance(Locale.JAPAN);

        if (!user.isStudent()) {
            resultLabel.setText("学生ではありません");
            return;
        }

        try {
            if (Authentication.isAuthenticated(user)) {
                PreparedStatement preparedStatement =
                        DatabaseHelper.getInstance().getPreparedStatement(
                                "insert into attendancelog(student_id, date, in_time) " +
                                "values (?, ?, ?)"
                        );
                preparedStatement.setString(1, user.getId());
                preparedStatement.setDate(2, new Date(calendar.getTimeInMillis()));
                preparedStatement.setTime(3, new Time(calendar.getTimeInMillis()));
                int flag = preparedStatement.executeUpdate();
                if (flag == 1) {
                    DatabaseHelper.getInstance().commit();
                    resultLabel.setText("登校しました");
                }
            } else {
                resultLabel.setText("IDかパスワードが間違っています");
            }
        } catch (SQLException e) {
            resultLabel.setText("登校済み");
        }
    }

    public void outTimeHandle() {
        user.setId(idTextField.getText());
        user.setPassword(passwordField.getText());
        Calendar calendar = Calendar.getInstance(Locale.JAPAN);

        if (!user.isStudent()) {
            resultLabel.setText("学生ではありません");
            return;
        }

        try {
            if (Authentication.isAuthenticated(user)) {
                PreparedStatement preparedStatement =
                        DatabaseHelper.getInstance().getPreparedStatement(
                                "update attendancelog set out_time = ? " +
                                "where student_id = ? and date = ? " +
                                "and out_time is null"
                        );
                preparedStatement.setTime(1, new Time(calendar.getTimeInMillis()));
                preparedStatement.setString(2, user.getId());
                preparedStatement.setDate(3, new Date(calendar.getTimeInMillis()));
                int flag = preparedStatement.executeUpdate();
                if (flag == 1) {
                    DatabaseHelper.getInstance().commit();
                    resultLabel.setText("下校しました");
                } else {
                    resultLabel.setText("下校済み");
                }
            } else {
                resultLabel.setText("IDかパスワードが間違っています");
            }
        } catch (SQLException e) {
            resultLabel.setText("エラー");
        }
    }

    public void closeHandle() {
        Stage stage = (Stage) currentTime.getScene().getWindow();
        stage.close();
    }
}
