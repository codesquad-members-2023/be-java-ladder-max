package kr.codesquad.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResultRepository {

    private final Map<Integer, Integer> ladderResult = new HashMap<>();

    public void put(int position, int resultNum) {
        ladderResult.put(position, resultNum);
    }

    public String searchSingleResult(int index, List<String> result) {
        return result.get(ladderResult.get(index));
    }

    public String searchAll(List<String> names, List<String> resultInfo) {
        StringBuilder answer = new StringBuilder();
        ladderResult.forEach((key, value) -> answer.append(names.get(key))
            .append(" : ")
            .append(resultInfo.get(value))
            .append("\n"));
        return answer.toString();
    }


}
