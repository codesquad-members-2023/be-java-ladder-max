package Ladder;

public class Output {
    public Output(String[][] ladder) {
        printLadder(ladder);
    }

    private void printLadder(String[][] ladder) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < ladder.length; i++){
            result.append(appendRow(i,ladder));
        }
        System.out.println(result);
    }

    private String appendRow(int i, String[][] ladder) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < ladder[0].length; j++){
            sb.append(ladder[i][j]);
        }
        sb.append("\n");
        return sb.toString();
    }


}
