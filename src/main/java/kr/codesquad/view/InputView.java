package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {


    private final static String DIGIT_PATTERN = "^[1-9][0-9]*$";
    private static final String REQUEST_PEOPLE_COUNT = "참여할 사람은 몇 명인가요?";
    private static final String REQUEST_RADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NAMES_FORMATTER = "^[a-z]+(,[a-z]+)+$";
    public static final String NAME_DELIMITER = ",";

    public List<String> inputNames() {
        System.out.println(REQUEST_NAMES);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isRightNamesPattern(input)) {
            return Arrays.stream(input.split(NAME_DELIMITER)).collect(Collectors.toList());
        }
        return inputNames();
    }

    boolean isRightNamesPattern(String input) {
        return Pattern.matches(NAMES_FORMATTER, input);
    }

    public Integer inputPeopleCount() {
        return inputDigit(REQUEST_PEOPLE_COUNT);
    }

    public Integer inputLadderHeight() {
        return inputDigit(REQUEST_RADDER_HEIGHT);
    }

    private Integer inputDigit(String description) {
        System.out.println(description);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isDigit(input)) {
            return Integer.valueOf(input);
        }
        return inputDigit(description);
    }

    static boolean isDigit(String input) {
        return Pattern.matches(DIGIT_PATTERN, input);
    }
}
