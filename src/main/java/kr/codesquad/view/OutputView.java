package kr.codesquad.view;

import java.util.List;

public class OutputView {

    public static final int LIMIT_LENGTH = 5;
    public static final String RESULT_PRINT_DESCRIPTION = "실행결과";

    public void print(String drawnLadder) {
        System.out.println(drawnLadder);
    }

    public void print(List<String> names, String drawnLadder) {
        StringBuilder resultSB = addNames(names)
            .append("\n")
            .append(drawnLadder);
        System.out.println(resultSB);
    }

    static String limitName(String userName) {
        if (userName.length() > LIMIT_LENGTH) {
            userName = userName.substring(0, LIMIT_LENGTH);
        }
        return userName;
    }

    public void print(List<String> names, String drawnLadder, List<String> result) {
        System.out.println(RESULT_PRINT_DESCRIPTION);
        StringBuilder resultSB = addNames(names)
            .append("\n")
            .append(drawnLadder);
        for (String eachResult : result) {
            resultSB.append(StringUtils.center(eachResult, 6));
        }
        System.out.println(resultSB);
    }

    private static StringBuilder addNames(List<String> names) {
        StringBuilder resultSB = new StringBuilder();
        for (String userName : names) {
            userName = limitName(userName);
            resultSB.append(StringUtils.center(userName, 6));
        }
        return resultSB;
    }

    static class StringUtils {

        public static final char SPACER = ' ';

        public static String center(String input, int size) {
            return center(input, size, SPACER);
        }

        public static String center(String input, int size, char delimiter) {
            if (input == null || size <= input.length()) {
                return input;
            }
            StringBuilder sb = new StringBuilder(size);
            sb.append(getPrefix(input, size, delimiter)).append(input);
            while (sb.length() < size) {
                sb.append(delimiter);
            }
            return sb.toString();
        }

        private static String getPrefix(String input, int size, char delimiter) {
            return String.valueOf(delimiter).repeat((size - input.length()) / 2);
        }
    }
}
