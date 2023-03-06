package kr.codesquad;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputRequest {


    private final static String DIGIT_PATTERN = "^[1-9][0-9]*$";
    public static final String REQUEST_PEOPLE_COUNT = "참여할 사람은 몇 명인가요?";
    public static final String REQUEST_RADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String REQUEST_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public String[] requestNames() {
        System.out.println(REQUEST_NAMES);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isRightNamesPattern(input)) {
            return input.split(",");
        }
        return requestNames();
    }

    boolean isRightNamesPattern(String input) {
        return Pattern.matches("^[a-z]+(,[a-z]+)+$", input);
    }

    public Integer requestPeopleCount() {
        return requestDigitInput(REQUEST_PEOPLE_COUNT);
    }

    public Integer requestLadderHeight() {
        return requestDigitInput(REQUEST_RADDER_HEIGHT);
    }

    private Integer requestDigitInput(String description) {
        System.out.println(description);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isDigit(input)) {
            return Integer.valueOf(input);
        }
        return requestDigitInput(description);
    }

    static boolean isDigit(String input) {
        return Pattern.matches(DIGIT_PATTERN, input);
    }
}
