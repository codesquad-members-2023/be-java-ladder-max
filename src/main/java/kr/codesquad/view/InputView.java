package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    public static final String DELIMITER = ",";
    public final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_FORMAT = "^[a-z]+(,[a-z]+)+$";
    private static final String INVALID_INPUT_NAMEFORMAT = "유효하지 않은 형식입니다.";
    private static final String INPUT_PEOPLE_NAME = "참여할 사람 이름을 입력하세요.(이름은 쉼표로 구분하세요.)";

    private List<String > inputPeopleList;



    public List<String> inputPeopleName() {
        System.out.println(INPUT_PEOPLE_NAME);
        String input = SCANNER.nextLine();
            if (validateNameFormat(input) && validateNameSize(input)) {
            inputPeopleList =  Arrays.stream(input.split(DELIMITER)).collect(Collectors.toList());
            return inputPeopleList;
            }
        System.out.println(INVALID_INPUT_NAMEFORMAT);
        return inputPeopleName();
    }

    public List<String> getInputPeopleList() {
        return inputPeopleList;
    }

    public int inputPeopleSize(){
        return inputPeopleName().size();
    }

    private boolean validateNameFormat(String input) {
        return Pattern.matches(NAME_FORMAT, input);
    }

    private boolean validateNameSize(String input) {
        String []nameArr = input.split(DELIMITER);
        for (String s : nameArr) {
            if(s.length()>5){
                return false;
            }
        }
        return true;
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public void close() {
        SCANNER.close();
    }

}
