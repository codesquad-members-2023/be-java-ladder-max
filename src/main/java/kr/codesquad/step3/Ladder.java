package kr.codesquad.step3;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int EVEN_WALL = 3;
    private static final int ODD_WALL = 2;
    private static final int BLANK_OR_ROW = 2;
    private static final int EVEN = 2;
    Random random;
    int ladderRow;
    int ladderHeight;
    int[][] map;

    public Ladder(int participatePeople, int ladderHeight) {
        this.ladderRow = countLadderRow(participatePeople);
        this.ladderHeight = ladderHeight;
        map = new int[participatePeople][ladderHeight];
        random = new Random();
    }

    private int countLadderRow(int participatePeople){
        if(participatePeople%EVEN == 0){
            return participatePeople+EVEN_WALL;
        }
        return participatePeople+ODD_WALL;
    }

    public StringBuilder generateLadder() {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> generateLadderRow())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }

    private String generateLadderRow(){
        return IntStream.range(0,ladderRow)
                .mapToObj(ladderType->getLadderType(ladderType))
                .collect(Collectors.joining())+"\n";
    }

    private String getLadderType(int ladderType){
        if(ladderType%EVEN == 0){
            return LadderType.HEIGHT.getLadderType();
        }
        int randomConnectionLadder = random.nextInt(BLANK_OR_ROW);
        return LadderType.findConnectionLadder(randomConnectionLadder).getLadderType();
    }
}
