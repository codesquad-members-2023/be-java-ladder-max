package kr.codesquad;

import java.util.List;

public class LadderPrinter {

    public static final int LIMIT_LENGTH = 5;
    public static final String MAX_LENGTH = "%6s";

    void print(String drawnLadder) {
        System.out.println(drawnLadder);
    }

    public void print(List<String> requestNames, String drawnLadder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String requestName : requestNames) {
            requestName = limitName(requestName);
            stringBuilder.append(String.format(MAX_LENGTH,requestName));
        }
        System.out.println(stringBuilder);
        System.out.println(drawnLadder);
    }

    private static String limitName(String requestName) {
        if (requestName.length() > LIMIT_LENGTH) {
            requestName = requestName.substring(0, LIMIT_LENGTH);
        }
        return requestName;
    }
}
