package kr.codesquad.ladder;

public class LadderGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Ladder ladder;

    public void setLadder() {
        int participantCount = inputView.inputParticipantCount();
        int height = inputView.inputLadderHeight();
        ladder = Ladder.createLadder(height, participantCount);
    }

    public void drawLadder() {
        ladder.fillLine();
        ladder.fillWidthLine();
        outputView.printLadder(ladder.getLadderStatus());
    }

}
