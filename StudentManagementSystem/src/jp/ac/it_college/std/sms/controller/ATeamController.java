package jp.ac.it_college.std.sms.controller;

public class ATeamController extends BaseController {
    public static final String TITLE = "A-Team";
    public static final String FXML = "A_TEAM";

    public void backHandle() {
        main.changeScene(main.getPrimaryStage(), LoginWindowController.TITLE, LoginWindowController.FXML);
    }
}
