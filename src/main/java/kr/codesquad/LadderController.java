package kr.codesquad;

import java.util.List;
import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderByNames;
import kr.codesquad.view.InputRequest;
import kr.codesquad.view.LadderPrinter;

public class LadderController {

    private final InputRequest inputRequest = new InputRequest();
    private final Ladder ladder = new LadderByNames();
    private final LadderPrinter ladderPrinter = new LadderPrinter();

    public void start() {
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
