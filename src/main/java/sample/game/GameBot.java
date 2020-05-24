package sample.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBot extends Player {
    public GameBot(SecretCombination secretCombination, int maxScore) {
        super(secretCombination, "Бездушная Машина", maxScore);
    }

    public List<Integer> getPrediction() {
        List<Integer> newPrediction = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < this.getSecretCombination().getSize(); i++) {
            newPrediction.add(random.nextInt(9));
        }
        return newPrediction;
    }
}
