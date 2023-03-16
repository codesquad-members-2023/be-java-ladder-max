package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<String> line;
    public Line(int column){
        makeLine(column);
    }
    private void makeLine(int column){
        makeBasicLine(column);
        boolean front = false; // 왼쪽에 사다리 가로선이 있으면 true
        Random random = new Random();

        for (int i=1;i<column;i+=2){
            if (front){ // 왼쪽에 사다리 가로 선이 있을 때
                front = false;
                continue;
            }
            boolean current = random.nextBoolean();
            String str = current? "-----":"     ";
            line.set(i,str);
            front = current;
        }
    }
    private void makeBasicLine(int column){ // 기본 사다리 한 줄 만들기 ex) |     |     |     |
        IntStream intStream = IntStream.range(0,column);
        line = intStream.mapToObj(i -> i%2==0 ? "|":"     ")
                .collect(Collectors.toCollection(ArrayList::new));
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (String bar : line){
            sb.append(bar);
        }
        return sb.toString();
    }
}
