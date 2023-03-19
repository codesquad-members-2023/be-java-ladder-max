package kr.codesquad;

import kr.codesquad.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    static final int secondBridgeIndex = 2;
    private List<List<String>> ladderBoard;
    private List<String> namesList;
    private final Random random = new Random();
    private final OutputView printer = new OutputView();

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
        for (int ladderFloorIndex = secondBridgeIndex; ladderFloorIndex < namesList.size(); ladderFloorIndex++) {
            makeBridgeNotContinuous(ladderFloorIndex, ladderFloorNum);
        }
    }
    private void makeFirstBridge(int ladderFloorNum) {
        boolean trueOrFalse = random.nextBoolean();
        if (trueOrFalse) {
            ladderBoard.get(ladderFloorNum).add("-----|");
            return;
        }
            ladderBoard.get(ladderFloorNum).add("     |");
    }
    private void makeBridgeNotContinuous(int ladderFloorIndex, int ladderFloorNum) {
        int beforeIndex = ladderFloorIndex - 1;
        if (ladderBoard.get(ladderFloorNum).get(beforeIndex).equals("-----|")) {
            ladderBoard.get(ladderFloorNum).add("     |");
            return;
        }
        if (random.nextBoolean() && ladderBoard.get(ladderFloorNum).get(beforeIndex).equals("     |")) {
            ladderBoard.get(ladderFloorNum).add("-----|");
            return;
        }
            ladderBoard.get(ladderFloorNum).add("     |");
    }
}


