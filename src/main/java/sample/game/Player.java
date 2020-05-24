package sample.game;

import java.util.List;

public class Player {
    private final SecretCombination secretCombination;
    private final String name;
    private int score = 0;
    private final int maxScore;
    private boolean winner = false;

    public Player(SecretCombination secretCombination, String name, int maxScore) {
        this.secretCombination = secretCombination;
        this.name = name;
        this.maxScore = maxScore;
    }


    /**
     * @param value
     * @return true if winner
     */
    public boolean addScore(int value) {
        this.score += value;
        this.winner = (this.maxScore == this.score);
        return this.winner;
    }

    public SecretCombination getSecretCombination() {
        return secretCombination;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return name;
    }
}
