package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        //final Ladder ladder = LadderGenerator.of(Screen.inputPlayerNumber(), Screen.inputLadderHeight());
        final Ladder ladder = LadderGenerator.of(Screen.inputPlayerNames(), Screen.inputLadderHeight());

        final LadderGame ladderGame = new LadderGame(ladder);

        ladderGame.run();
    }
}