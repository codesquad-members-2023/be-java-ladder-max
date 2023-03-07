package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        int numPerson = Input.input();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int numLine = Input.input();

        Ladder ladder = new Ladder(numPerson, numLine);
        Output.printLadder(ladder);
    }
}