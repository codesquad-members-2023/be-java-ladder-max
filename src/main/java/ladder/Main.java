package ladder;

import java.io.IOException;

import ladder.domain.LadderController;

public class Main {
    public static void main(String[] args) throws IOException {
        LadderController ladderController = new LadderController();
        ladderController.run();
    }
}
