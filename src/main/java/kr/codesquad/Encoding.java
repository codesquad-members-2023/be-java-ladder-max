package kr.codesquad;

public class Encoding {
    public String encodeLadder(String[][] ladders) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ladders.length; i++) {
            for (int j = 0; j < ladders[i].length; j++) {
                sb.append(ladders[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
