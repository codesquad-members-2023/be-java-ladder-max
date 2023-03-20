package kr.codesquad.domain;

import java.util.List;

public class Results {

    private final List<String> resultList;

    public Results(List results) {
        this.resultList = results;
    }
    public String getResultFromResultList(int i){
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
