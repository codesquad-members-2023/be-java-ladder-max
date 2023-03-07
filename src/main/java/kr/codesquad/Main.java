package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        int players = input.inputPlayers();
        int height = input.inputHeight();
        Ladder ladder = new Ladder(players, height);
        Output output= new Output();

        output.printLadder(ladder.getRungs());
    }
}