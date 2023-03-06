package kr.codesquad.ladder;

public class LadderGame {

    private final InputView inputView = new InputView();
    private Ladder ladder;

    public void setLadder() {
        int participantCount = inputView.inputParticipantCount();
        int height = inputView.inputLadderHeight();
        ladder = Ladder.createLadder(height, participantCount);
    }

}
