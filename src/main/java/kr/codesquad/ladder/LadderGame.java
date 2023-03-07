package kr.codesquad.ladder;

import static kr.codesquad.ladder.view.OutputView.printString;

import java.io.IOException;
import java.util.List;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.view.InputView;

public class LadderGame {

    private final InputView inputView = new InputView();
    private Ladder ladder;

    public void run() throws IOException {
        List<String> names = inputView.inputNames();
        int height = inputView.inputHeight();

        ladder = Ladder.createLadder(height, names.size() - 1);
        printString(Names.createNames(names).toString());
        printString(ladder.toString());
    }
}
