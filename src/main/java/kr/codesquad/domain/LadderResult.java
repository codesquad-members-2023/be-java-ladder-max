package kr.codesquad.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResult {

    private final Users users;
    private final Results results;
    private final Ladder ladder;
    private final Map<User, Result> ladderResult;

    public LadderResult(Users users, Results results, Ladder ladder) {
        this.users = users;
        this.results = results;
        this.ladder = ladder;
        this.ladderResult = new HashMap<>();
        calculateLadderResult();
    }

    private void calculateLadderResult() {
        IntStream.range(0, this.users.count())
            .forEach(userIndex -> {
                int resultIndex = this.ladder.calculateResultIndex(userIndex);
                this.ladderResult.put(this.users.findByIndex(userIndex), this.results.findByIndex(resultIndex));
            });
    }

    public Result findByUser(String userName) {
        return this.ladderResult.get(this.users.findByName(userName));
    }

    public String printLadderResult() {
        return String.format("%s\n%s\n%s", this.users, this.ladder, this.results);
    }

    public String printAllUserAndResult() {
        StringBuilder stringBuilder = new StringBuilder();
        this.ladderResult.forEach((user, result)
            -> stringBuilder.append(String.format("%s : %s\n", user, result)));
        return stringBuilder.toString();
    }
}
