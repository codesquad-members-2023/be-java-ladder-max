package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintLadder {

    public static void printLadder(ArrayList<ArrayList<String>> ladder){ // 사다리 출력하기
        for (ArrayList<String> str : ladder){
            String tmp = str.toString().replaceAll("\\[|\\]|,", "");
            System.out.println(tmp);
        }
    }
}
