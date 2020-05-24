package sample.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBot extends Player {
    Verifier verifier = new Verifier();
    public GameBot(SecretCombination secretCombination, int maxScore) {
        super(secretCombination, "Бездушная Машина", maxScore);
    }

    public List<Integer> getPrediction() {
        return verifier.getRandomList(this.getSecretCombination().getSize());
    }
}
