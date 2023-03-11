package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.exception.result.ResultsMinResultCountException;
import kr.codesquad.exception.result.ResultsSameUserCountException;
import kr.codesquad.exception.user.UsersMinUserCountException;

public class Results {

    private static final int MIN_RESULTS_COUNT = 2;

    private final List<Result> results;

    public Results(String results, int userCount) {
        String[] split = results.split(",");
        validateMinResultCount(split);
        validateSameUserCount(split, userCount);
        this.results = generate(split);
    }

    private void validateMinResultCount(String[] results) {
        long count = Arrays.stream(results)
            .map(result -> result.replace(" ", ""))
            .filter(result -> !result.isBlank())
            .count();

        if (count < MIN_RESULTS_COUNT) {
            throw new ResultsMinResultCountException();
        }
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
