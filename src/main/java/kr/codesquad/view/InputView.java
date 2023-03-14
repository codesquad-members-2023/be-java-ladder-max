package kr.codesquad.view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    // LADDER_HEIGHT_NULL_CODE 를 상수로 지정하여 만약 NULL_CODE 와 다르고, 형식에 맞는 수일 경우에 isFlag 가 true 값을 받아 반복문이 깨지고 사다리 높이 반환
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

    // 플레이어 입력이 형식에 맞을 경우 isFlag가 true 값을 받아 반복문이 깨지고 플레이어 정보가 담긴 List<String> 반환
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
