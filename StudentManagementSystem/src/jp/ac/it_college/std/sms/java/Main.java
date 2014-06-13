package jp.ac.it_college.std.sms.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class Main extends Application {
    private Stage mPrimaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mPrimaryStage = primaryStage;
        changeScene(mPrimaryStage, "ログイン", "LoginWindow");
    }

    public void changeScene(Stage stage, String title, String fxml) {
        Pane pane = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/" + fxml + ".fxml"));

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle(title);
        stage.setResizable(false);
        stage.resizableProperty().setValue(false);
        BaseController controller = loader.getController();
        controller.setMain(this);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public Stage getPrimaryStage() {
        return mPrimaryStage;
    }
}
