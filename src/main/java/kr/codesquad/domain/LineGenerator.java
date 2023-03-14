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

    // 순서대로 index 가 0이 아닐 때, 바로 이전 값이 true 일 경우 'List<Boolean> line' 에 false add , randomBoolean 을 통해 얻은 값 'line' 에 add
    public void randomGenerateLine(int index) {
        if(index != 0 && line.get(index-1)){
            line.add(false);
            return;
        }
        line.add(randomBoolean());
    }

    public boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
