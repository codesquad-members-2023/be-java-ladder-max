package kr.codesquad;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        LadderWriter ladderWriter = new LadderConsoleWriter();
        LadderConsoleReader ladderConsoleReader =
            new LadderConsoleReader(
                new BufferedReader(new InputStreamReader(System.in)),
                new LadderValidator(2, 1),
                ladderWriter
            );
        LadderGame game = new LadderGame(ladderConsoleReader, ladderWriter);
        game.start();
    }
}
