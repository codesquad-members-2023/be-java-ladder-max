package kr.codesquad;

public class Ladder {

    private final int numberOfPeople;
    private final int maximumLadderHeight;

    public Ladder(int numberOfPeople, int maximumLadderHeight) {
        this.numberOfPeople = numberOfPeople;
        this.maximumLadderHeight = maximumLadderHeight;
    }

    public String[][] createLadderBoard() {
        int height = maximumLadderHeight;
        int width = numberOfPeople * 2 - 1;
        return new String[height][width];
    }
}
