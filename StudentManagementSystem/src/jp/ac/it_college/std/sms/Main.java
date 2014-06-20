package jp.ac.it_college.std.sms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private User user;
    private static final String ERROR_FXML_LOAD = "FXMLロードできませんでした";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        user = new User();
        this.primaryStage.setOnCloseRequest(event -> DatabaseHelper.getInstance().close());
        changeScene(this.primaryStage, LoginWindowController.TITLE, LoginWindowController.FXML);
    }

    public void changeScene(Stage stage, String title, String fxml) {
        stage.setTitle(title);
        stage.setResizable(false);
        stage.resizableProperty().setValue(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/" + fxml + ".fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.err.println(ERROR_FXML_LOAD);
        }
        stage.setScene(new Scene(pane));
        BaseController controller = loader.getController();
        controller.setMain(this);
        controller.setUser(user);
        stage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
