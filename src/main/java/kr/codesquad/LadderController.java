package kr.codesquad;

import java.util.List;

public class LadderController {

    private final InputRequest inputRequest = new InputRequest();
    private final Ladder ladder = new LadderByNames();
    private final LadderPrinter ladderPrinter = new LadderPrinter();

    void start() {
//        request();
        requestNames();
    }

    private void requestNames() {
        List<String> requestNames = inputRequest.requestNames();
        Integer ladderHeight = inputRequest.requestLadderHeight();
        createLadder(requestNames, ladderHeight);
    }

    private void createLadder(List<String> requestNames, Integer ladderHeight) {
        String drawnLadder = ladder.create(requestNames.size(), ladderHeight);
        print(requestNames, drawnLadder);
    }

    private void print(List<String> requestNames, String drawnLadder) {
        ladderPrinter.print(requestNames, drawnLadder);
    }

    private void request() {
        Integer peopleCount = inputRequest.requestPeopleCount();
        Integer ladderHeight = inputRequest.requestLadderHeight();
        createLadder(peopleCount, ladderHeight);

    }

    private void createLadder(Integer peopleCount, Integer ladderHeight) {
        String drawnLadder = ladder.create(peopleCount, ladderHeight);
        print(drawnLadder);
    }

    private void print(String drawnLadder) {
        ladderPrinter.print(drawnLadder);
    }

}
