package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    List<Boolean> line = new ArrayList<>();

    public Line execute(int playerSize){
        for(int i = 0; i < playerSize; i++){
            randomGenerateLine(i);
        }
        return new Line(line);
    }

    public void randomGenerateLine(int index) {
        if(index != 0 && line.get(index-1)){
            line.add(false);
            return;
        }
        if(randomBoolean()){
            line.add(true);
            return;
        }
        line.add(false);
    }

    public boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
