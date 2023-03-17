package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.dto.ResultDto;

import java.util.List;

public class Validator {

    // 이름 길이 유효성 검사 start
    public boolean nameValidate(String[] name){
        try {
            checkLimit(name);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void checkLimit(String[] name){
        for(String temp : name) {
           statementLimit(temp);
        }
    }
    public void statementLimit(String name) {
        if(name.length()>5) {
            throw new IllegalArgumentException("각 항목은 다섯글자 이하로 입력해주세요");
        }
    }
    // 이름 길이 유효성 검사 end

    // start 참가자 수와 결과수 유효성 검사
    public boolean resultValidate(int userCount,int resultLength){
        try {
            checkSize(userCount,resultLength);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void checkSize(int userCount,int resultLength){
        if(userCount != resultLength) {
            throw new IllegalArgumentException("입력한 유저 수와 결과 수가 다릅니다.");
        }
    }
    // end 참가자 수와 결과수 유효성 검사

}
