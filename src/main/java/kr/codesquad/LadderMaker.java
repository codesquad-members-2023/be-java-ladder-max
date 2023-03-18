
package kr.codesquad;


import kr.codesquad.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    private Random random = new Random();
    private List<List<String>> ladderBoard;
    private List<String> namesList;
    private OutputView printer = new OutputView();

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
        for (int ladderFloorIndex = 1; ladderFloorIndex < namesList.size() - 1; ladderFloorIndex++) {
            makeBridgeNotContinuous(ladderFloorIndex, ladderFloorNum);
        }
    }
    private void makeFirstBridge(int ladderFloorNum) {
        boolean trueOrFalse = random.nextBoolean();
        if (trueOrFalse){
            ladderBoard.get(ladderFloorNum).add("-----|");
            return;
        }
            ladderBoard.get(ladderFloorNum).add("     |");
    }
    private void makeBridgeNotContinuous(int ladderFloorIndex, int ladderFloorsNum) {
        boolean ifDashBridgeBefore = random.nextBoolean();
        if (ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("-----|")) {
            ladderBoard.get(ladderFloorsNum).add("     |");
        }
        if (ifDashBridgeBefore && ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("     |")) {
            ladderBoard.get(ladderFloorsNum).add("-----|");
        }
        if (!ifDashBridgeBefore && ladderBoard.get(ladderFloorsNum).get(ladderFloorIndex - 1).equals("     |")) {
            ladderBoard.get(ladderFloorsNum).add("     |");
        }
    }
}


