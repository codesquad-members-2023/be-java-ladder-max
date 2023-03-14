package kr.ladder.view;

import java.util.List;

public class OutputView {
    private static final int DEFAULT_WIDTH = 6;
    StringBuilder sb;

    public OutputView(){
         sb = new StringBuilder();
    }

    public void printPlayersAndLadder(String[] players, String ladder){
        printPlayersName(players);
        printLadder(ladder);
    }

    public void printPlayersName(String[] players){
        for (String player : players) {
            sb.append(player);
            insertBlank(player);
        }
        sb.append("\n");

        System.out.println(sb);
        sb.setLength(0); // stringBuilder 초기화 (리셋)
    }

    public void insertBlank(String player){
        for (int i = 0; i < DEFAULT_WIDTH - player.length(); i++) {
            sb.append(" ");
        }
    }

    public void printLadder(String ladder){
        sb.append(ladder);

        System.out.println(sb);
        sb.setLength(0); // stringBuilder 초기화 (리셋)
    }
}
