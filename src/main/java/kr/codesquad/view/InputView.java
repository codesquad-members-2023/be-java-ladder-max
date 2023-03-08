package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    public final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_FORMAT = "^[a-z]+(,[a-z]+)+$";
    private static final String INVALID_INPUT_NAMEFORMAT = "유효하지 않은 형식입니다.";
    private static final String INPUT_PEOPLE_NAME = "참여할 사람 이름을 입력하세요.(이름은 쉼표로 구분하세요.)";



    public List<String> inputPeopleName() {
        System.out.println(INPUT_PEOPLE_NAME);
        String input = SCANNER.nextLine();
            if (validateNameFormat(input)) {
                return Arrays.stream(input.split(",")).collect(Collectors.toList());
            }
        System.out.println(INVALID_INPUT_NAMEFORMAT);
        return inputPeopleName();
    }

    private boolean validateNameFormat(String input) {
        boolean result = Pattern.matches(NAME_FORMAT, input);
        return result;
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public void close() {
        SCANNER.close();
    }

}
