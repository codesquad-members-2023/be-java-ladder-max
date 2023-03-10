package kr.codesquad.util;

import java.util.List;

public class Encoding {
    private final String EMPTY_STRING = "";
    private final String NEW_LINE = "\n";
    private final int FIRST_INDEX = 0;
    private final int LAST_INDEX = 1;

    public String encodeLadder(List<List<String>> ladders) {
        StringBuilder sb = new StringBuilder();
        for (List<String> ladder : ladders) {
            sb.append(String.join(EMPTY_STRING, ladder));
            sb.append(NEW_LINE);
        }
        return sb.substring(FIRST_INDEX, sb.length() - LAST_INDEX);
    }
}
