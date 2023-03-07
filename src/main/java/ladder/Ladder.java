package ladder;

public class Ladder {
    private final int space;
    private final int height;
    private final boolean[][] ladders;

    public Ladder(int participants, int height) {
        this.space = participants - 1;
        this.height = height;
        this.ladders = new boolean[this.height][this.space];
        this.makeRandomLadder();
    }

    private void makeRandomLadder() {
        for (int i = 0; i < height; i++) {
            makeRandomRung(i);
        }
    }

    private void makeRandomRung(int height) {
        for (int i = 0; i < space; i++) {
            ladders[height][i] = getRandomBoolean();
        }
    }

    private boolean getRandomBoolean() {
        boolean[] random = {false, true};
        return random[(int) (Math.random() * random.length)];
    }

    public void drawLadder() {
        for (int i = 0; i < height; i++) {
            drawingSameHeight(i);
            System.out.println();
        }
    }

    private void drawingSameHeight(int height) {
        for (int j = 0; j < space; j++) {
            drawLeftLine(j);
            System.out.print(ladders[height][j] ? "-" : " ");
            drawRightLine();
        }
    }

    private void drawLeftLine(int space) {
        if (space == 0) {
            drawRightLine();
        }
    }

    private void drawRightLine() {
        System.out.print("|");
    }
}
