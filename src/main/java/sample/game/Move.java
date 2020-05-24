package sample.game;


import java.util.List;

public class Move {
    /**
     * @return opponent new combination
     */
    public int MakeMove(SecretCombination playerSecret, List<Integer> playerGuessedList) {
        return playerSecret.guess(playerGuessedList);
    }
}
