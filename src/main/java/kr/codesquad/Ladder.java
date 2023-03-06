package kr.codesquad;

public class Ladder {
    private String[][] laddersFrame;

    public String[][] makeLadder(int n, int m) {
        createLadderEmpty(n, m);
        makeLadderLength(n, m);

        return new String[0][];
    }

    private void createLadderEmpty(int n, int m) {
        laddersFrame = new String[m][n + 2];
    }

    private void makeLadderLength(int n, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 2; j = j + 2) {
                laddersFrame[i][j] = "|";
            }
        }
    }
}
