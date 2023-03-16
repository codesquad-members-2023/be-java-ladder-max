package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public  int ladderLength() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return  Integer.parseInt(bufferedReader.readLine());
    }

    public String insertUser() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return bufferedReader.readLine();
    }

    public    String insertResult() throws IOException {
        System.out.println("결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return bufferedReader.readLine();
    }
    public String insertFindUser() throws IOException {
        System.out.println("결과를 보고 싶은 사람은?");
        return bufferedReader.readLine();
    }


    // 유효성 검사 통과한 참가자 입력 값
    public  String vaildName() throws IOException {
        String name = insertUser();
        Validator validator = new Validator();
        while (!validator.nameValidate(name.split(","))){
            name = insertUser();
        }
        return name;
    }


    // 유효성 검사 통과한 결과값 입력 값
    public String vaildResult(int userCount) throws IOException {
        String name = insertResult();
        Validator validator = new Validator();
        int inputLength = name.split(",").length;
        while (!validator.resultValidate(userCount,inputLength)||!validator.nameValidate(name.split(","))){
            name = insertResult();
            inputLength = name.split(",").length;
        }
        return name;
    }
}
