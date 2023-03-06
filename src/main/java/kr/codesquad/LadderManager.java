package kr.codesquad;

import java.util.Random;

public interface LadderManager {
    void printLadder();

    void printLadderRows();

    void chooseLetter(int i);


    void appendVerticalBar(int i);

    void appendRandomLadderRows(int i);

    void chooseRandomLetter();

    void appendMinusSign();

    void appendBlank();
}
