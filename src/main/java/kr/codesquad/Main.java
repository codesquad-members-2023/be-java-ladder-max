package kr.codesquad;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // step-1, step-2
        Console console = new Console();
        console.askParticipants();
        int participantNumber = console.returnIntInput();
        console.askLadderHeight();
        int ladderHeight = console.returnIntInput();

        Ladder ladder = new Ladder(participantNumber, ladderHeight);
        ladder.printLadder();

        // step-3, step-4
        ShapeConsole shapeConsole = new ShapeConsole();
        List<String> participantList = List.of(shapeConsole.returnStringInput().split(","));
    }
}