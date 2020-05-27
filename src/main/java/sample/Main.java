package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Быки и Коровы");
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
