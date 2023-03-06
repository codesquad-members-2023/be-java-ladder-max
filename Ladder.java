import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private final String[][] line;
    private final String[][] person;

    public Ladder(int numPerson, int numLine) {
        line = new String[numLine][numPerson - 1];
        person = new String[numLine][numPerson];
    }

    public void fillPerson() {
        Arrays.stream(person).forEach(row -> Arrays.fill(row, "|"));
    }

    public void fillLine() {
        String[] str = {"-", " "};
        Arrays.stream(line).forEach(row -> Arrays.fill(row, str[new Random().nextInt(2)]));
    }
}
