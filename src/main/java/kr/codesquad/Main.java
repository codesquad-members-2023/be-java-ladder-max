package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        console.askParticipant();
        int participantNumber = console.returnInput();
        console.askLadderHeight();
        int ladderHeight = console.returnInput();

        Ladder ladder = new Ladder(participantNumber, ladderHeight);
        ladder.printLadder();
    }
}