package kr.codesquad;

public class Ladder {
    private String[][] laddersFrame;
    private int length;
    private int width;

    public String[][] makeLadder(int n, int m) {
        createLadderEmpty(n, m);
        makeLadderLength();
        makeLadderWidth();

        return new String[0][];
    }

    private void makeLadderWidth() {
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < width; j += 2) {
                laddersFrame[i][j] = LadderLine.takeRandom();
            }
        }
    }

    private void createLadderEmpty(int n, int m) {
        this.length = m;
        this.width = n + 2;
        laddersFrame = new String[length][width];
    }

    private void makeLadderLength() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j += 2) {
                laddersFrame[i][j] = "|";
            }
        }
    }
}
