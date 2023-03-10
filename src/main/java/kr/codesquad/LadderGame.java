package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LadderGame {
    public static void startLadderGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input();
        ArrayList<String> names = input.inputNames(br);
        int horizontalLine = input.input(br);

        Ladder ladder = new Ladder(names.size(), horizontalLine);
        Output.print(names, ladder);
    }
}
