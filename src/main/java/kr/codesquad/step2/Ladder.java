package kr.codesquad.step2;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int ODD_WALL = 1;
    private static final int EVEN_WALL = 2;
    private static final int BLANK_OR_ROW = 2;
    private static final int EVEN = 2;
    Random random;
    int ladderHeight;
    int ladderRow;
    int[][] map;

    public Ladder(int participatePeople, int ladderHeight) {
        this.ladderRow = makeLadderRowLength(participatePeople);
        this.ladderHeight = ladderHeight;
        map = new int[participatePeople][ladderRow];
        random = new Random();
    }

    private int makeLadderRowLength(int participatePeople){
        if(participatePeople%2 == 0){
            return participatePeople+EVEN_WALL+(participatePeople/2);
        }
        return participatePeople+(ODD_WALL)+((participatePeople+1)/2)-1;
    }

    public StringBuilder generateLadder() {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> generateLadderRow())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }

    private String generateLadderRow(){
        return IntStream.range(0,ladderRow)
                .mapToObj(this::getLadderType)
                .collect(Collectors.joining())+"\n";
    }

    private String getLadderType(int ladderType){
        if(ladderType%EVEN == 0){
            return LadderType.HEIGHT.getLadderType();
        }
        return LadderType.findConnectionLadder(createRandomConnectionLadder(ladderType)).getLadderType();
    }

    private int createRandomConnectionLadder(int ladderType) {
        // 랜덤으로 결정하는 대신, 미리 결정된 랜덤값을 사용합니다.
        return (ladderType / 2) % BLANK_OR_ROW;
    }
}