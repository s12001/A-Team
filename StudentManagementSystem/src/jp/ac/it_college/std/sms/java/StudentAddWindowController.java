package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudentAddWindowController extends BaseController {
    @FXML private AnchorPane studentAddWindow;

    public void Close() {
        Stage stage = (Stage) studentAddWindow.getScene().getWindow();
        stage.close();
    }
}
