package jp.ac.it_college.std.sms.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentListWindowController extends BaseController implements Initializable {
    public static final String TITLE = "学生一覧";
    public static final String WINDOW_FXML_NAME = "StudentListWindow";
    @FXML private ComboBox<String> department;
    @FXML private ComboBox<String> schoolGrade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setComboboxItems(
                department,
                "select distinct ifnull(concat(department.name,' ',department.course_name), department.name)\n" +
                "from student, department\n" +
                "where student.department_id = department.id;"
        );
        setComboboxItems(
                schoolGrade,
                "select distinct school_grade\n" +
                "from student"
        );
    }

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

    private void setComboboxItems(ComboBox<String> comboBox, String sql) {
        try {
            ResultSet resultSet = DataBaseConnection.getInstance().getStatement().executeQuery(sql);
            ObservableList<String> observableList = FXCollections.observableArrayList();
            observableList.add("None");
            while (resultSet.next()) {
                observableList.add(resultSet.getString(1));
            }
            comboBox.setItems(observableList);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
