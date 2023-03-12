package kr.codesquad;

public class Main {
    public static void main(String args[]) {
        Ladder ladder = new Ladder();
        Inputer inputer = new Inputer();
        ladder.init(inputer.seting());
        ladder.makeLadder(inputer.getLadderNum());
        ladder.printResult();
    }
}
