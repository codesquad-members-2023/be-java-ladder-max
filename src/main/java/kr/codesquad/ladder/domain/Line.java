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

    public String horizontalLine() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        for(int i = 0; i<point.size(); i++) {
            if(point.get(i)){
                stringBuilder.append("-----|");
            } else {
                stringBuilder.append("     |");
            }
        }
        return stringBuilder.toString();
    }

    public List<Boolean> getPoint() {
        return point;
    }
}
