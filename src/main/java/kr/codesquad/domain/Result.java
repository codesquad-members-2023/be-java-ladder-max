package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    public boolean getResult(ArrayList list, InputView inputHandler,int sizeOfNameList){
        try {
            list.addAll(parseInputStringToResultList(inputHandler.getInput()));
            validateNumOfResultList(list,sizeOfNameList);
            return true;
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private List<String> parseInputStringToResultList(String strContainsName) {
        return Arrays.stream(strContainsName.split(","))
                .collect(Collectors.toList());
    }

    private void validateNumOfResultList(ArrayList list,int sizeOfNameList) {
        if (list.size() != sizeOfNameList) {
            throw new RuntimeException("실행결과 갯수와 player갯수가 다릅니다");
        }
    }
}
