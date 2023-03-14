package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(String[] ladderResults, int countOfPeople) {
        validateCountOfLadderResult(ladderResults, countOfPeople);
        this.ladderResults = toList(ladderResults);
    }

    private void validateCountOfLadderResult(String[] ladderResults, int countOfPeople) {
        if (ladderResults.length != countOfPeople) {
            throw new InvalidCountOfLadderResultException(countOfPeople);
        }
    }

    private List<LadderResult> toList(String[] ladderResults) {
        List<LadderResult> ladderResultList = new ArrayList<>();
        for (String ladderResult : ladderResults) {
            ladderResultList.add(new LadderResult(ladderResult));
        }
        return ladderResultList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderResults)) {
            return false;
        }
        LadderResults that = (LadderResults) o;
        return Objects.equals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResults);
    }

    @Override
    public String toString() {
        return ladderResults.stream()
            .map(ladderResult -> String.format("%-5s", ladderResult.toString()))
            .collect(Collectors.joining());
    }
}
