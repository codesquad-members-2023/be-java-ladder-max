package kr.codesquad;

public class OutputView {
    public void printJoinMembers() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public void printMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadderState(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }


}
