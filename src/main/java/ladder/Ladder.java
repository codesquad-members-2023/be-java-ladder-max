package ladder;

public class Ladder {
    private final int space;
    private final int height;
    private boolean[][] ladders;

    public Ladder(int participants, int height) {
        this.space = participants - 1;
        this.height = height;
        this.ladders = new boolean[this.height][this.space];
        this.makeRandomLine();
    }

    private void makeRandomLine() {
        boolean[] random = {false, true};
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < space; j++) {
                ladders[i][j] = random[(int) (Math.random() * 2)];
            }
        }
    }
}
