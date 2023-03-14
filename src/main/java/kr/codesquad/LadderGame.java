package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.Input;
import kr.codesquad.view.Output;

import java.io.IOException;

public class LadderGame {
    private Input input;
    private Output output;

    public LadderGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() throws IOException {
        int numberOfPlayer = input.countPlayerNum();
        int maximumHeight = input.countMaxHeight();
        Ladder ladder = new Ladder(numberOfPlayer, maximumHeight);
        String finishedLadder = ladder.toString();
        output.printLadder(finishedLadder);
    }

}
