package kr.codesquad.controller;

import kr.codesquad.domain.Line;
import kr.codesquad.util.Encoding;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;
import kr.codesquad.util.Validation;
import kr.codesquad.domain.Ladder;

import java.io.IOException;
import java.util.List;

public class LadderGame {
    private Validation validation;
    private Ladder ladder;
    private Encoding encoding;

    public LadderGame() {
        this.ladder = new Ladder(new Line());
        this.validation = new Validation();
        this.encoding = new Encoding();
    }

    public void run() throws IOException {
        OutputView.printMessageNames();
        String names = InputView.inputNames();

        OutputView.printMessageLadderNumber();
        String ladderNumber = InputView.inputLadderNumber();



        List<List<String>> ladders =
                ladder.makeLadder(validation.validateInputNames(names), validation.validateInputLadderNumber(ladderNumber));

        String result = encoding.encodeLadder(ladders);
        OutputView.printLadder(result);
    }
}
