package kr.codesquad.model;

public class Ladder {
    private String[][] laddersFrame;
    private int length;
    private int width;

    public String[][] makeLadder(int n, int m) {
        createLadderEmpty(n, m);
        makeLadderVerticalLine();
        makeLadderHorizontalLine();
        return laddersFrame;
    }

    private void createLadderEmpty(int n, int m) {
        this.length = m;
        this.width = n + (n - 1);
        laddersFrame = new String[length][width];
    }

    private void makeLadderVerticalLine() {
        for (int i = 0; i < length; i++) {
            fillLadderVerticalLine(i);
        }
    }

    private void fillLadderVerticalLine(int row) {
        for (int i = 0; i < width; i += 2) {
            laddersFrame[row][i] = "|";
        }
    }

    private void makeLadderHorizontalLine() {
        for (int i = 0; i < length; i++) {
            fillLadderHorizontalLine(i);
        }
    }

    private void fillLadderHorizontalLine(int row) {
        for (int j = 1; j < width; j += 2) {
            laddersFrame[row][j] = LadderLine.takeRandom();
        }
    }
}
