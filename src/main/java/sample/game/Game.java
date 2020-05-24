package sample.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Player playerOne;
    private final Player playerTwo;

    private int gameLength;
    private final List<Stage> stages;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.stages = new ArrayList<>();
    }

    public Result nextStage(List<Integer> playerOneGuessingList, List<Integer> playerTwoGuessingList) {
        Stage stage = new Stage(this.playerOne, this.playerTwo);
        stage.playerOneMove(playerOneGuessingList);
        stage.playerTwoMove(playerTwoGuessingList);
        this.stages.add(stage);
        return new Result(stage.getPlayerOneCows(), stage.getPlayerOneBulls(), stage.getPlayerTwoCows(), stage.getPlayerTwoBulls());
    }

    public String getHistory() {
        StringBuilder history = new StringBuilder("");
        for (int i = 0; i < stages.size(); i++) {
            history.append("#").append(i).append(" ").append(stages.get(i).toString());
        }
        return history.toString();
    }

    public Result nextStagePVE(List<Integer> stringToList) {
        System.out.println(stringToList);
        return nextStage(stringToList, ((GameBot) this.playerTwo).getPrediction());
    }
}
