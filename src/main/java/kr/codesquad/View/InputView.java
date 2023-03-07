package kr.codesquad.View;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);
    public static Integer getLadderWidth(){
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt() - 1;
    }
    public static Integer getLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

}
