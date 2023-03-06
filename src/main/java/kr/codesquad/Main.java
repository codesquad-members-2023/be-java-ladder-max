package kr.codesquad;

import java.io.IOException;
import kr.codesquad.ladder.InputView;
import kr.codesquad.ladder.Ladder;
import kr.codesquad.ladder.LadderGame;

public class Main {
    public static void main(String[] args) throws IOException {
        LadderGame ladderGame = new LadderGame();
        ladderGame.setLadder();
        ladderGame.startLadder();
    }
}