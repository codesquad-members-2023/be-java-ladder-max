package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        LadderMaker ladder = new LadderMaker();
        InputReader inputReader = new InputReader();
        inputReader.startLadderGame();
        ladder.setNamesList(inputReader.getNamesList());
        ladder.make(inputReader.getLadderHeight());
        ladder.printResult();
    }
}


