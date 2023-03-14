package kr.codesquad.view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int getLadderHeight() {
        boolean isFlag = false;
        InputLadderHeightManager ladderHeightManager = new InputLadderHeightManager(scanner);
        int ladderHeight = InputLadderHeightManager.LADDER_HEIGHT_NULL_CODE;
        while (!isFlag) {
            System.out.println(InputLadderHeightManager.GET_LADDER_HEIGHT_MESSAGE);
            ladderHeight = ladderHeightManager.inputLadderHeight();
            isFlag = ladderHeightManager.checkNullLadderHeight(ladderHeight);
        }
        return ladderHeight;
    }

    public List<String> getPlayerList() {
        InputPlayerListManager inputPlayerListManager = new InputPlayerListManager(scanner);
        boolean isFlag = false;
        List<String> playerList = new ArrayList<>();
        while (!isFlag) {
            System.out.println(InputPlayerListManager.GET_PLAYER_LIST_MESSAGE);
            playerList = inputPlayerListManager.inputPlayerList();
            isFlag = inputPlayerListManager.isValidPlayerInput();
        }
        return playerList;
    }
}
