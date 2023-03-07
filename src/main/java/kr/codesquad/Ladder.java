package kr.codesquad;

import java.util.Random;

public class Ladder {
    private static final String LINE = "-";
    private static final String EMPTY = " ";
    private static final String BAR = "|";

    private final int person;
    private final int maximumHeight;
    private final Random randomCreateLine;

    public Ladder(int person, int maximumHeight) {
        this.person = person;
        this.maximumHeight = maximumHeight;
        this.randomCreateLine = new Random();
    }

    public String[][] generate() {
        int height = maximumHeight;
        int width = calcLadderWidth();
        String[][] board = new String[height][width];
        initLadderBar(board);
        initLadderLine(board);
        return board;
    }

    private int calcLadderWidth(){
        return person * 2 - 1;
    }

    private void initLadderBar(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = isBarPosition(j) ? BAR : EMPTY;
            }
        }
    }

    private boolean isBarPosition(int n){
        return n % 2 == 0;
    }

    private void initLadderLine(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = isLinePosition(j) && isLineNeeded()  ? LINE : board[i][j];
            }
        }
    }

    private boolean isLinePosition(int n){
        return n % 2 == 1;
    }

    private boolean isLineNeeded(){
        return randomCreateLine.nextBoolean();
    }
}
