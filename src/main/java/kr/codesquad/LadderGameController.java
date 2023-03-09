package kr.codesquad;

public class LadderGameController {
    OutputView outputView;
    InputView inputView;
    LadderGenerator ladderGenerator;

    public LadderGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void startLadderGame() {
        outputView.printParticipantsPrompt();
        int joinMembers = inputView.userInput();
        outputView.printMaxHeightPrompt();
        int maxHeight = inputView.userInput();

        this.ladderGenerator = new LadderGenerator(joinMembers, maxHeight); // 다른 방법 찾아보기
        String[][] ladder = ladderGenerator.generateLadder();
        outputView.printLadderState(ladder);
    }
}