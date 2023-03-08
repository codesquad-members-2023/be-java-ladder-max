package kr.codesquad.ladder;

import static kr.codesquad.ladder.OutputView.printString;

import java.io.IOException;

public class LadderGame {

    private final InputView inputView = new InputView();
    private Ladder ladder;

    public void run() throws IOException {
        String[] names = inputView.inputNames();
        int height = inputView.inputHeight();

        ladder = Ladder.createLadder(height, names.length - 1);
        printString(Names.createNames(names).toString());
        printString(ladder.toString());
    }
}
