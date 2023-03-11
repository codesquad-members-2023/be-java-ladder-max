package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.exception.result.ResultsSameUserCountException;

public class Results {

    private final List<Result> results;

    public Results(String results, int userCount) {
        String[] split = results.split(",");
        validateSameUserCount(split, userCount);
        this.results = generate(split);
    }

    private void validateSameUserCount(String[] results, int userCount) {
        long count = Arrays.stream(results)
            .filter(result -> !result.replace(" ", "")
                .isBlank())
            .count();

        if (count != userCount) {
            throw new ResultsSameUserCountException();
        }
    }
    private List<Result> generate(String[] results) {
        return Arrays.stream(results)
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
