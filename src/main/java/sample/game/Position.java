package sample.game;

public class Position {
    //private int position;
    private int digit;
    private boolean isGuessed = false;

    /*public Position(int digit, int position) {
        this.digit = digit;
        this.position = position;
    }*/

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

    /*public int getPosition() {
        return position;
    }*/
}
