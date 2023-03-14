package kr.codesquad.domain;

import kr.codesquad.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private int row;
    private int column;
    private ArrayList<Line> ladder;

    public Ladder(){}
    public Ladder(int row, Player player){
        this.row = row;
        this.column = player.getHeadCount()*2-1;
        ladder = new ArrayList<Line>();;
    }

    private void makeRandom(){ // 랜덤으로 사다리 내부 만들기
        Random random = new Random();
        for (int i=0;i<row;i++){
            ArrayList tmp = (ladder.get(i)).stream().map((s -> s == "-----" ? (random.nextInt(2) == 0 ? "     " : "-----") : s)).collect(Collectors.toCollection(ArrayList::new));
            ladder.set(i,tmp);
        }
    }
    private void makeBasic(){ // 사다리 기본 틀 만들기
        for (int i=0;i<row;i++){
            IntStream intStream = IntStream.range(0,column);
            ArrayList<String> list = intStream.mapToObj(k -> k % 2 == 0 ? "|" : "-----").collect(Collectors.toCollection(ArrayList::new));
            ladder.add(list);
        }
    }
    private void checkLadder(){ // 가로 라인이 겹치는 경우, 앞 라인을 "     "으로 변경하기
        Random random = new Random();
        for (int k=0;k<row;k++){
            ArrayList array = ladder.get(k);
            IntStream.range(1,column-2)
                    .filter(i -> i%2 !=0)
                    .filter(i -> "-----".equals(array.get(i)))
                    .filter(i -> "-----".equals(array.get(i+2)))
                    .forEach(i -> array.set(i,"     "));
            ladder.set(k,array);
        }
    }
    public String makeLadder(){
        makeBasic();
        makeRandom();
        checkLadder();

        return printLadder();
    }
    private String printLadder(){ // 사다리 출력하기
        for (Line str : ladder){
            String tmp = str.toString().replaceAll("\\[|\\]|,", "");
            System.out.println(tmp);
        }
    }
}
