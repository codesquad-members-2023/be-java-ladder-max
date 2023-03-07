package kr.codesquad;

public class Output {
    public void printNumberOfPeople () {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public void printHeightOfLadder () {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }


    public void printLadder(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            printLadderLine(ladder[i]);
        }
    }

    private void printLadderLine(String[] ladder) {
        StringBuilder sb = new StringBuilder();
        for (String str : ladder) {
            sb.append(str);
        }

        System.out.println(sb);
    }
}
