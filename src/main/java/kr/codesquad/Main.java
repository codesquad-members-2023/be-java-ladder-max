package kr.codesquad;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        List<String> players = input.inputValidatedPlayers();
        int height = input.inputHeight();
        LadderMaker maker = new LadderMaker();
        Ladder ladder = maker.makeRandomLadder(players.size() - 1, height);
        String ladderFigure = ladder.drawLadder();
        Output output = new Output();
        output.printWholeFigure(players, ladderFigure);
    }
}