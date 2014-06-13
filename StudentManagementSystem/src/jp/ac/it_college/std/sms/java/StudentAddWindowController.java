package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudentAddWindowController extends BaseController {
    public static final String TITLE = "学生追加";
    public static final String WINDOW_FXML_NAME = "StudentAddWindow";
    @FXML private AnchorPane studentAddWindow;

    public void Close() {
        Stage stage = (Stage) studentAddWindow.getScene().getWindow();
        stage.close();
    }
}
