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

    void getName(ArrayList list) throws IOException {
        while (true) {
            if (validateInputList(list)) break;
        }
    }

    private boolean validateInputList(ArrayList list) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            parseAndValidateInputString(list, br);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void parseAndValidateInputString(ArrayList list, BufferedReader br) throws IOException {
        List<String> inputList = Arrays.stream(br.readLine().split(","))
                .map(str -> validate(str))
                .collect(Collectors.toList());
        list.addAll(inputList);
    }

    private String validate(String str) {
        if (str.length() > 5) {
            throw new RuntimeException("5글자 이상인 이름 발견 (" + str+ ") 재입력 할것 ");
        }
        return str;
    }
}
