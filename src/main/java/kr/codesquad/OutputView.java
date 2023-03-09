package kr.codesquad;

public class OutputView {
    private String PARTICIPANTS_PROMPT = "참여할 사람은 몇 명인가요?";
    private String MAX_HEIGHT_PROMPT = "최대 사다리 높이는 몇 개인가요?";

    public void printParticipantsPrompt() {
        System.out.println(PARTICIPANTS_PROMPT);
    }

    public void printMaxHeightPrompt() {
        System.out.println(MAX_HEIGHT_PROMPT);
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