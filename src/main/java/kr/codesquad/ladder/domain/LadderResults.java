package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LadderResults {

    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");
    private static final int LENGTH_LIMIT = 5;

    private final List<LadderResult> ladderResults;

    public LadderResults(String text, int countOfPeople) {
        validateCountOfLadderResult(text, countOfPeople);
        validateLengthOfLadderResult(text);
        this.ladderResults = toList(text);
    }

    private void validateCountOfLadderResult(String text, int countOfPeople) {
        String[] results = text.split(DELIMITER.pattern());
        if (results.length != countOfPeople) {
            throw new InvalidCountOfLadderResultException(countOfPeople);
        }
    }

    private void validateLengthOfLadderResult(String text) {
        String[] results = text.split(DELIMITER.pattern());
        Arrays.stream(results)
            .filter(result -> result.length() > LENGTH_LIMIT)
            .forEach(result -> {
                throw new InvalidLengthOfLadderResultException();
            });
    }

    private List<LadderResult> toList(String text) {
        List<LadderResult> ladderResults = new ArrayList<>();
        String[] results = text.split(DELIMITER.pattern());
        for (String result : results) {
            ladderResults.add(new LadderResult(result));
        }
        return ladderResults;
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
