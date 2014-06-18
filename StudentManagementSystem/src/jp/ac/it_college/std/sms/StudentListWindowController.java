package jp.ac.it_college.std.sms;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class StudentListWindowController extends BaseController {
    public static final String TITLE = "学生一覧画面";
    public static final String FXML = "StudentListWindow";
    @FXML private ComboBox departmentComboBox;
    @FXML private ComboBox schoolGradeComboBox;
    @FXML private TableView studentTableView;
    @FXML private TableColumn idColumn;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn schoolGradeColumn;
    @FXML private TableColumn departmentColumn;

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
}
