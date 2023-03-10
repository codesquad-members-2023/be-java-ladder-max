package main.java.kr.codesquad.step1;

import java.util.stream.Stream;

public enum LadderType {
    ROW("-", 0), BLANK(" ", 1), HEIGHT("|", 2);
    final String ladderType;
    final int LadderTypeValue;

    LadderType(String ladderType, int LadderTypeValue) {
        this.ladderType = ladderType;
        this.LadderTypeValue = LadderTypeValue;
    }

    public String getLadderType() {
        return ladderType;
    }

    public static LadderType findConnectionLadder(int inputLadderTypeValue){
        return Stream.of(values())
                .filter(randomLadderTypeValue -> isaEqualLadderTypeValue(inputLadderTypeValue,randomLadderTypeValue))
                .findFirst()
                .orElse(BLANK);
    }

    private static boolean isaEqualLadderTypeValue(int inputLadderTypeValue, LadderType ladderType){
        return ladderType.LadderTypeValue == inputLadderTypeValue;
    }
}
