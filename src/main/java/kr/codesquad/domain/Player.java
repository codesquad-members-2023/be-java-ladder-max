package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final String ERROR_MESSAGE_FOR_NAME_LENGTH = "5글자 이상인 이름 발견 재입력 할것";
    private final String ERROR_MESSAGE_FOR_PLAYER_NUMBER = "player는 2명이상 필요합니다.재입력 해라";
    ArrayList nameList;

    public ArrayList getNameList() {
        return nameList;
    }

    public boolean getVaildNameFromUser(InputView inputHandler) {
        try {
            String strContainsName = inputHandler.getInput();
            nameList.addAll(parseInputStringToValidNames(strContainsName));
            validatePlayerNumAndThrowException();
            return true;
        } catch (RuntimeException | IOException e) {
            nameList.clear();
            System.out.println(e.getMessage());
        }
        return false;
    }

    private List<String> parseInputStringToValidNames(String strContainsName) {
        return Arrays.stream(strContainsName.split(","))
                .map(str -> validateNameAndThrowException(str))
                .collect(Collectors.toList());
    }

    private String validateNameAndThrowException(String str) {
        if (str.length() > 5) {
            throw new RuntimeException(ERROR_MESSAGE_FOR_NAME_LENGTH);
        }
        return str;
    }

    private void validatePlayerNumAndThrowException(){
        if(nameList.size()<2){
            throw new RuntimeException(ERROR_MESSAGE_FOR_PLAYER_NUMBER);
        }
    }

}
