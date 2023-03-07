package kr.codesquad;

import kr.codesquad.util.InputOutputManager;

import java.io.IOException;
import java.util.ArrayList;

public class LadderGameController {
    InputOutputManager manager = new InputOutputManager();
    void startLadderGame() throws IOException {
        Ladder ladder = getLadder(getNameAndHeightFromManager());
        printLadder(ladder);
    }

    Ladder getLadder(ArrayList listForNameAndHeight){
        return new Ladder(listForNameAndHeight);
    }

    ArrayList getNameAndHeightFromManager() throws IOException {
        return manager.getNameAndHeightFromUser();
    }

    void printLadder(Ladder ladder){
        manager.printLadder(ladder);
    }
}
