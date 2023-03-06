package kr.codesquad;

import java.io.IOException;

public class Controller {

    private Output output;
    private Input input;
    private Validation validation;
    private Ladder ladder;

    public void run() throws IOException {
        output.printMessageN();
        String n = input.inputN();
        int afterN = validation.validationInputN(n);
        output.printMessageM();
        String m = input.inputM();
        int afterM = validation.validationInputM(m);
        String[][] ladders = ladder.makeLadder(afterN, afterM);
    }
}
