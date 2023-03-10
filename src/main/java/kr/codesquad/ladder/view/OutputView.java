package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.Reward;

public class OutputView {

    private static final String MATCHING_RESULT_MESSAGE = "실행 결과";

    public static void printString(String format) {
        System.out.println(format + System.lineSeparator());
    }

    public static void printMatchingResult(String result) {
        System.out.println(MATCHING_RESULT_MESSAGE);
        System.out.println(result + System.lineSeparator());
    }
}
