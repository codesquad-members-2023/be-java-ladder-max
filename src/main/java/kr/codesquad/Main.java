package kr.codesquad;

public class Main {

    public static void main(String[] args) {
        LadderGame game = new LadderGame(new ConsoleInput(new LadderValidator(2, 1)));
        game.start();
    }
}