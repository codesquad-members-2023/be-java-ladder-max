package kr.codesquad.view;

public class Output {
    public void printMessageN() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public void printMessageNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printMessageM() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadder(String result) {
        System.out.println(result);
    }

}
