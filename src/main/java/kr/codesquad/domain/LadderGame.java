package kr.codesquad.domain;

import kr.codesquad.exception.EndGameException;
import kr.codesquad.util.RandomLadderGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

    public static final String END_GAME_COMMAND = "춘식이";
    public static final String PRINT_ALL_RESULT_COMMAND = "all";

    private final LadderResult ladderResult;

    public LadderGame() {
        this.ladderResult = generateLadderResult();
    }

    private LadderResult generateLadderResult() {
        Users users = InputView.inputUserNames();
        Results results = InputView.inputResults(users.count());
        Ladder ladder = RandomLadderGenerator.generate(users.count()
            , InputView.inputLadderHeight().getHeight());
        return new LadderResult(users, results, ladder);
    }

    public void start() {
        OutputView.printLadderResult(this.ladderResult);
        executeLadderResult();
        end();
    }

    private void executeLadderResult() {
        try {
            printResult(InputView.inputUserName());
        } catch (EndGameException e) {
            return;
        } catch (RuntimeException e) {
            OutputView.printErrorMessage(e);
        }

        executeLadderResult();
    }

    private void printResult(String userName) {
        if (userName.equals(END_GAME_COMMAND)) {
            throw new EndGameException();
        }

        if (userName.equals(PRINT_ALL_RESULT_COMMAND)) {
            OutputView.printAllUserAndResult(this.ladderResult);
            return;
        }

        Result result = this.ladderResult.findByUser(userName);
        OutputView.printResult(result);
    }

    private void end() {
        OutputView.printExit();
        InputView.close();
    }
}
