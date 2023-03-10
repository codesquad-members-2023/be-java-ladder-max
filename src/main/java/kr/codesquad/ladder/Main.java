package kr.codesquad.ladder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import kr.codesquad.ladder.domain.LadderValidator;
import kr.codesquad.ladder.domain.LadderGame;
import kr.codesquad.ladder.view.LadderConsoleReader;
import kr.codesquad.ladder.view.LadderConsoleWriter;
import kr.codesquad.ladder.view.LadderWriter;

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
