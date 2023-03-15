package kr.codesquad;

public class Ladder {
    private int countOfPerson;
    private int height;

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

