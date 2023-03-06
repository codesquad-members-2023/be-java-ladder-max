package kr.codesquad;

import kr.codesquad.util.InputOutputManager;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        Ladder ladder = new Ladder();
        InputOutputManager manager = new InputOutputManager(ladder);
        ladder.makeLadder();
        manager.printLadder(ladder);
    }
}