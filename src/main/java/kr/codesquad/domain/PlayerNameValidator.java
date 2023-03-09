package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNameValidator {
    public List<String> getValidNameFromUser(InputView inputHandler) {
        while(true){
            try {
                String strContainsName = inputHandler.getInput();
                return parseInputString(strContainsName);
            } catch (RuntimeException | IOException e ) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> parseInputString(String strContainsName) {
        return Arrays.stream(strContainsName.split(","))
                .map(str -> validateName(str))
                .collect(Collectors.toList());
    }

    private String validateName(String str) {
        if (str.length() > 5) {
            throw new RuntimeException("5글자 이상인 이름 발견 (" + str + ") 재입력 할것 ");
        }
        return str;
    }
}
