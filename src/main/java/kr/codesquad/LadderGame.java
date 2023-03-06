package kr.codesquad;

import java.util.Scanner;

public class LadderGame {
    private final int playerNumber;
    private final int ladderHeight;

    private LadderGame(int playerNumber, int ladderHeight) {
        this.playerNumber = playerNumber;
        this.ladderHeight = ladderHeight;
    }

    public LadderGame() {
        this(Screen.inputPlayerNumber(), Screen.inputLadderHeight());
    }

}
