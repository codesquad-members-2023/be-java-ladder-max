package kr.codesquad.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultRepository {
    private final Map<Integer, Integer> ladderResult = new HashMap<>();

    public void put(int position, int resultNum) {
        ladderResult.put(position, resultNum);
    }

    public int get(int index) {
        return ladderResult.get(index);
    }

    public Map<Integer, Integer> getAll() {
        return ladderResult;
    }
}
