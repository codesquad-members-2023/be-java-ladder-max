package kr.codesquad;

import java.util.Arrays;

public class PrintLadder {

    public static void printLadder(String[][] ladder){ // 사다리 출력하기
        for (String[] str : ladder){
            String tmp = Arrays.toString(str).replaceAll("\\[|\\]|,", "");
            System.out.println(tmp);
        }
    }
}
