package sample.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretCombination {
    private final List<Position> combination;

    SecretCombination(List<Integer> rawList) {
        this.combination = new ArrayList<>();
        for (Integer integer : rawList) {
            this.combination.add(new Position(integer));
        }
    }

    public List<Position> getGuessedPositions() {
        List<Position> positionList = new ArrayList<>();
        for (Position pos: this.combination) {
            if (pos.isGuessed()) {
                positionList.add(pos);
            }
        }
        return positionList;
    }

    public int[] guess(List<Integer> guessingList) {
        List<Position> rightPositions = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < this.combination.size(); i++) {
            if (guessingList.get(i) == this.combination.get(i).getDigit()
                    && !this.combination.get(i).isGuessed()) {
                this.combination.get(i).setGuessed();
                rightPositions.add(this.combination.get(i));
            }
            for (Integer integer : guessingList) {
                if (this.combination.get(i).getDigit() == integer) {
                    count += 1;
                }
            }
        }

        return new int[]{rightPositions.size(), count};
        //return rightPositions;
    }

    public List<Position> getCombination() {
        return combination;
    }
}
