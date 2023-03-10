package kr.codesquad;

import java.util.Random;

public class Ladder {
    String[][] ladder;

    Ladder(int people, int height) {
        this.ladder = new String[height][];
        for (int i = 0; i < height; i++) {
            this.ladder[i] = makeLayer(people);
        }
    }


    String[] makeLayer(int people) {
        String[] Layer = new String[(people*2) - 1];
        for (int i = 0; i < (people*2) - 1; i++) {
            Layer[i] = getLayer(i);
        }
        return Layer;
    }


    String getLayer(int i) {
        if (i % 2 == 0) {
            return "|";
        }
        return getLadder();
    }


    String getLadder() {
        if (randomBoolean()) {
            return "-";
        }
        return " ";
    }


    void printLadder() {
        for (String[] strings : ladder) {
            printLayer(strings);
            System.out.println();
        }
    }

    private void printLayer(String[] strings) {
        for (String string : strings) {
            System.out.print(string);
        }
    }


//    void printVerticalLine(int people, int Ladder) {
//        for (int i = 0; i < Ladder; i++) {
//            System.out.print("|");
//            printHorizontalLine(people);
//            System.out.println();
//        }
//    }
//
//
//    private void printHorizontalLine(int people) {
//        for (int i = 0; i < people; i++) {
//            if (randomBoolean()) {
//                System.out.print("-");
//            } else {
//                System.out.print(" ");
//            }
//            System.out.print("|");
//        }
//    }


    private boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
