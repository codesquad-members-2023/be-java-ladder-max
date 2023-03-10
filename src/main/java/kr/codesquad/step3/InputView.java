package kr.codesquad.step3;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);
    public static int inputParticipatePeople(){
        return scanner.nextInt();
    }


    public static int inputNumTheMostLadderHeight(){
        return scanner.nextInt();
    }

    public static String inputParticipatePeopleName(){
        return scanner.nextLine();
    }
}
