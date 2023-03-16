package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
// 멤버 변수로 ArrayList 만들기
    // 한줄씩 사다리 만들어내기
    private List<String> ladder;
    private int countOfPerson;
    public LadderLine (int countOfPerson,RandomGenerator generator) {
        this.countOfPerson = countOfPerson;
        this.ladder = generator.remakeLadder(countOfPerson);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  |");
        for (int i = 0; i < ladder.size(); i++) {
            sb.append(ladder.get(i))
                    .append("|");
        }
        return sb.toString();
    }
}
