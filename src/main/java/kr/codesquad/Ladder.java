package kr.codesquad;

import kr.codesquad.view.InputView;

import java.util.Random;

public class Ladder {
    private String[][] laddder;

    private final InputView inputView = new InputView();

    Ladder(int peoleNumber, int ladderHeight) {
        inputView.inputPeopleName();
        this.laddder = new String[ladderHeight][2 * peoleNumber - 1];
    }

    public String[][] makeLadder() {
        makeLadderRow();
        return this.laddder;
    }

    private void makeLadderRow() {
        for (int row = 0; row < laddder.length; row++) {
            makeLadderColumn(row);
        }
    }

    private void makeLadderColumn(int row) {
        for (int column = 0; column < laddder[row].length; column++) {
            makeBasicPeopleLine(row, column);
            makeRandomLadderLine(row, column);
        }
    }


    private void makeBasicPeopleLine(int row, int column) {
        if (column % 2 == 0) {
            this.laddder[row][column] = "|";
            return;
        }
        this.laddder[row][column] = " ";
    }


    private void makeRandomLadderLine(int row, int column) {
        Random random = new Random();
        if (random.nextBoolean() && column % 2 == 1) {
            laddder[row][column] = "-";
        }
    }


}
