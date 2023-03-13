package kr.codesquad;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputHandler handler = new InputHandler();
        List<String> players = handler.inputValidatedPlayers();
        int height = handler.inputValidatedHeight();
        Ladder ladder = new Ladder(players, height);
        List<List<Boolean>> ladderInformation = ladder.informLadder();
        Output output = new Output();
        List<String> ladderShape = output.lineToString(ladderInformation);
        output.printPlayers(players);
        for (String shape : ladderShape) {
            System.out.println(shape.toString());
        }
    }
}