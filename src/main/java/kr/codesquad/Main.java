package kr.codesquad;

import kr.codesquad.domain.LadderGame;
import kr.codesquad.domain.RandomLadderGenerator;
import kr.codesquad.view.Console;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        RandomLadderGenerator generator = new RandomLadderGenerator();
        new LadderGame(console, generator).run();
    }
}