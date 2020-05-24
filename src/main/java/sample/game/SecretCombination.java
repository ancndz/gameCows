package sample.game;

import java.util.ArrayList;
import java.util.List;

public class SecretCombination {
    private final List<Position> combination;
    private int rightPositions = 0;

    public SecretCombination(List<Integer> rawList) {
        this.combination = new ArrayList<>();
        for (Integer integer : rawList) {
            this.combination.add(new Position(integer));
        }
    }

    public int guess(List<Integer> guessingList) {
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
        this.rightPositions = rightPositions.size();
        //System.out.println(this.toString());
        return count;
    }

    public int getRightPositions() {
        return rightPositions;
    }

    public int getSize() {
        return this.combination.size();
    }

    @Override
    public String toString() {
        return "SecretCombination{" +
                "combination=" + combination +
                ", rightPositions=" + rightPositions +
                '}';
    }
}
