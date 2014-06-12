package jp.ac.it_college.std.sms.java;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PassWordChangeWindowController extends BaseController {
    @FXML private AnchorPane passWordChangeWindow;

    public void Close() {
        Stage stage = (Stage) passWordChangeWindow.getScene().getWindow();
        stage.close();
    }
}
