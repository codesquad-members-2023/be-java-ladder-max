package kr.codesquad;

public class Output {
    void printInputNumberOfPlayerQuestion(){
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    void printInputLadderHeightQuestion(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    //TODO: Ladder.print()를 여기로 옮기기 로직 없이 출력만 하도록(String을 받는 것으로)
    //질문 : ladder를 String으로 받으면 printLadder 매개변수로 String 타입이면 다 들어갈 수 있게 돼서 안되지 않나요?
    void printLadder(Ladder ladder){
        System.out.println(ladder.toString());
    }


}
