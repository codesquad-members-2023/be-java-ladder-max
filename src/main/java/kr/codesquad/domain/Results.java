package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(String inputResults, int userCount) {
        String[] split = inputResults.split(",");
        validateMinSize(split, userCount);
        this.results = generate(split);
    }

    private void validateMinSize(String[] results, int userCount) {
        long count = Arrays.stream(results)
            .filter(result -> !result.replace(" ", "")
                .isBlank())
            .count();

        if (count < userCount) {
            throw new IllegalArgumentException("참여할 사람의 수와 같아야 합니다.");
        }
    }
    private List<Result> generate(String[] inputResults) {
        return Arrays.stream(inputResults)
            .map(Result::new)
            .collect(Collectors.toList());
    }

    public Result findByIndex(int index) {
        return this.results.get(index);
    }

    @Override
    public String toString() {
        return this.results.stream()
            .map(Result::printFormat)
            .collect(Collectors.joining());
    }
}
