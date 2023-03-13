package kr.codesquad.domain;

import kr.codesquad.view.Input;
import kr.codesquad.view.Output;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private Input input = new Input();
    private Output output = new Output();
    private Ladder ladder;
    private Names names;
    private Results results;

    public void run() {
        try {
            names = new Names(input.inputName());
            results = new Results(input.inputResult());
            ladder = new Ladder(names.size(), input.inputHeight());

            output.printLadder(ladder.toString(), names.toString(), results.toString());

            while (true) {
                playLadderGameByInput(input.inputNameCommand());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playLadderGameByInput(String inputName) {
        if (inputName.equals("all")) {
            playAllLadderGame();
            return;
        }
        if (inputName.equals("춘식이")) {
            System.out.println("\n게임을 종료합니다.");
            System.exit(1);
        }

        playLadderGameByName(inputName);
    }

    public void playLadderGameByName(String name) {
        output.printPlayerResult(results.get(ladder.moveDown(names.indexOf(name))));
    }

    public void playAllLadderGame() {
        Map<String, String> nameResultPair = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            nameResultPair.put(names.get(i), results.get(ladder.moveDown(i)));
        }
        output.printAllResult(nameResultPair);
    }
}
