package kr.codesquad.domain;

import java.util.stream.IntStream;
import kr.codesquad.util.RandomLadderGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

    private static final String END_GAME_COMMAND = "춘식이";
    private static final String ALL_RESULT_PRINT_COMMAND = "춘식이";

    private final Users users;
    private final Results results;
    private final Ladder ladder;
    private final LadderResult ladderResult;

    public LadderGame() {
        this.users = InputView.inputUserNames();
        this.results = InputView.inputResults(this.users.count());
        this.ladder = new Ladder(RandomLadderGenerator.generate(this.users.count()
            , InputView.inputLadderHeight().getHeight()));
        this.ladderResult = new LadderResult();
    }

    public void run() {
        printInitDisplay();
        calculateLadderResult();
        findLadderResult();
        exit();
    }

    private void findLadderResult() {
        String userName = InputView.inputUserName();

        if (userName.equals(END_GAME_COMMAND)) {
            return;
        }

        try {
            printResult(userName);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            findLadderResult();
        }
    }

    private void printInitDisplay() {
        OutputView.printUsers(this.users);
        OutputView.printLadder(this.ladder);
        OutputView.printResults(this.results);
    }

    private void calculateLadderResult() {
        IntStream.range(0, this.users.count())
            .forEach(userIndex -> {
                int resultIndex = this.ladder.calculateResultIndex(userIndex);
                this.ladderResult.put(this.users.findByIndex(userIndex), this.results.findByIndex(resultIndex));
            });
    }

    private void printResult(String userName) {
        if (userName.equals(ALL_RESULT_PRINT_COMMAND)) {
            OutputView.printLadderResult(this.ladderResult);
            return;
        }

        Result result = this.ladderResult.findByUser(this.users.findByName(userName));
        OutputView.printResult(result);
    }

    private void exit() {
        OutputView.printExit();
        InputView.close();
    }
}
