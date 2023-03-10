package kr.codesquad.ladder.domain;

import java.util.List;

public class LadderConverter {

    public String convertToString(List<List<String>> partLines) {
        StringBuilder result = new StringBuilder();
        for (List<String> line : partLines) {
            result.append(String.join("", line)).append("\n");
        }
        return result.toString();
    }
}
