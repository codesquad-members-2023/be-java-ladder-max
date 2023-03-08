package kr.codesquad.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String DRAW_LADDER_DESCRIPTION = "사다리 결과";
    public static final String SEARCH_CLOSE_DESCRIPTION = "게임을 종료합니다.";
    public static final String SEARCH_RESULT_DESCRIPTION = "실행 결과";
    public static final int LIMIT_LENGTH = 5;
    public static final int NAME_AREA = 6;

    public void printLadder(List<String> names, String drawnLadder, List<String> result) {
        System.out.println(DRAW_LADDER_DESCRIPTION);
        StringBuilder resultSB = addNames(names)
            .append("\n")
            .append(drawnLadder);
        for (String eachResult : result) {
            resultSB.append(StringCenterSorter.center(eachResult, NAME_AREA));
        }
        System.out.println(resultSB);
    }

    private static StringBuilder addNames(List<String> names) {
        StringBuilder resultSB = new StringBuilder();
        for (String userName : names) {
            userName = limitName(userName);
            resultSB.append(StringCenterSorter.center(userName, NAME_AREA));
        }
        return resultSB;
    }

    static String limitName(String userName) {
        if (userName.length() > LIMIT_LENGTH) {
            userName = userName.substring(0, LIMIT_LENGTH);
        }
        return userName;
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

    public void printSingleResult(List<String> result, int resultIndex) {
        System.out.println(SEARCH_RESULT_DESCRIPTION);
        System.out.println(result.get(resultIndex));
    }

    static class StringCenterSorter {

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
