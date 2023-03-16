package kr.ladder.view;

public class OutputView {
    private static final int DEFAULT_WIDTH = 6;
    StringBuilder sb;

    public OutputView(){
         sb = new StringBuilder();
    }

    public void printPlayersAndLadder(String[] players, String ladder){
        printPlayersName(players);
        printLadder(ladder);

        System.out.println(sb);
        sb.setLength(0); // stringBuilder 초기화 (리셋)
    }

    // 이 부분은 OutputView 의 일이 아니지 않나 고민중...
    private void printPlayersName(String[] players){
        for (String player : players) {
            sb.append(player).append(insertBlank(player.length()));
        }
        sb.append("\n");
    }

    public String insertBlank(int playerNameLength){
        return " ".repeat(DEFAULT_WIDTH - playerNameLength);
    }

    private void printLadder(String ladder){
        sb.append(ladder);
    }
}
