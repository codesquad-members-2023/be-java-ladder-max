package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        LadderMaker ladderMaker = new LadderMaker();
        InputReader inputReader = new InputReader();
        inputReader.startLadderGame();
        ladderMaker.make(inputReader.getNamesList(), inputReader.getLadderHeight());
        ladderMaker.printResult();
    }
}


