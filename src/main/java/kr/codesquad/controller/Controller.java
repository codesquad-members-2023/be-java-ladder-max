package kr.codesquad.controller;

import kr.codesquad.domain.Line;
import kr.codesquad.util.Encoding;
import kr.codesquad.view.Input;
import kr.codesquad.view.Output;
import kr.codesquad.util.Validation;
import kr.codesquad.domain.Ladder;

import java.io.IOException;
import java.util.List;

public class Controller {

    private Output output;
    private Input input;
    private Validation validation;
    private Ladder ladder;
    private Encoding encoding;

    public Controller() {
        this.ladder = new Ladder(new Line());
        this.output = new Output();
        this.validation = new Validation();
        this.input = new Input();
        this.encoding = new Encoding();
    }

    public void run() throws IOException {
        output.printMessageNames();
        String names = input.inputNames();

        output.printMessageLadderNumber();
        String ladderNumber = input.inputLadderNumber();

        List<List<String>> ladders = ladder.makeLadder(validation.validateInputNames(names), validation.validateInputM(ladderNumber));

        String result = encoding.encodeLadder(ladders);
        output.printLadder(result);
    }
}
