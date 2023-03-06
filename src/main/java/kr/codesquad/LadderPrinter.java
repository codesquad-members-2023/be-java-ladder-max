package kr.codesquad;

import java.util.List;

public class LadderPrinter {

    public static final int LIMIT_LENGTH = 5;

    void print(String drawnLadder) {
        System.out.println(drawnLadder);
    }

    public void print(List<String> requestNames, String drawnLadder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String requestName : requestNames) {
            requestName = limitName(requestName);
            stringBuilder.append(String.format("%6s",requestName));
        }
        System.out.println(stringBuilder);
        System.out.println(drawnLadder);
    }

    static String limitName(String requestName) {
        if (requestName.length() > LIMIT_LENGTH) {
            requestName = requestName.substring(0, LIMIT_LENGTH);
        }
        return requestName;
    }
}
