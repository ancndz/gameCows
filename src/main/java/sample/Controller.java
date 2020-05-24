package sample;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.game.*;

public class Controller {

    private Game gamePVP;
    private Game gamePVE;
    private int codeLen = 0;
    private Result lastResult;
    private Result lastResultPVE;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane tab;

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
    private Label errorText1;
    @FXML
    private Label playerName;

    @FXML
    void nextStage(ActionEvent event) {
        if (tabPvP.isSelected()) {
            this.lastResult = this.gamePVP.nextStage(stringToList(this.firstPlayerCode.getText()), stringToList(this.secondPlayerCode.getText()));
            this.history.setText(this.gamePVP.getHistory());
        } else {
            this.lastResultPVE = this.gamePVE.nextStagePVE(stringToList(this.playerCode.getText()));
            this.historyPVE.setText(this.gamePVE.getHistory());
        }
    }

    private List stringToList(String s) {
        if (!s.isEmpty()) {
            try {
                Integer.parseInt(s);
                return Arrays.stream(s.split("\\B"))
                        .map(Integer::valueOf).collect(Collectors.toList());
            } catch (Exception e) {
                this.errorText.setText("Вводить нужно только числа!");
                this.errorText1.setText("Вводить нужно только числа!");
                return Collections.EMPTY_LIST;
            }
        } else {
            this.errorText.setText("Поля пусты!");
            this.errorText1.setText("Поля пусты!");
            return Collections.EMPTY_LIST;
        }
    }


    @FXML
    void initNewGame(ActionEvent event) throws IOException {
        System.out.println("Init names inputs...");
        clearGame();
        ((Button) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("names.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        if (tabPvP.isSelected()) {
            System.out.println("New Game started...");
        } else {
            System.out.println("New PVE Game started...");
        }
        NameController nameController = loader.getController();
        nameController.setPVE(tabPvE.isSelected());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void clearGame() {
        if (tabPvP.isSelected()) {
            this.history.setText("");
            this.firstPlayerCode.clear();
            this.secondPlayerCode.clear();
            this.playerOneName.setText("");
            this.playerTwoName.setText("");
        } else if (tabPvE.isSelected()) {
            this.historyPVE.setText("");
            this.playerOneName.setText("");
            this.playerCode.clear();
        }
    }


    void startNewGame(String playerOneName, String playerTwoName,
                      List<Integer> playerOneCode, List<Integer> playerTwoCode) {
        this.codeLen = playerOneCode.size();
        Player playerOne = new Player(new SecretCombination(playerOneCode), playerOneName, this.codeLen);
        if (this.tabPvP.isSelected()) {
            Player playerTwo = new Player(new SecretCombination(playerTwoCode), playerTwoName, this.codeLen);
            this.gamePVP = new Game(playerOne, playerTwo);
        } else {
            Player playerTwo = new GameBot(new SecretCombination(playerTwoCode), this.codeLen);
            this.gamePVE = new Game(playerOne, playerTwo);
        }
        gameInit(playerOneName, playerTwoName);
    }

    @FXML
    void initialize() {
        System.out.println("Init...");
        this.doneStageButton.setDisable(true);
        this.firstPlayerCode.setDisable(true);
        this.secondPlayerCode.setDisable(true);
        this.doneStageButtonPVE.setDisable(true);
        this.playerCode.setDisable(true);
        this.history.setDisable(true);
        this.historyPVE.setDisable(true);
    }

    public void setSecondTab(){
        this.tab.getSelectionModel().select(1);
    }

    private void gameInit(String firstPlayerName, String secondPlayerName) {
        System.out.println("Game Size: " + this.codeLen);
        if (!this.tabPvE.isSelected()) {
            this.playerOneName.setText(firstPlayerName);
            this.playerTwoName.setText(secondPlayerName);
            this.doneStageButton.setDisable(false);
            this.firstPlayerCode.setDisable(false);
            this.secondPlayerCode.setDisable(false);
            this.history.setDisable(false);
        } else {
            this.playerName.setText(firstPlayerName);
            this.historyPVE.setDisable(false);
            this.playerCode.setDisable(false);
            this.doneStageButtonPVE.setDisable(false);
        }
        System.out.println("Game Ready!");
    }
}
