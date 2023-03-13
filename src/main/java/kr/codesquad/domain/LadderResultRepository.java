package kr.codesquad.domain;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;


@Service
public class LadderResultRepository {

    public static final String NAME_RESULT_DELIMITER = " : ";
    public static final String NEXT_LINE = "\n";
    private final Map<String, String> ladderResult = new HashMap<>();

    public void put(String name, String result) {
        ladderResult.put(name, result);
    }

    public String searchSingleResult(String name) {
        return ladderResult.get(name);
    }

    public String searchAll() {
        StringBuilder answer = new StringBuilder();
        ladderResult.forEach(
                (key, value) -> answer.append(key)
                        .append(NAME_RESULT_DELIMITER)
                        .append(value)
                        .append(NEXT_LINE));
        return answer.toString();
    }

    public boolean containsName(String name) {
        return ladderResult.containsKey(name);
    }

    public void clear() {
        ladderResult.clear();
    }
}
