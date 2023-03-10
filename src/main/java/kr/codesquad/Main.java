package kr.codesquad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import kr.codesquad.domain.LadderValidator;
import kr.codesquad.service.LadderGame;
import kr.codesquad.view.LadderConsoleReader;
import kr.codesquad.view.LadderConsoleWriter;
import kr.codesquad.view.LadderWriter;

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
