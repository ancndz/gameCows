package sample.game;

import java.util.List;

public class Stage {
    private final Player playerOne;
    private final Player playerTwo;

    private List<Integer> playerOneGuessingList;
    private List<Integer> playerTwoGuessingList;

    private int playerOneCows = 0;
    private int playerOneBulls = 0;
    private int playerTwoCows = 0;
    private int playerTwoBulls = 0;

    public Stage(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void playerOneMove(List<Integer> hisGuessingList) {
        this.playerOneGuessingList = hisGuessingList;
        this.playerOneCows = this.playerTwo.getSecretCombination().guess(hisGuessingList);
        this.playerOneBulls = this.playerTwo.getSecretCombination().getRightPositions();
        this.playerOne.addScore(playerOneBulls);
    }

    public void playerTwoMove(List<Integer> hisGuessingList) {
        this.playerTwoGuessingList = hisGuessingList;
        this.playerTwoCows = this.playerOne.getSecretCombination().guess(hisGuessingList);
        this.playerTwoBulls = this.playerOne.getSecretCombination().getRightPositions();
        this.playerTwo.addScore(playerTwoBulls);
    }

    public int getPlayerOneCows() {
        return playerOneCows;
    }

    public int getPlayerTwoCows() {
        return playerTwoCows;
    }

    public int getPlayerOneBulls() {
        return playerOneBulls;
    }

    public int getPlayerTwoBulls() {
        return playerTwoBulls;
    }

    @Override
    public String toString() {
        return "Ход: " +
                "\n\tИгрок 1: " + playerOne +
                "\n\t\tЗагадал: " + playerOneGuessingList +
                "\n\t\tПолучил коров: " + playerOneCows + " коров(ы/у)" +
                "\n\t\tПолучил быков: " + playerOneBulls + " быка(ов)" +
                "\n\tИгрок 2: " + playerTwo +
                "\n\t\tЗагадал: " + playerTwoGuessingList +
                "\n\t\tПолучил коров: " + playerTwoCows + " коров(ы/у)" +
                "\n\t\tПолучил быков: " + playerTwoBulls + " быка(ов)" +
                "\nСчет первого игрока: " + playerOne.getScore() +
                "\nСчет второго игрока: " + playerTwo.getScore() + "\n"/* +
                playerOne.getSecretCombination().toString() + "\n" +
                playerTwo.getSecretCombination().toString()*/;
    }
}
