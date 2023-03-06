package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        InputRequest inputRequest = new InputRequest();
        Integer count = inputRequest.requestPeopleCount();
        Integer height = inputRequest.requestLadderHeight();
        System.out.println("count = " + count);
        System.out.println("height = " + height);
    }
}
