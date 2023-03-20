package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<String> resultList;

    public Results(List results) {
        this.resultList = results;
    }
    String getResultFromResultList(int i){
        return resultList.get(i);
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
