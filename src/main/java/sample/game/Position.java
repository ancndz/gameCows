package sample.game;

public class Position {
    private final int digit;
    private boolean isGuessed = false;

    public Position(int digit) {
        this.digit = digit;
    }

    public void setGuessed() {
        isGuessed = true;
    }

    public int getDigit() {
        return digit;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    @Override
    public String toString() {
        return "Position{" +
                "digit=" + digit +
                ", isGuessed=" + isGuessed +
                '}';
    }
}
