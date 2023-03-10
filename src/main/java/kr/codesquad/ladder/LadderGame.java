package kr.codesquad.ladder;

import static kr.codesquad.ladder.view.OutputView.printMatchingResult;
import static kr.codesquad.ladder.view.OutputView.printString;

import java.io.IOException;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.MatchingMachine;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.domain.RandomBooleansGenerator;
import kr.codesquad.ladder.domain.Rewards;
import kr.codesquad.ladder.view.InputView;

public class LadderGame {

    private final InputView inputView;
    private final RandomBooleansGenerator randomBooleansGenerator;
    private final Ladder ladder;

    public LadderGame(InputView inputView, RandomBooleansGenerator randomBooleansGenerator, Ladder ladder) {
        this.inputView = inputView;
        this.randomBooleansGenerator = randomBooleansGenerator;
        this.ladder = ladder;
    }

    public void start() throws IOException {
        Names playerNames = Names.createNames(inputView.inputNames());
        Rewards rewards = Rewards.createRewards(inputView.inputReward());
        int height = inputView.inputHeight();
        for (int i = 0; i < height; i++) {
            ladder.addLine(new Line(randomBooleansGenerator.createRandomBooleans(playerNames.getSize() - 1)));
        }
        printString(playerNames.toString());
        printString(ladder.toString());
        printString(rewards.toString());

        matchRewardByName(playerNames, rewards);
    }

    private void matchRewardByName(Names playerNames, Rewards rewards) throws IOException {
        MatchingMachine matchingMachine = new MatchingMachine(ladder, playerNames, rewards);
        while (true) {
            String reward = inputView.inputResultName();
            if ("춘식이".equals(reward)) {
                return;
            }else if ("all".equals(reward)) {
                printMatchingResult(matchingMachine.getAllMatchingResultInfo());
                continue;
            }
            String result = matchingMachine.getMatchingResult(reward);
            printMatchingResult(result);
        }
    }

}
