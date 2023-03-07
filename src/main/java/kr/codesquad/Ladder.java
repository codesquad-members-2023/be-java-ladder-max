package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private int row;
    private int column;
    private Character[][] ladder;

    Ladder(){}
    Ladder(int row, int column){
        this.row = row;
        this.column = column;
        ladder = new Character[row][column];
    }

    private void makeLadder(){ // 랜덤으로 사다리 내부 만들기
        makeBasic();
        Random random = new Random();
        for (int i=0;i<row;i++){
            ladder[i] = Arrays.stream(ladder[i]).map((c -> c == '-' ? (random.nextInt(2) == 0 ? ' ' : '-') : c)).toArray(Character[]::new);
        }
    }
    private void makeBasic(){ // 사다리 기본 틀 만들기
        for (int i=0;i<row;i++){
            IntStream intStream = IntStream.range(0,column);
            Random random = new Random();
            ladder[i] = intStream.mapToObj(k -> k % 2 == 0 ? '|' : '-').toArray(Character[]::new);
        }
    }
    public void printLadder(){ // 사다리 출력하기
        makeLadder();
        for (Character[] ch : ladder){
            String str = Arrays.toString(ch).replaceAll("\\[|\\]|,", "");
            System.out.println(str);
        }
    }
}
