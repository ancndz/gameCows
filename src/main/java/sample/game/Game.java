package sample.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int codeLength;
    private String PlayerOneName;
    private String PlayerTwoName;

    private int playerOneTotalPoints = 0;
    private int playerTwoTotalPoints = 0;

    private SecretCombination playerOneSecret;
    private SecretCombination playerTwoSecret;

    private int stageNum = 1;

    private List<Stage> stages;

    public Game(String playerOneName, String playerTwoName, List<Integer> playerOneSecret, List<Integer> playerTwoSecret) {
        PlayerOneName = playerOneName;
        PlayerTwoName = playerTwoName;
        this.playerOneSecret = new SecretCombination(playerOneSecret);
        this.playerTwoSecret = new SecretCombination(playerTwoSecret);
        this.codeLength = playerOneSecret.size();
        this.stages = new ArrayList<>();
    }

    public String newStage(List<Integer> playerOneGuessList, List<Integer> playerTwoGuessList) {
        if (playerOneGuessList.size() != this.codeLength || playerTwoGuessList.size() != this.codeLength) {
            return "Wrong guess length!";
        }
        Move playerOneMove = new Move(this.PlayerOneName, playerTwoSecret, playerOneGuessList);
        Move playerTwoMove = new Move(this.PlayerTwoName, playerOneSecret, playerTwoGuessList);

        Stage stage = new Stage();
        stage.setPlayerOneMove(playerOneMove);
        stage.setPlayerTwoMove(playerTwoMove);

        this.playerTwoSecret = stage.PlayerOneMove();
        this.playerOneSecret = stage.PlayerTwoMove();

        stages.add(stage);

        this.playerOneTotalPoints += stage.getPlayerOnePoints();
        this.playerTwoTotalPoints += stage.getPlayerTwoPoints();

        StringBuilder history = new StringBuilder();
        history.append("#").append(stageNum++).append(" ").append(stage.toString());

        if (this.playerOneTotalPoints == codeLength) {
            history.append(String.format("\n~~~~~Игрок %s победил!~~~~~\n", this.PlayerOneName));
        }
        if (this.playerTwoTotalPoints == codeLength) {
            history.append(String.format("\n~~~~~Игрок %s победил!~~~~~\n", this.PlayerTwoName));
        }

        return history.toString();
    }

    public String getHistory() {
        StringBuilder history = new StringBuilder();
        for (int i = 0; i < this.stages.size(); i++) {
            history.append("#").append(i).append(" ").append(this.stages.get(i).toString());
        }
        history.append("СЧЕТ ИГРЫ: ").append(this.playerOneTotalPoints).append(":").append(this.playerTwoTotalPoints);
        return history.toString();
    }


}
