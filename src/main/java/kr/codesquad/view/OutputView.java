package kr.codesquad.view;

import java.util.List;

public class OutputView {

    public static final int LIMIT_LENGTH = 5;

    public void print(String drawnLadder) {
        System.out.println(drawnLadder);
    }

    public void print(List<String> userNames, String drawnLadder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String userName : userNames) {
            userName = limitName(userName);
            stringBuilder.append(String.format("%6s",userName));
        }
        System.out.println(stringBuilder);
        System.out.println(drawnLadder);
    }

    static String limitName(String userName) {
        if (userName.length() > LIMIT_LENGTH) {
            userName = userName.substring(0, LIMIT_LENGTH);
        }
        return userName;
    }
}
