package ladder.view;

import ladder.domain.Ladder;

public class OutputView {
    public void inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void inputLadder() {
        System.out.println("최대 사다리 높이는 몇개 인가요 ? ");
    }

    public void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public void printNames(String names) {
        System.out.println(names);
    }
}
