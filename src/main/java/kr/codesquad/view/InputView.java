package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import kr.codesquad.domain.LadderResultRepository;
import kr.codesquad.domain.SearchInfo;
import kr.codesquad.domain.SearchType;

public class InputView {


    public static final String INPUT_SEARCH_INFO = "결과를 보고 싶은 사람은?";
    private static final String INPUT_RADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_INFO = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String NAME_DELIMITER = ",";
    private static final String NAMES_PATTERN = "^[a-z]+(,[a-z]+)+$";
    public static final String RESULT_PATTERN = "^(꽝|([0-9]+[1-9]*))(,(꽝|([0-9]+[1-9]*)))*$";
    private final static String DIGIT_PATTERN = "^[1-9][0-9]*$";
    public static final String INPUT_ERROR = "잘못 입력했습니다.";
    private final Scanner scanner = new Scanner(System.in);

    public SearchInfo inputSearchInfo(LadderResultRepository ladderResultRepository) {
        System.out.println(INPUT_SEARCH_INFO);
        String input = scanner.nextLine();
        if (isSearchAll(input)) {
            return new SearchInfo(SearchType.ALL);
        }
        if (isClose(input)) {
            return new SearchInfo(SearchType.CLOSE);
        }
        if (ladderResultRepository.containsName(input)) {
            return new SearchInfo(SearchType.SINGLE, input);
        }
        System.out.println(INPUT_ERROR);
        return inputSearchInfo(ladderResultRepository);
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
        System.out.println(INPUT_ERROR);
        return inputNames();
    }

    boolean isRightNamesPattern(String input) {
        return Pattern.matches(NAMES_PATTERN, input);
    }

    public List<String> inputResultInfo(int size) {
        System.out.println(INPUT_RESULT_INFO);
        String input = scanner.nextLine();
        if (isRightResultInfoPattern(input)) {
            String[] result = input.split(NAME_DELIMITER);
            if (result.length == size) {
                return Arrays.stream(result).collect(Collectors.toList());
            }
        }
        System.out.println(INPUT_ERROR);
        return inputResultInfo(size);
    }

    boolean isRightResultInfoPattern(String input) {
        return Pattern.matches(RESULT_PATTERN, input);
    }

    public Integer inputLadderHeight() {
        System.out.println(INPUT_RADDER_HEIGHT);
        String input = scanner.nextLine();
        if (isDigit(input)) {
            return Integer.valueOf(input);
        }
        System.out.println(INPUT_ERROR);
        return inputLadderHeight();
    }

    static boolean isDigit(String input) {
        return Pattern.matches(DIGIT_PATTERN, input);
    }
}
