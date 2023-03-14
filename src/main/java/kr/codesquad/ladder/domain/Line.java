package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Line {
    private ArrayList<Boolean> point = new ArrayList<>();

    public Line(int countOfPerson) {
        for(int i = 0; i<countOfPerson; i++){
            point.add(checkDuplicates());
        }
    }

    public boolean checkDuplicates() {
        if(point.isEmpty()){
            return new Random().nextBoolean();
        }
        return new Random().nextBoolean()&&!point.get(point.size()-1);
    }

    @Override
    public String toString() {
        return " |" + point.stream()
                .map(check -> drawCheck(check))
                .collect(Collectors.joining());
    }

    public String drawCheck(boolean check) {
        return check ? "-----|" : "     |";
    }

    // 테스트 코드를 위한 getter
    public ArrayList<Boolean> getPoint() {
        return point;
    }
}
