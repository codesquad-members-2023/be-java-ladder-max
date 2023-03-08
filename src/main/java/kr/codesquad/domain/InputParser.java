package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public boolean parseAndValidate(List list,String strContainsName) {
            try {
                list.addAll(parseAndValidateInputString(strContainsName));
                return true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            return false;
    }

    private List<String> parseAndValidateInputString(String strContainsName){
        return Arrays.stream(strContainsName.split(","))
                .map(str -> validate(str))
                .collect(Collectors.toList());
    }

    private String validate(String str) {
        if (str.length() > 5) {
            throw new RuntimeException("5글자 이상인 이름 발견 (" + str+ ") 재입력 할것 ");
        }
        return str;
    }
}
