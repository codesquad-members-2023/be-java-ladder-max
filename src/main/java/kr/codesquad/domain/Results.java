package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final ArrayList<String> resultList;

    public Results() {
        this.resultList = new ArrayList();
    }
    String getResultFromResultList(int i){
        return resultList.get(i);
    }

    public boolean getResultsFromUser(String strResults, int sizeOfNameList){
        try {
            resultList.addAll(parseInputStringToResultList(strResults));
            validateNumOfResultList(resultList,sizeOfNameList);
            return true;
        } catch (RuntimeException e) {
            resultList.clear();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String result: resultList){
            sb.append(String.format(" %1$-5s", result));
        }
        return sb.toString();
    }
}
