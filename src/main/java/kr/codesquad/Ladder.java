package kr.codesquad;

public class Ladder {
    private final int players;
    private final int height;
    private boolean[][] rungs;

    Ladder(int players, int height) {
        this.players = players;
        this.height = height;
        this.rungs = new boolean[height][players - 1];
        buildRungs();
    }

    private void buildRungs() {
        for(int row = 0; row < this.rungs.length; row++) {
            this.rungs[row] = buildRungRow(height);
        }
    }

    private boolean[] buildRungRow(int width) {
        boolean[] rungRow = new boolean[width];

        for(int count = 0; count < rungRow.length; count++) {
            rungRow[count] = buildSingleRung();
        }
        return rungRow;
    }

    private boolean buildSingleRung() {
        double randomNumber = Math.random();

        if (randomNumber >= 0.5) {
            return true;
        }
        return false;
    }

    public boolean[][] getRungs() {
        return this.rungs;
    }
}
