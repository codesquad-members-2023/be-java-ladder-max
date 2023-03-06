package kr.codesquad;

public class LadderGame {
    private final int playerNumber;

    private LadderGame(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public LadderGame() {
        this(Screen.inputPlayerNumber());
    }

}
