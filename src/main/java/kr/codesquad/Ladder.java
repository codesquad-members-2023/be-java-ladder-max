package kr.codesquad;

public class Ladder {
    int countOfPerson;
    int height;
    // n과 m 받아서 for문 만들기
    // n은 참여할 사람 , m은 사다리의 높이
    public Ladder(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = height;
//        this.ladderFeature(); // 메서드도 넣어도된다 !! -> 생성자에 메서드를 넣으면 주소값이 전달된다. -> toString 으로 오버라이드
    }
    @Override
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sbr.append(new LadderLine(countOfPerson));
            sbr.append("\n");
        }
        return sbr.toString();
    }
}

