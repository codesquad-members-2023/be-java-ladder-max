package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
// 멤버 변수로 ArrayList 만들기
    // 한줄씩 사다리 만들어내기
    List<String> ladder;
    int countOfPerson;
    public LadderLine (int countOfPerson) {
        this.countOfPerson = countOfPerson;
        this.ladder = remakeLadder();
    }
    public List<String> remakeLadder() {
        List<String> ladder = new ArrayList<>();
        for (int i = 0; i < countOfPerson- 1; i++) {
            ladder.add(randomLadder(i, ladder));
        }
        return ladder;
    }
    private String randomLadder(int index, List<String> ladder) {
        String[] indexRandom = {"     ", "-----"};
        Random random = new Random();
        if (index == 0) {
            return indexRandom[random.nextInt(2)];
        }
        if (ladder.get(index-1).equals("     ")) {
            return indexRandom[random.nextInt(2)];
        }
        return "     ";
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
