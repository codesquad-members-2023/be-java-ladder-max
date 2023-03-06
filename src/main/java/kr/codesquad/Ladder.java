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
            for(int column = 0; column < this.rungs[row].length; column++) {
                double random = Math.random();

                if (random >= 0.5) {
                    this.rungs[row][column] = true;
                } else {
                    this.rungs[row][column] = false;
                }

            }
        }
    }

    public boolean[][] getRungs() {
        return this.rungs;
    }
}
