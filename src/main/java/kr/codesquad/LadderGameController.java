package kr.codesquad;

import kr.codesquad.util.InputOutputManager;

import java.io.IOException;
import java.util.ArrayList;

public class LadderGameController {
    InputOutputManager manager = new InputOutputManager();
    void startLadderGame() throws IOException {
        ArrayList<Integer> arrForHeightAndWidth = getHeightAndWidth();
        Ladder ladder = makeLadder(arrForHeightAndWidth);
        printLadder(ladder);
    }

    Ladder makeLadder(ArrayList<Integer> arrForHeightAndWidth){
        return new Ladder(arrForHeightAndWidth);
    }

    ArrayList<Integer> getHeightAndWidth() throws IOException {
        return manager.getInputFromUser();
    }

    void printLadder(Ladder ladder){
        manager.printLadder(ladder);
    }
}
