package kr.codesquad;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Input input = new Input();
        System.out.println("참여할 사람은 몇 명인가요?");
        int width = input.value();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int length = input.value();
        Ladder ladder = new Ladder(width,length);
        String[][] arr = ladder.createBasicArr();;
        ladder.printGame(arr);

//        for (int i = 0; i < arr.length; i++) {
//            String[] inArr = arr[i];
//            for (int j = 0; j < inArr.length; j++) {
//                System.out.print(inArr[j] + " ");
//            }
//            System.out.println();
//        }



    }
}