package sample;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.game.Game;

public class Controller {

    private Game game;
    private int codeLen = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tabPvP;

    @FXML
    private Button newGameButton;

    @FXML
    private TextField secondPlayerCode;

    @FXML
    private Button doneStageButton;

    @FXML
    private TextField firstPlayerCode;

    @FXML
    private Tab tabPvE;

    @FXML
    private Label playerOneName;

    @FXML
    private Label playerTwoName;

    @FXML
    private TextArea history;

    @FXML
    private Label errorText;

    @FXML
    private Button newGameButtonPVE;

    @FXML
    private TextArea historyPVE;

    @FXML
    private Button doneStageButtonPVE;

    @FXML
    private TextField playerCode;

    @FXML
    private Label playerName;

    @FXML
    private Label errorText1;

    @FXML
    void nextStage(ActionEvent event) {
        List<Integer> playerOneGuess = stringToList(this.firstPlayerCode.getText());
        List<Integer> playerTwoGuess = stringToList(this.secondPlayerCode.getText());
        if (playerOneGuess.size() == this.codeLen && playerTwoGuess.size() == this.codeLen) {
            this.errorText.setText("");
            this.game.newStage(playerOneGuess, playerTwoGuess);
            String history = this.game.getHistory();
            System.out.println(history);
            this.history.setText(history);
            this.firstPlayerCode.clear();
            this.secondPlayerCode.clear();
        } else {
            this.errorText.setText("Ошибка! Введите предположения длины " + this.codeLen);
        }
    }

    @FXML
    void nextStagePVE(ActionEvent event) {

    }


    private List stringToList(String s) {
        if (!s.isEmpty()) {
            try {
                Integer.parseInt(s);
                return Arrays.stream(s.split("\\B"))
                        .map(Integer::valueOf).collect(Collectors.toList());
            } catch (Exception e) {
                return Collections.EMPTY_LIST;
            }
        } else {
            return Collections.EMPTY_LIST;
        }
    }


    @FXML
    void initNewGame(ActionEvent event) throws IOException {
        System.out.println("New Game started...");
        ((Button)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("names.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void initNewGamePVE(ActionEvent event) throws IOException {
    }

    void startNewGame(String playerOneName, String playerTwoName,
                      List<Integer> playerOneCode, List<Integer> playerTwoCode) {
        this.game = new Game(playerOneName, playerTwoName,
                playerOneCode, playerTwoCode);
        this.codeLen = playerOneCode.size();
        System.out.println("Game Size: " + this.codeLen);
        this.playerOneName.setText(playerOneName);
        this.playerTwoName.setText(playerTwoName);

        this.doneStageButton.setDisable(false);
        this.firstPlayerCode.setDisable(false);
        this.secondPlayerCode.setDisable(false);

        System.out.println("Game Ready!");
    }

    @FXML
    void initialize() {
        System.out.println("Init...");
        this.doneStageButton.setDisable(true);
        this.firstPlayerCode.setDisable(true);
        this.secondPlayerCode.setDisable(true);
    }
}
