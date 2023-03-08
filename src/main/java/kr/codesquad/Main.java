package kr.codesquad;

public class Main {
    public static void main(String[] args) {
//        final Ladder ladder = LadderGenerator.of(Screen.inputPlayerNumber(), Screen.inputLadderHeight());
        final Screen screen = new Screen();
        final Ladder ladder = LadderGenerator.of(screen.inputPlayerNames(), screen.inputLadderHeight());

        final LadderGame ladderGame = new LadderGame(ladder);

        ladderGame.run();
    }
}