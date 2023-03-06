import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numPerson = Input.inputPerson(br);
        int numLine = Input.inputLine(br);

        Ladder ladder = new Ladder(numPerson, numLine);
        Output.printLadder(ladder);
    }
}
