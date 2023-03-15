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

    private boolean checkDuplicates() {
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

    private String drawCheck(boolean check) {
        return check ? "-----|" : "     |";
    }

    public int moveLine(int userNumber,int countOfPerson){
        if(userNumber>0 && point.get(userNumber-1)){
            return userNumber-1;
        }
        if(userNumber<countOfPerson && point.get(userNumber)) {
            return userNumber+1;
        }
        return userNumber;
    }



    // 테스트 코드를 위한 getter
    public ArrayList<Boolean> getPoint() {
        return point;
    }
}
