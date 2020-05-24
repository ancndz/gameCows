package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CodeController {

    private String firstPlayerName;
    private String secondPlayerName;

    private boolean isPVE = false;

    public void setPVE(boolean PVE) {
        isPVE = PVE;
        if (PVE) {
            this.secondPlayerCode.setEditable(false);
        }
    }

    @FXML
    private Button startGameButton;

    @FXML
    private PasswordField firstPlayerCode;

    @FXML
    private PasswordField secondPlayerCode;

    @FXML
    private Label playerOneName;

    @FXML
    private Label playerTwoName;

    @FXML
    private Button backButton;

    @FXML
    private Label errorLabel;

    @FXML
    void initialize() {
        System.out.println("Init codes inputs...");
    }

    @FXML
    void backToMain(ActionEvent event) throws IOException {
        ((Button)event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
        loader.load();
        Parent root = loader.getRoot();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }


    @FXML
    void startGame(ActionEvent event) throws IOException {

        List<Integer> firstPlayerCodeList = stringToList(firstPlayerCode.getText().trim());
        System.out.println("Player One code:" + firstPlayerCode.getText().trim());
        List<Integer> secondPlayerCodeList;
        if (!this.isPVE) {
            secondPlayerCodeList = stringToList(secondPlayerCode.getText().trim());
            System.out.println("Player Two code:" + secondPlayerCode.getText().trim());
        } else {
            secondPlayerCodeList = getRandomList(firstPlayerCodeList.size());
        }


        System.out.println("lengths:" + firstPlayerCodeList.size() +", "+ secondPlayerCodeList.size());

        if (!firstPlayerCodeList.isEmpty() &&
                !secondPlayerCodeList.isEmpty() &&
                    secondPlayerCodeList.size() == firstPlayerCodeList.size()) {
            ((Button) event.getSource()).getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
            loader.load();
            Parent root = loader.getRoot();

            Controller controller = loader.getController();
            if (this.isPVE) {
                controller.setSecondTab();
            }
            controller.startNewGame(firstPlayerName, secondPlayerName, firstPlayerCodeList, secondPlayerCodeList);

            Stage stage = new Stage();
            stage.setTitle("Быки и Коровы");
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            this.errorLabel.setText("Ошибка! Введите числа равной длины.");
        }
    }

    private List<Integer> getRandomList(int size) {
        List<Integer> machineList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            machineList.add(random.nextInt());
        }
        return machineList;
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

    public void getPlayerNames(String firstName, String secondName) {
        this.playerOneName.setText(firstName);
        this.firstPlayerName = firstName;
        this.playerTwoName.setText(secondName);
        this.secondPlayerName = secondName;
    }

}