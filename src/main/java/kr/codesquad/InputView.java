package kr.codesquad;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static String inputPeople(){
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextLine();
    }
    public static String inputLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextLine();
    }



}
