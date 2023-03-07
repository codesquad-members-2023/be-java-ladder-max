package kr.codesquad.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static final int LIMIT_LENGTH = 5;
    public static final String DRAW_LADDER_DESCRIPTION = "사다리 결과";
    public static final String SEARCH_CLOSE_DESCRIPTION = "게임을 종료합니다.";
    public static final String SEARCH_RESULT_DESCRIPTION = "실행 결과";

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
        System.out.println(DRAW_LADDER_DESCRIPTION);
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

    public void printClose() {
        System.out.println(SEARCH_CLOSE_DESCRIPTION);
    }

    public void printAll(List<String> names, List<String> result, Map<Integer, Integer> usersOfResult) {
        System.out.println(SEARCH_RESULT_DESCRIPTION);
        usersOfResult.forEach((key, value) -> {
            System.out.print(names.get(key));
            System.out.print(" : ");
            System.out.println(result.get(value));
        });
    }

    public void printSingle( List<String> result, int resultIndex) {
        System.out.println(SEARCH_RESULT_DESCRIPTION);
        System.out.println(result.get(resultIndex));
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
