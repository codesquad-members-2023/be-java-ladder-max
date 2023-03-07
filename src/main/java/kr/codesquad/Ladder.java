package kr.codesquad;

import java.util.Arrays;
import java.util.Random;

public class Ladder {
    protected String[][] line;
    protected String[][] person;

    public Ladder(int numPerson, int numLine) {
        line = new String[numLine][numPerson - 1];
        person = new String[numLine][numPerson];

        fillPerson();
        fillLine();
    }

    public void fillPerson() {
        Arrays.stream(person).forEach(row -> Arrays.fill(row, "|"));
    }

    public void fillLine() {
        String[] str = {"-", " "};
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[0].length; j++) {
                line[i][j] = str[new Random().nextInt(2)];
            }
        }
    }
}
