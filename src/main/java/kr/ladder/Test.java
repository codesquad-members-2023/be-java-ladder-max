package kr.ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        if(name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 이름은 1글자 이상, 5글자 이하로 입력해 주세요.(※ " + name + ")");
        }
        System.out.println("하이하이");
    }
}
