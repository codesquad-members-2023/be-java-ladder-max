package kr.codesquad;

public class Main {
    public static void main(String args[]) {
        Ladder ladder = new Ladder();
        Inputer inputer = new Inputer();
        inputer.seting();
        ladder.init(inputer.getLadderNum(), inputer.getNames());
        ladder.printResult();
    }
}
