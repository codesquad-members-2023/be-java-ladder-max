package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int people = main.inputPeople();
        int height = main.inputHeight();

        Ladder ladder = new Ladder(people, height);
        ladder.printLadder();

        //new Ladder().printVerticalLine(n, m);
    }

    private int inputPeople() throws IOException {
        printInputPeople();
        return input();
    }

    private int inputHeight() throws IOException {
        printInputHeight();
        return input();
    }

    private int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    private void printInputPeople() {
        System.out.println("참여할 사람은 몇 명 인가요?");
    }

    private void printInputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }
}