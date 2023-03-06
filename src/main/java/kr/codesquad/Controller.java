package kr.codesquad;

import java.io.IOException;

public class Controller {

    private Output output;
    private Input input;
    private Validation validation;

    public void run() throws IOException {
        output.printMessageN();
        String n = input.inputN();
        output.printMessageM();
        String m = input.inputM();
        int[] input = validation.validationInput(n, m);
    }
}
