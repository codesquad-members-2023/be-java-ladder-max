package kr.codesquad;

import java.util.Random;

public class LadderGenerator {
    int maxHeight;
    int column;
    String[][] ladder;

    public LadderGenerator(int joinMembers, int maxHeight) {
        column = joinMembers + (joinMembers - 1);
        ladder = new String[this.maxHeight = maxHeight][column];
    }

    public String[][] generateLadder() {
        generateLadderArray();
        generateRandomLine();
        generateBorderLine();
        return ladder;
    }

    public void generateLadderArray() {
        ladder = new String[maxHeight][column];
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                ladder[i][j] = " ";
            }
        }
    }

    public void generateRandomLine() {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j % 2 != 0) {
                    Random random = new Random();
                    ladder[i][j] = String.valueOf(random.nextBoolean());
                }
            }
        }
    }

    public void generateBorderLine() {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (ladder[i][j].equals("true")) {
                    ladder[i][j] = "-";
                    continue;
                }
                if (ladder[i][j].equals("false")) {
                    ladder[i][j] = " ";
                    continue;
                }
                ladder[i][j] = "|";
            }
        }
    }
}
