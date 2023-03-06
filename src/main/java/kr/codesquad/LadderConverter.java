package kr.codesquad;

public class LadderConverter {

    private final String[][] board;

    public LadderConverter(String[][] board) {
        this.board = board;
    }

    public String convertToString() {
        StringBuilder result = new StringBuilder();
        for (String[] row : board) {
            result.append(String.join("", row)).append("\n");
        }
        return result.toString();
    }
}
