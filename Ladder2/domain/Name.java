package Ladder2.domain;

public class Name {

    public final static int nameSizeRestriction = 5;

    private final String name;

    public Name(String name){
        this.name = this.validateName(name);
    }

    private String validateName(String name) {
        if (isGreaterThanFive(name)){
            throw new IllegalArgumentException("5글자 이하만 입력해 주세요.");
        }
        return name;

    }
    private boolean isGreaterThanFive(String input) {
        if (input.length() > nameSizeRestriction){
            return true;
        }
        return false;
    }

    public int getLength(){
        return this.name.length();
    }

    public String getName(){
        return this.name;
    }
}
