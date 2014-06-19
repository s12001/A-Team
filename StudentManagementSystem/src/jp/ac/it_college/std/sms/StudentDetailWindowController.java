package jp.ac.it_college.std.sms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentDetailWindowController extends BaseController implements Initializable {
    public static final String TITLE = "学生詳細画面";
    public static final String FXML = "StudentDetailWindow";
    @FXML private TextField idTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField schoolGradeTextField;
    @FXML private TextField departmentTextField;
    @FXML private ComboBox statusComboBox;
    @FXML private TextField timeTextField;
    @FXML private TextField needTimeTextField;
    @FXML private TableView resultTable;
    @FXML private TableColumn subjectColumn;
    @FXML private TableColumn scoreColumn;
    @FXML private TableView examTable;
    @FXML private TableColumn certificationColumn;
    @FXML private TableColumn dateColumn;
    @FXML private TableColumn resultColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void editHandle() {
    }

    public void addResultHandle() {
    }

    public void deleteResultHandle() {
    }

    public void updateResultHandle() {
    }

    public void addExamHandle() {
    }

    public void deleteExamHandle() {
    }

    public void updateExamHandle() {
    }

    public void backHandle() {
        main.changeScene(main.getPrimaryStage(), StudentListWindowController.TITLE, StudentListWindowController.FXML);
    }
}
