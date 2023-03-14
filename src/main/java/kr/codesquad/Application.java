package kr.codesquad;

import kr.codesquad.view.Input;
import kr.codesquad.view.Output;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Output output = new Output();

        LadderGame ladderGame = new LadderGame(input, output);
        ladderGame.run();
    }
}