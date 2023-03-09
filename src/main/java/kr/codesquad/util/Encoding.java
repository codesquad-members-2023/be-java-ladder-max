package kr.codesquad.util;

import java.util.List;

public class Encoding {

    public String encodeLadder(List<List<String>> ladders) {
        StringBuilder sb = new StringBuilder();
        for (List<String> ladder : ladders) {
            sb.append(String.join("", ladder));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
