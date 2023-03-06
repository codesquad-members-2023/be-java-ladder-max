package kr.codesquad;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Output output = new Output();
        output.printPeopleRequest();
        int people = sc.nextInt();
        output.printHeightRequest();
        int height = sc.nextInt();
        new Ladder().setLadder(people, height);
        output.printLadder();
    }
}