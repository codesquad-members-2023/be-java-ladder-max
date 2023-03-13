package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Line {
    private ArrayList<Boolean> point = new ArrayList<>();

    public Line(int countOfPerson) {
       // point.add(false);
        for(int i = 0; i<countOfPerson; i++){
            point.add(checkDuplicates(i));
        }
    }

    public boolean checkDuplicates(int i) {
        if(point.isEmpty()){
            return new Random().nextBoolean();
        }
        return new Random().nextBoolean()&&!point.get(point.size()-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" |");
        for(int i = 0; i<point.size(); i++) {
            drawCheck(point.get(i),stringBuilder);
        }
        return stringBuilder.toString();
    }

    public StringBuilder drawCheck(boolean check,StringBuilder stringBuilder) {
        if(check) {
            return stringBuilder.append("-----|");
        }
        return stringBuilder.append("     |");
    }
}
