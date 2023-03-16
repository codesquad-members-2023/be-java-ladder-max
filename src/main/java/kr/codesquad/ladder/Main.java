package kr.codesquad.ladder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import kr.codesquad.ladder.controller.LadderConsoleReaderController;
import kr.codesquad.ladder.controller.LadderGame;
import kr.codesquad.ladder.view.LadderConsoleReader;
import kr.codesquad.ladder.view.LadderConsoleWriter;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;

public class Main {

    public static void main(String[] args) {
        LadderWriter ladderWriter = new LadderConsoleWriter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LadderReader ladderReader = new LadderConsoleReader(reader, ladderWriter);
        LadderConsoleReaderController readerController = new LadderConsoleReaderController(
            ladderReader, ladderWriter);
        LadderGame game = new LadderGame(readerController, ladderWriter);
        game.start();
    }
}
