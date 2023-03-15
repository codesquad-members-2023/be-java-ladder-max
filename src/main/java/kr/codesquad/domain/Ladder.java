package kr.codesquad.domain;

import java.util.ArrayList;

public class Ladder {

    private int row;
    private int column;
    private ArrayList<Line> ladder;

    public Ladder(int row, int headCount){
        this.row = row;
        this.column = headCount*2-1;
        this.ladder = new ArrayList<>();
    }

    public String make(){
        for (int i=0;i<row;i++){
            ladder.add(new Line(column));
        }
        return toStringLadder();
    }

    private String toStringLadder(){ // 사다리 출력하기
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder){
            sb.append(line.toString()+"\n");
        }
        return sb.toString();
    }
}
