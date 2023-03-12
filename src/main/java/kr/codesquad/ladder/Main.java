package kr.codesquad.ladder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import kr.codesquad.ladder.domain.LadderGame;
import kr.codesquad.ladder.view.LadderConsoleReader;
import kr.codesquad.ladder.view.LadderConsoleWriter;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;

public class Main {

    public static void main(String[] args) {
        LadderWriter ladderWriter = new LadderConsoleWriter();
        LadderReader ladderReader = new LadderConsoleReader(
            new BufferedReader(new InputStreamReader(System.in)),
            ladderWriter
        );
        LadderGame game = new LadderGame(ladderReader, ladderWriter);
        game.start();
    }
}
