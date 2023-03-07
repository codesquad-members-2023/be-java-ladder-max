package kr.codesquad;

public class LadderController {
    OutputView outputView;
    InputView inputView;
    LadderGenerator ladderGenerator;

    public LadderController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startLadderGame() {
        outputView.printJoinMembers();
        int joinMembers = inputView.userInput();
        outputView.printMaxHeight();
        int maxHeight = inputView.userInput();

        this.ladderGenerator = new LadderGenerator(joinMembers, maxHeight);
        String[][] ladder = ladderGenerator.makeLadder();
        outputView.printLadderState(ladder);
    }
}