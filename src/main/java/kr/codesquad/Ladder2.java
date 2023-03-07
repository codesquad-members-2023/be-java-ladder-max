package kr.codesquad;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder2 {

    private int row;
    private int column;
    private String[][] ladder;

    public Ladder2(){}
    public Ladder2(int row, Player player){
        this.row = row;
        this.column = player.getHeadCount()*2-1;
        ladder = new String[row][column];
    }

    private void makeRandom(){ // 랜덤으로 사다리 내부 만들기
        Random random = new Random();
        for (int i=0;i<row;i++){
            ladder[i] = Arrays.stream(ladder[i]).map((s -> s == "-----" ? (random.nextInt(4) == 0 ? "     " : "-----") : s)).toArray(String[]::new);
        }
    }
    private void makeBasic(){ // 사다리 기본 틀 만들기
        for (int i=0;i<row;i++){
            IntStream intStream = IntStream.range(0,column);
            ladder[i] = intStream.mapToObj(k -> k % 2 == 0 ? "|" : "-----").toArray(String[]::new);
        }
    }
    private void checkLadder(){ // 가로 라인이 겹치는 경우, 앞 라인을 "     "으로 변경하기
        for (int k=0;k<row;k++){
            String[] array = ladder[k];
            IntStream.range(1,column-2)
                    .filter(i -> i%2 !=0)
                    .filter(i -> "-----".equals(array[i]))
                    .filter(i -> "-----".equals(array[i+2]))
                    .forEach(i -> array[i] = "     ");
            ladder[k] = array;
        }
    }
    public String[][] makeLadder(){
        makeBasic();
        makeRandom();
        checkLadder();

        return ladder;
    }
}
