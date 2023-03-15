package kr.codesquad;

public class Output {
    public void printNumberOfPeople () {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public void printHeightOfLadder () {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printNameOfPeople () { System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"); }


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
