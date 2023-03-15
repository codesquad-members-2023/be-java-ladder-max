package kr.codesquad;

import kr.codesquad.view.InputInformation;
import kr.codesquad.view.OutputInformation;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        InputInformation inputInformation = new InputInformation();
        OutputInformation outputInformation = new OutputInformation();

        LadderGame ladderGame = new LadderGame(inputInformation, outputInformation);
        ladderGame.run();
    }
}