package sample.game;

public class Stage {
    private Move playerOneMove;
    private Move playerTwoMove;

    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    private int playerOneCows = 0;
    private int playerTwoCows = 0;


    Stage(){}

    public Move getPlayerOneMove() {
        return playerOneMove;
    }

    public void setPlayerOneMove(Move playerOneMove) {
        this.playerOneMove = playerOneMove;
    }

    public Move getPlayerTwoMove() {
        return playerTwoMove;
    }

    public void setPlayerTwoMove(Move playerTwoMove) {
        this.playerTwoMove = playerTwoMove;
    }

    public SecretCombination PlayerOneMove() {
        SecretCombination ans = this.playerOneMove.MakeMove();
        this.playerOnePoints = this.playerOneMove.getPoints();
        this.playerOneCows = this.playerOneMove.getCows();
        return ans;
    }

    public SecretCombination PlayerTwoMove() {
        SecretCombination ans = this.playerTwoMove.MakeMove();
        this.playerTwoPoints = this.playerTwoMove.getPoints();
        this.playerTwoCows = this.playerTwoMove.getCows();
        return ans;
    }

    public int getPlayerOnePoints() {
        return playerOnePoints;
    }

    public int getPlayerTwoPoints() {
        return playerTwoPoints;
    }

    @Override
    public String toString() {
        return "Этап:\n\t" +
                playerOneMove + "\n\t" +
                playerTwoMove +"\n\t" +
                playerOneMove.getPlayerName() + " очки = " + playerOnePoints +"\n\t" +
                playerTwoMove.getPlayerName() + " очки = " + playerTwoPoints +"\n\n";
    }
}
