package main.java.kr.ladder;

import main.java.kr.ladder.domain.LadderGameController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LadderGameController ladderGame = new LadderGameController();
        ladderGame.run();
    }
}
