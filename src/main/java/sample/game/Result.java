package sample.game;

public class Result {
    private final int playerOneCows;
    private final int playerOneBulls;
    private final int playerTwoCows;
    private final int playerTwoBulls;

    public Result(int playerOneCows, int playerOneBulls, int playerTwoCows, int playerTwoBulls) {
        this.playerOneCows = playerOneCows;
        this.playerOneBulls = playerOneBulls;
        this.playerTwoCows = playerTwoCows;
        this.playerTwoBulls = playerTwoBulls;
    }

    public int getPlayerOneCows() {
        return playerOneCows;
    }

    public int getPlayerOneBulls() {
        return playerOneBulls;
    }

    public int getPlayerTwoCows() {
        return playerTwoCows;
    }

    public int getPlayerTwoBulls() {
        return playerTwoBulls;
    }

    @Override
    public String toString() {
        return "\nИгрок 1:" +
                "\n\tПолучил коров: " + playerOneCows + " коров(ы/у)" +
                "\n\tПолучил быков: " + playerOneBulls + " быка(ов)" +
                "\nИгрок 2" +
                "\n\tПолучил коров: " + playerTwoCows + " коров(ы/у)" +
                "\n\tПолучил быков: " + playerTwoBulls + " быка(ов)";
    }
}
