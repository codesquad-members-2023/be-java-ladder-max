package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        Inputer inputer = new Inputer();
        inputer.startLadder();
        ladder.init(inputer.getNamesList());
        ladder.makeLadder(inputer.getLadderNum());
        ladder.printResult();
    }
}


