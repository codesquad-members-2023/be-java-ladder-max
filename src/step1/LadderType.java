package step1;

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
}
