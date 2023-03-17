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
            ladderBoard.get(ladderFloorNum).add("|"); //makeFirstStick
            makeRemainParts(ladderFloorNum);
        }
        printer.printResult(ladderBoard, namesList);
    }

    private void makeRemainParts(int ladderFloorNum) {
        makeFirstBridge(ladderFloorNum);
        for (int ladderFloorIndex = 1; ladderFloorIndex < namesList.size()-1; ladderFloorIndex++) {
            makeBridgeNotSecond(ladderFloorIndex, ladderFloorNum);
        }
    }

    private void makeFirstBridge(int ladderFloorNum) {
        boolean bool = random.nextBoolean();
        if (bool == true) {
            ladderBoard.get(ladderFloorNum).add("-----|");
        }
        if (bool == false) {
            ladderBoard.get(ladderFloorNum).add("     |");
        }
    }

    private void makeBridgeNotSecond(int ladderFloorIndex, int ladderFloorsNum) {
        boolean bool = random.nextBoolean();
        if (ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("-----|")) {
            ladderBoard.get(ladderFloorsNum).add("     |");
        }
        if (bool == true && ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("     |")) {
            ladderBoard.get(ladderFloorsNum).add("-----|");
        }
        if (bool == false && ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("     |")) {
            ladderBoard.get(ladderFloorsNum).add("     |");
        }
    }
}


