package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int space;
    private final int height;
    private final List<List<Boolean>> ladders;

    public Ladder(int space, int height) {
        this.space = space;
        this.height = height;
        this.ladders = new ArrayList<>();
        this.makeRandomLadder();
    }

    private void makeRandomLadder() {
        for (int i = 0; i < height; i++) {
            ladders.add(makeRandomRung());
        }
    }

    private List<Boolean> makeRandomRung() {
        List<Boolean> hasRungs = new ArrayList<>();
        for (int i = 0; i < space; i++) {
            hasRungs.add(getRandomBoolean());
        }
        return hasRungs;
    }

    private boolean getRandomBoolean() {
        boolean[] random = {false, true};
        return random[(int) (Math.random() * random.length)];
    }

    public void drawLadder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            builder.append(" ".repeat(2));
            drawingSameHeight(builder, ladders.get(i));
            builder.append(System.lineSeparator());
        }
        System.out.println(builder);
    }

    private void drawingSameHeight(StringBuilder builder, List<Boolean> spaces) {
        for (int j = 0; j < space; j++) {
            drawLeftLine(builder, j);
            builder.append(spaces.get(j) ? "-----" : "     ");
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
