package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NameController {

    private boolean isPVE;

    public void setPVE(boolean PVE) {
        isPVE = PVE;
        if (PVE) {
            this.secondPlayerName.appendText("Бездушная Машина");
            this.secondPlayerName.setEditable(false);
        }
    }

    @FXML
    private Button nextStepButton;

    @FXML
    private TextField firstPlayerName;

    @FXML
    private TextField secondPlayerName;

    @FXML
    private Button backButton;

    @FXML
    private Label errorLabel;

    @FXML
    void initialize() {
    }

    @FXML
    void backToMain(ActionEvent event) throws IOException {
        ((Button)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
        loader.load();
        Parent root = loader.getRoot();

        Stage stage = new Stage();
        stage.setTitle("Быки и Коровы");
        stage.setScene(new Scene(root));
        stage.setOnCloseRequest(e -> Platform.exit());
        stage.show();
    }


    @FXML
    void codesStep(ActionEvent event) throws IOException {
        String firstPlayerNameString = firstPlayerName.getText().trim();
        System.out.println("Player One name:" + firstPlayerNameString);
        String secondPlayerNameString = secondPlayerName.getText().trim();
        System.out.println("Player Two name:" + secondPlayerNameString);

        if (!firstPlayerNameString.equals("") && !secondPlayerNameString.equals("")) {
            ((Button)event.getSource()).getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("codes.fxml"));
            loader.load();
            Parent root = loader.getRoot();

            CodeController codeController = loader.getController();
            codeController.getPlayerNames(firstPlayerNameString, secondPlayerNameString);
            codeController.setPVE(this.isPVE);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Быки и Коровы: НОВАЯ ИГРА");
            stage.setOnCloseRequest(e -> Platform.exit());
            stage.show();
        } else {
            this.errorLabel.setText("Введите имена!");
        }
    }
}
