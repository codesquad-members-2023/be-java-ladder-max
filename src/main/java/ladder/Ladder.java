package ladder;

public class Ladder {
    private final int space;
    private final int height;
    private final boolean[][] ladders;

    public Ladder(int space, int height) {
        this.space = space;
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
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            builder.append(" ".repeat(2));
            drawingSameHeight(builder, i);
            builder.append(System.lineSeparator());
        }
        System.out.println(builder);
    }

    private void drawingSameHeight(StringBuilder builder, int height) {
        for (int j = 0; j < space; j++) {
            drawLeftLine(builder, j);
            builder.append(ladders[height][j] ? "-----" : "     ");
            drawRightLine(builder);
        }
    }

    private void drawLeftLine(StringBuilder builder, int space) {
        if (space == 0) {
            drawRightLine(builder);
        }
    }

    private void drawRightLine(StringBuilder builder) {
        builder.append("|");
    }
}
