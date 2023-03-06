package kr.codesquad;

import kr.codesquad.util.InputOutputManager;

import java.io.IOException;

public class LadderController {
    void startLadderGame() throws IOException {
        Ladder ladder = new Ladder();
        InputOutputManager manager = new InputOutputManager(ladder);
        ladder.makeLadder();
        manager.printLadder(ladder);
    }
}
