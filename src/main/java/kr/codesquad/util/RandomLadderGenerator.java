package kr.codesquad.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.RandomRowLinesGenerator;
import kr.codesquad.domain.RowLines;

public class RandomLadderGenerator {

    private RandomLadderGenerator() {
    }

    public static Ladder generate(int numberOfUsers, int ladderHeight) {
        List<RowLines> ladder = createLadder(numberOfUsers, ladderHeight);
        connectEmptyColumnLineRandomly(ladder, numberOfUsers);
        return new Ladder(ladder);
    }

    private static List<RowLines> createLadder(int numberOfUsers, int ladderHeight) {
        RandomRowLinesGenerator rowLinesGenerator = new RandomRowLinesGenerator(numberOfUsers);
        return IntStream.range(0, ladderHeight)
            .mapToObj(index -> rowLinesGenerator.generate())
            .collect(Collectors.toList());
    }

    private static void connectEmptyColumnLineRandomly(List<RowLines> ladder, int numberOfUsers) {
        IntStream.range(0, numberOfUsers - 1)
            .filter(index -> ladder.stream()
                .noneMatch(rowLines -> rowLines.isConnect(index)))
            .forEach(index -> connectRandomLine(ladder, index));
    }

    private static void connectRandomLine(List<RowLines> ladder, int index) {
        ladder.stream().parallel()
            .filter(rowLines -> rowLines.isMakeConnection(index))
            .findAny()
            .ifPresent(rowLines -> rowLines.connect(index));
    }
}
