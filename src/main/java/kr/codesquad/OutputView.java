package kr.codesquad;

public class OutputView {
    private static final String PLAYERS_PROMPT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_HEIGHT_PROMPT = "최대 사다리 높이는 몇 개인가요?";

    public void printPlayersPrompt() {
        System.out.println(PLAYERS_PROMPT);
    }

    public void printMaxHeightPrompt() {
        System.out.println(MAX_HEIGHT_PROMPT);
    }

    public void printLadder(String[][] ladder) {
        drawLadderDiagram(ladder);
    }

    private void drawLadderDiagram(String[][] ladder) {
        for (int i = 0; i < ladder.length * ladder[0].length; i++) {
            int row = i / ladder[0].length;
            int column = i % ladder[0].length;
            System.out.print(ladder[row][column]);
            printLineBreak(ladder, column);
        }
    }

    private void printLineBreak(String[][] ladder, int column) {
        if (column == ladder[0].length - 1) {
            System.out.println();
        }
    }
}