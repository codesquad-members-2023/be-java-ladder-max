package kr.codesquad.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResultRepository {

    public static final String NAME_RESULT_DELIMITER = " : ";
    public static final String NEXT_LINE = "\n";
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
            .append(NAME_RESULT_DELIMITER)
            .append(resultInfo.get(value))
            .append(NEXT_LINE));
        return answer.toString();
    }


    public void saveNamesAndResultINFO(List<String> names, List<String> resultInfo) {
        this.names = names;
        this.resultInfo = resultInfo;
    }

    public boolean containsName(String name) {
        return names.contains(name);
    }
}
