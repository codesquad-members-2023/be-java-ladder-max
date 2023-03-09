package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        final LadderGame ladderGame = new LadderGame(new LadderGenerator(), new Screen());

        ladderGame.run();
    }
}