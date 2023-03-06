package kr.codesquad;

public class Ladder {
    private String[][] laddersFrame;

    public String[][] makeLadder(int n, int m) {
        createLadderEmpty(n, m);
        makeLadderLength();

        return new String[0][];
    }

    private void createLadderEmpty(int n, int m) {
        laddersFrame = new String[m][n + 2];
    }

    private void makeLadderLength() {

    }
}
