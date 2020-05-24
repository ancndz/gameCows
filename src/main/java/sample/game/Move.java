package sample.game;


import java.util.List;

public class Move {
    private final String playerName;
    private final SecretCombination opponentSecretCombination;
    private final List<Integer> playerGuessedList;
    private int playerPoints;
    private int playerCows;

    public Move(String playerName, SecretCombination opponentSecretCombination, List<Integer> playerGuessedList) {
        this.playerName = playerName;
        this.opponentSecretCombination = opponentSecretCombination;
        this.playerGuessedList = playerGuessedList;
    }

    /**
     * @return opponent new combination
     */
    public SecretCombination MakeMove() {
        int[] result = this.opponentSecretCombination.guess(this.playerGuessedList);
        this.playerPoints = result[0];
        this.playerCows = result[1];
        return this.opponentSecretCombination;
    }

    public int getPoints() {
        return playerPoints;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "Ход: \n\t" +
                playerName + " предположил: " + playerGuessedList +
                "\n\t\t БЫКОВ = " + playerPoints +
                "\n\t\t КОРОВ = " + playerCows +
                '\n';
    }

    public int getCows() {
        return playerCows;
    }
}
