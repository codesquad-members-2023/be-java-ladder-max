package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.SearchType;

public class InputView {


    public static final String INPUT_NAME = "결과를 보고 싶은 사람은?";
    private final static String DIGIT_PATTERN = "^[1-9][0-9]*$";
    private static final String REQUEST_PEOPLE_COUNT = "참여할 사람은 몇 명인가요?";
    private static final String INPUT_RADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String NAMES_FORMATTER = "^[a-z]+(,[a-z]+)+$";
    public static final String NAME_DELIMITER = ",";
    public static final String RESULT_PATTERN = "^(꽝|([0-9]+[1-9]*))(,(꽝|([0-9]+[1-9]*)))*$";
    private final Scanner scanner = new Scanner(System.in);

    public Result inputName(List<String> names) {
        System.out.println(INPUT_NAME);
        String input = scanner.nextLine();
        if (isSearchAll(input)) {
            return new Result(SearchType.ALL);
        }
        if (isClose(input)) {
            return new Result(SearchType.CLOSE);
        }
        if (names.contains(input)) {
            return new Result(SearchType.SINGLE, input);
        }
        return inputName(names);
    }

    static boolean isClose(String input) {
        return input.equals(SearchType.CLOSE.getValue());
    }

    static boolean isSearchAll(String input) {
        return input.equals(SearchType.ALL.getValue());
    }

    public List<String> inputNames() {
        System.out.println(INPUT_NAMES);
        String input = scanner.nextLine();
        if (isRightNamesPattern(input)) {
            return Arrays.stream(input.split(NAME_DELIMITER)).collect(Collectors.toList());
        }
        return inputNames();
    }

    public List<String> inputResult(int size) {
        System.out.println(INPUT_RESULT);
        String input = scanner.nextLine();
        if (isRightResultPattern(input)) {
            String[] result = input.split(NAME_DELIMITER);
            if (result.length == size) {
                return Arrays.stream(result).collect(Collectors.toList());
            }
        }
        return inputNames();
    }

    boolean isRightResultPattern(String input) {
        return Pattern.matches(RESULT_PATTERN, input);
    }

    boolean isRightNamesPattern(String input) {
        return Pattern.matches(NAMES_FORMATTER, input);
    }

    public Integer inputPeopleCount() {
        return inputDigit(REQUEST_PEOPLE_COUNT);
    }

    public Integer inputLadderHeight() {
        return inputDigit(INPUT_RADDER_HEIGHT);
    }

    private Integer inputDigit(String description) {
        System.out.println(description);
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
