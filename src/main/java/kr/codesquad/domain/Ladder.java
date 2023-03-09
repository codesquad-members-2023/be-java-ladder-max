package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<RowLines> ladder;

    public Ladder(Users numberOfUsers, LadderHeight ladderHeight) {
        this.ladder = generateLadder(numberOfUsers.count(), ladderHeight.getHeight());
    }

    private List<RowLines> generateLadder(int numberOfUsers, int ladderHeight) {
        RandomRowLineGenerator randomRowLineGenerator = new RandomRowLineGenerator(numberOfUsers);
        return IntStream.range(0, ladderHeight)
            .mapToObj(index -> new RowLines(randomRowLineGenerator))
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.ladder.stream()
            .map(RowLines::toString)
            .collect(Collectors.joining("\n"));
    }
}
