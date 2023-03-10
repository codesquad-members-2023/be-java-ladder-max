package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerValidator {

    public boolean playerValidator(ArrayList list, InputView inputHandler) {
        try {
            String strContainsName = inputHandler.getInput();
            list.addAll(parseInputString(strContainsName));
            validatePlayerNum(list);
            return true;
        } catch (RuntimeException | IOException e) {
            list.clear();
            System.out.println(e.getMessage());
        }
        return false;
    }

    private List<String> parseInputString(String strContainsName) {
        return Arrays.stream(strContainsName.split(","))
                .map(str -> validateNameLength(str))
                .collect(Collectors.toList());
    }

    private String validateNameLength(String str) {
        if (str.length() > 5) {
            throw new RuntimeException("5글자 이상인 이름 발견 (" + str + ") 재입력 할것 ");
        }
        return str;
    }

    private void validatePlayerNum(ArrayList list){
        if(list.size()<2){
            throw new RuntimeException("player는 2명이상 필요합니다.재입력 해라");
        }
    }

}
