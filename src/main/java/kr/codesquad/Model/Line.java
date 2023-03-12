package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    final int numberOfBars;
    List<Bar> bars = new ArrayList<>();

    public Line(int numberOfBars) {
        this.numberOfBars = numberOfBars;
        makeLine();
    }

    private void makeLine(){
        for(int index = 0; index < numberOfBars; index++){
            bars.add(getLadderLine(index));
        }
    }

    private Bar getLadderLine(int index){
        Random random = new Random();

        boolean isVertical = index%2 == 0;
        boolean isRandomPicked = random.nextBoolean();

        if(isVertical){
            return Bar.VERTICAL;
        }

        if(isRandomPicked){
            return Bar.HORIZONTAL;
        }

        return Bar.BLANK;
    }
}
