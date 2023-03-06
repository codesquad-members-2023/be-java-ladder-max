package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        console.askParticipant();
        String participant = console.returnInput();
        console.askLadderHeight();
        String ladderHeight = console.returnInput();
    }
}