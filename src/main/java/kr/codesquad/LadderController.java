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

        this.ladderGenerator = new LadderGenerator(joinMembers, maxHeight); // 다른 방법 찾아보기
        String[][] ladder = ladderGenerator.generateLadder();
        outputView.printLadderState(ladder);
    }
}