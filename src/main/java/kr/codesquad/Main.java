package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        RandomLadderGenerator generator = new RandomLadderGenerator();
        new LadderGame(console, generator).run();
    }
}