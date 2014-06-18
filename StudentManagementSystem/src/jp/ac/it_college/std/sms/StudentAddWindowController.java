package jp.ac.it_college.std.sms;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentAddWindowController extends BaseController {
    public static final String TITLE = "学生追加画面";
    public static final String FXML = "StudentAddWindow";
    @FXML private TextField idTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField firstNameTextField;
    @FXML private ComboBox departmentComboBox;
    @FXML private ComboBox schoolGradeComboBox;

    public void closeHandle() {
        Stage stage = (Stage) idTextField.getScene().getWindow();
        stage.close();
    }

    public void studentAddHandle() {
    }
}
