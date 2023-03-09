package Ladder2.domain;

import Ladder2.view.Input;
import Ladder2.view.Output;

import java.io.IOException;

public class LadderHeight {

    private int height;

    public LadderHeight() throws IOException {
        this.getHeightFromUser();

    }
    public int getHeight() {
        return this.height;
    }

    private void getHeightFromUser() throws IOException {
        Input input = new Input();
        Output output = new Output();
        output.promptGetHeight();
        String heightString = input.getInputFromUser();
        this.height = this.intValidation(heightString);
    }


    private Integer intValidation(String input) {
        if (isInt(input)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException("정수만 입력해 주세요.");
    }

    private boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }


}
