package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.util.RandomLadderGenerator;

public class Ladder {

    private final List<RowLines> ladder;

    public Ladder(Users users, LadderHeight ladderHeight) {
        this.ladder = RandomLadderGenerator.generate(users.count(), ladderHeight.getHeight());
    }

    @Override
    public String toString() {
        return this.ladder.stream()
            .map(RowLines::toString)
            .collect(Collectors.joining("\n"));
    }
}
