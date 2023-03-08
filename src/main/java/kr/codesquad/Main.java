package kr.codesquad;

import java.io.IOException;

public class Main {
    static OutputView outputView;
    static InputView inputView;
    public static void main(String[] args) throws IOException {
        int countOfUser = getCountOfUser();
        int heightOfLadder = getHeightOfLadder();
    }
    public static int getCountOfUser() {
        outputView.inputPeople();
        return Integer.parseInt(inputView.getInput());
    }
    public static int getHeightOfLadder() {
        outputView.inputLadder();
        return Integer.parseInt(inputView.getInput());
    }
}
