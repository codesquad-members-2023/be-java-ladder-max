package kr.codesquad.ladder.view;

public class Validator {

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
            throw new IllegalArgumentException("이름은 다섯글자 이하로 입력해주세요");
        }
    }
}
