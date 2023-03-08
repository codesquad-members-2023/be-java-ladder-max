package kr.codesquad.domain;

import java.io.IOException;
import java.util.ArrayList;

public class LadderGameController {
    InputOutputController manager = new InputOutputController();
    public void startLadderGame() throws IOException {
        Ladder ladder = getLadder(getNameAndHeightFromManager());
        printLadder(ladder);
    }

    private Ladder getLadder(ArrayList listForNameAndHeight){
        return new Ladder(listForNameAndHeight);
    }

    private ArrayList getNameAndHeightFromManager() throws IOException {
        return manager.getNameAndHeightFromUser();
    }

    private void printLadder(Ladder ladder){
        manager.printLadder(ladder);
    }
}
