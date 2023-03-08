package kr.codesquad.controller;

import kr.codesquad.model.Users;
import kr.codesquad.util.Encoding;
import kr.codesquad.view.Input;
import kr.codesquad.view.Output;
import kr.codesquad.util.Validation;
import kr.codesquad.model.Ladder;

import java.io.IOException;

public class Controller {

    private Output output;
    private Input input;
    private Validation validation;
    private Ladder ladder;
    private Encoding encoding;

    public Controller() {
        this.ladder = new Ladder();
        this.output = new Output();
        this.validation = new Validation();
        this.input = new Input();
        this.encoding = new Encoding();
    }

    public void run() throws IOException {
        output.printMessageN();
        String names = input.inputNames();

        int afterN = validation.validateInputN(names);
        output.printMessageM();
        String m = input.inputM();
        int afterM = validation.validateInputM(m);

        String[][] ladders = ladder.makeLadder(afterN, afterM);
        String result = encoding.encodeLadder(ladders);
        output.printLadder(result);
    }
}
