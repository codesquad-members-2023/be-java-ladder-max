package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder2 {

    private int row;
    private int column;
    private String[][] ladder;

    Ladder2(){}
    public Ladder2(int row, int column){
        this.row = row;
        this.column = column;
        ladder = new String[row][column];
    }

    private void makeLadder(){ // 랜덤으로 사다리 내부 만들기
        makeBasic();
        Random random = new Random();
        for (int i=0;i<row;i++){
            ladder[i] = Arrays.stream(ladder[i]).map((s -> s == "-----" ? (random.nextInt(3) == 0 ? "     " : "-----") : s)).toArray(String[]::new);
        }
    }
    private void makeBasic(){ // 사다리 기본 틀 만들기기
        for (int i=0;i<row;i++){
            IntStream intStream = IntStream.range(0,column);
            ladder[i] = intStream.mapToObj(k -> k % 2 == 0 ? "|" : "-----").toArray(String[]::new);
        }
    }
    private void checkLadder(){
        makeLadder();
        for (int k=0;k<column;k++){
            String[] array = ladder[k];
            IntStream.range(1,column-2)
                    .filter(i -> i%2 !=0)
                    .filter(i -> "-----".equals(array[i]))
                    .filter(i -> "-----".equals(array[i+2]))
                    .forEach(i -> array[i] = "     ");
            ladder[k] = array;
        }
    }
    public void printLadder(){ // 사다리 출력하기
        checkLadder();
        for (String[] str : ladder){
            String tmp = Arrays.toString(str).replaceAll("\\[|\\]|,", "");
            System.out.println(tmp);
        }
    }
}
