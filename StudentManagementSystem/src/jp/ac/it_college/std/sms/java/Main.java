package jp.ac.it_college.std.sms.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage mPrimaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mPrimaryStage = primaryStage;
        mPrimaryStage.setResizable(false);
        mPrimaryStage.resizableProperty().setValue(false);
        changeScene(mPrimaryStage, "ログイン", "LoginWindow");
    }

    public void changeScene(Stage stage, String title, String fxml) {
        try {
            stage.setTitle(title);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/" + fxml + ".fxml"));
            Pane pane = loader.load();
            BaseController controller = loader.getController();
            controller.setMain(this);
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return mPrimaryStage;
    }
}
