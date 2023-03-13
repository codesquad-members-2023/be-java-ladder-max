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

    private boolean isDrawnBefore(int index){
        return index > 2 && bars.get(index-2).equals(Bar.HORIZONTAL);
    }

    private Bar getLadderLine(int index){
        Random random = new Random();

        boolean isVertical = index%2 == 0;
        boolean isRandomPicked = random.nextBoolean();

        if(isVertical){
            return Bar.VERTICAL;
        }

        if(!isDrawnBefore(index) && isRandomPicked){
            return Bar.HORIZONTAL;
        }

        return Bar.BLANK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numberOfBars; i++){
            sb.append(bars.get(i).getBar());
        }
        return sb.toString();
    }
}
