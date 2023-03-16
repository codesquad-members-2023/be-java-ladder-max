package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    private final Random random = new Random();
    private List<List<String>> ladderBoard;
    private List<String> namesList;
    private Printer printer = new Printer();

    public void make(ArrayList<String> namesInput, int ladderHeight) {
        namesList = namesInput;

        ladderBoard = new ArrayList<>();
        for (int ladderFloorNum = 0; ladderFloorNum < ladderHeight; ladderFloorNum++) {
            ladderBoard.add(new ArrayList<>());
            ladderBoard.get(ladderFloorNum).add("|");
            makeRemainParts(ladderFloorNum);
        }
        printer.printResult(ladderBoard, namesList);
    }

    private void makeRemainParts(int ladderFloorNum) {
        makeIndexNumber1(ladderFloorNum);
        for (int ladderFloorIndex = 2; ladderFloorIndex < namesList.size(); ladderFloorIndex++) {
            makeBridgeNotSecond(ladderFloorIndex, ladderFloorNum);
        }
    }

    private void makeIndexNumber1(int ladderFloorsNum) {
        if (random.nextBoolean()) {
            ladderBoard.get(ladderFloorsNum).add("-----");
            ladderBoard.get(ladderFloorsNum).add("|");
        }
        if (!random.nextBoolean()) {
            ladderBoard.get(ladderFloorsNum).add("     ");
            ladderBoard.get(ladderFloorsNum).add("|");
        }
    }

    private void makeBridgeNotSecond(int ladderFloorIndex, int ladderFloorsNum) {
        if (random.nextBoolean() == true && ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("     ")) {
            ladderBoard.get(ladderFloorsNum).add("-----");
            ladderBoard.get(ladderFloorsNum).add("|");
        }
        if (random.nextBoolean() == false && ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("     ")) {
            ladderBoard.get(ladderFloorsNum).add("     ");
            ladderBoard.get(ladderFloorsNum).add("|");
        }
    }
}
