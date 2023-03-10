package kr.codesquad.domain;

import kr.codesquad.exception.EndGameException;
import kr.codesquad.util.RandomLadderGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

    private static final String END_GAME_COMMAND = "춘식이";
    private static final String ALL_RESULT_PRINT_COMMAND = "all";

    private final LadderResult ladderResult;

    public LadderGame() {
        this.ladderResult = generateLadderResult();
    }

    private LadderResult generateLadderResult() {
        Users users = InputView.inputUserNames();
        Results results = InputView.inputResults(users.count());
        Ladder ladder = new Ladder(RandomLadderGenerator.generate(users.count()
            , InputView.inputLadderHeight().getHeight()));
        return new LadderResult(users, results, ladder);
    }

    public void run() {
        OutputView.printLadderResult(this.ladderResult);
        findLadderResult();
        exit();
    }

    private void findLadderResult() {
        try {
            printResult(InputView.inputUserName());
        } catch (EndGameException e) {
            return;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        findLadderResult();
    }

    private void printResult(String userName) {
        if (userName.equals(END_GAME_COMMAND)) {
            throw new EndGameException();
        }

        if (userName.equals(ALL_RESULT_PRINT_COMMAND)) {
            OutputView.printAllUserAndResult(this.ladderResult);
            return;
        }

        Result result = this.ladderResult.findByUser(userName);
        OutputView.printResult(result);
    }

    private void exit() {
        OutputView.printExit();
        InputView.close();
    }
}
