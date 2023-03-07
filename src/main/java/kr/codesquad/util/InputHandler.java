package kr.codesquad.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    //Test를 위해 BufferReader를 각 메서드 안에 넣어주었다.
    int getHeight() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine().toString());
    }

    public void getName(ArrayList list) throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                List<String> inputList = Arrays.stream(br.readLine().split(","))
                        .map(str -> validate(str))
                        .collect(Collectors.toList());
                list.addAll(inputList);
                break;
            } catch (RuntimeException e) {
                System.out.println("재입력 해주세요");
            }
        }
    }

    String validate(String str) {
        if (str.length() > 5) {
            throw new RuntimeException("5글자 이상인 이름 발견 " + str);
        }
        return str;
    }


}
