package kr.codesquad.step2;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int SIDE_WALL = 2;
    private static final int BLANK_OR_ROW = 2;
    private static final int EVEN = 2;
    Random random;
    int participatePeople;
    int ladderHeight;
    int[][] map;

    public Ladder(int participatePeople, int ladderHeight) {
        this.participatePeople = participatePeople;
        this.ladderHeight = ladderHeight;
        map = new int[participatePeople][ladderHeight];
        random = new Random();
    }

    public StringBuilder generateLadder() {
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> generateLadderRow())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }

    private String generateLadderRow(){
        return IntStream.range(0,participatePeople+SIDE_WALL)
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
