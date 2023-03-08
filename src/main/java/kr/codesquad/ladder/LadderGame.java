package kr.codesquad.ladder;

import static kr.codesquad.ladder.view.OutputView.printString;

import java.io.IOException;
import java.util.List;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.domain.RandomBooleansGenerator;
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

    public void run() throws IOException {
        Names playerNames = Names.createNames(inputView.inputNames());
        int height = inputView.inputHeight();

        for (int i = 0; i < height; i++) {
            ladder.addLine(new Line(randomBooleansGenerator.createRandomBooleans(playerNames.getSize() - 1)));
        }
        printString(playerNames.toString());
        printString(ladder.toString());
    }

}
