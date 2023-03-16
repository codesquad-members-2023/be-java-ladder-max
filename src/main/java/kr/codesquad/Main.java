package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderMaker;
import kr.codesquad.view.View;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        List<String> players = view.inputValidatedPlayers();
        int height = view.inputHeight();
        LadderMaker maker = new LadderMaker();
        Ladder ladder = maker.makeRandomLadder(players.size() - 1, height);
        String ladderFigure = ladder.drawLadder();
        view.printWholeFigure(players, ladderFigure);
    }
}