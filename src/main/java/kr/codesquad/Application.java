package kr.codesquad;

import kr.codesquad.view.InputInformation;
import kr.codesquad.view.OutputLadder;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        InputInformation inputInformation = new InputInformation();
        OutputLadder outputLadder = new OutputLadder();

        LadderGame ladderGame = new LadderGame(inputInformation, outputLadder);
        ladderGame.run();
    }
}