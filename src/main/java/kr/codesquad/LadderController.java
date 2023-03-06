package kr.codesquad;

public class LadderController {

    private final InputRequest inputRequest = new InputRequest();
    private final Ladder ladder = new Ladder();
    private final LadderPrinter ladderPrinter = new LadderPrinter();

    void start() {
        request();
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
