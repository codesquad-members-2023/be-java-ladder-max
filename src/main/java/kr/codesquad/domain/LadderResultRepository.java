package kr.codesquad.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResultRepository {

    private final Map<Integer, Integer> ladderResult = new HashMap<>();
    private List<String> names;
    private List<String> resultInfo;


    public void put(int position, int resultNum) {
        ladderResult.put(position, resultNum);
    }

    public String searchSingleResult(String name) {
        return resultInfo.get(ladderResult.get(names.indexOf(name)));
    }

    public String searchAll() {
        StringBuilder answer = new StringBuilder();
        ladderResult.forEach((key, value) -> answer.append(names.get(key))
            .append(" : ")
            .append(resultInfo.get(value))
            .append("\n"));
        return answer.toString();
    }


    public void save(List<String> names, List<String> resultInfo) {
        this.names = names;
        this.resultInfo = resultInfo;
    }

    public boolean containsName(String name) {
        return names.contains(name);
    }
}
