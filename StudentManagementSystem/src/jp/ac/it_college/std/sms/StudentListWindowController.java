package jp.ac.it_college.std.sms;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentListWindowController extends BaseController implements Initializable {
    public static final String TITLE = "学生一覧画面";
    public static final String FXML = "StudentListWindow";
    @FXML private ComboBox<String> departmentComboBox;
    @FXML private ComboBox<String> schoolGradeComboBox;
    @FXML private TableView<Student> studentTableView;
    @FXML private TableColumn<Student, String> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, Integer> schoolGradeColumn;
    @FXML private TableColumn<Student, String> departmentColumn;

    private static final String GET_DEPARTMENT_SQL =
            "select distinct ifnull(concat(department.name,' ',department.course_name), department.name)\n" +
            "from student, department\n" +
            "where student.department_id = department.id";
    private static final String GET_SCHOOLGRADE_SQL =
            "select distinct school_grade from student;";

    private static final String GET_STUDENT_SQL =
            "select student.id, concat(student.last_name,' ',student.first_name),\n" +
            "student.school_grade, ifnull(concat(department.name,' ',department.course_name), department.name)\n" +
            "from student, department\n" +
            "where student.department_id = department.id\n";

    private static final String WHERE_DEPATMENT_SQL = "and ifnull(concat(department.name,' ',department.course_name), department.name) = ";
    private static final String WHERE_SCHOOLGRADE_SQL = "and school_grade = ";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setComboBox(schoolGradeComboBox, DatabaseHelper.getInstance().getPreparedStatement(GET_SCHOOLGRADE_SQL));
        setComboBox(departmentComboBox, DatabaseHelper.getInstance().getPreparedStatement(GET_DEPARTMENT_SQL));

        setTableViewItems(GET_STUDENT_SQL);

        schoolGradeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
        });

        departmentComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
        });

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        schoolGradeColumn.setCellValueFactory(new PropertyValueFactory<>("schoolGrade"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableView.TableViewSelectionModel<Student> selectionModel = studentTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((Observable observable) -> {
            if (selectionModel.getSelectedItem() != null) {
                main.changeScene(main.getPrimaryStage(), StudentDetailWindowController.TITLE, StudentDetailWindowController.FXML);
            }
        });
    }

    public void studentAddHandle() {
        main.changeScene(new Stage(), StudentAddWindowController.TITLE, StudentAddWindowController.FXML);
    }

    public void endHandle() {
        main.getPrimaryStage().close();
    }

    public void logoutHandle() {
        main.changeScene(main.getPrimaryStage(), LoginWindowController.TITLE, LoginWindowController.FXML);
    }

    public void attendanceHandle() {
        main.changeScene(new Stage(), AttendanceWindowController.TITLE, AttendanceWindowController.FXML);
    }

    private void setTableViewItems(String sql) {
        try {
            ResultSet resultSet = DatabaseHelper.getInstance().getStatement().executeQuery(sql);
            ArrayList<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)
                ));
            }
            studentTableView.getItems().addAll(students);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
