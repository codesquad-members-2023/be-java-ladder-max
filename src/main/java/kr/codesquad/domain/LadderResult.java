package kr.codesquad.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {

    private final Map<User, Result> ladderResult;

    public LadderResult() {
        this.ladderResult = new LinkedHashMap<>();
    }

    public void put(User key, Result value) {
        this.ladderResult.put(key, value);
    }

    public Result findByUser(User user) {
        return this.ladderResult.get(user);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.ladderResult.forEach((user, result)
            -> stringBuilder.append(String.format("%s : %s\n", user, result)));
        return stringBuilder.toString();
    }
}
