package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputPlayerListManager {

    private final Scanner scanner;

    static final String GET_PLAYER_LIST_MESSAGE = "플레이어들의 이름을 입력해주세요 ex) a,b,c";

    static final int MINIMUM_PLAYER = 2;
    public List<String> playerList;



    public InputPlayerListManager(Scanner scanner){
        this.scanner = scanner;
    }
    public List<String> inputPlayerList(){
        playerList = stringToList(getStringInput());
        return playerList;
    }

    public List<String> stringToList(String inputPlayerString){
        return Arrays.asList(inputPlayerString.split(","));
    }

    public boolean isValidPlayerInput(){
        if(!checkMinimumPlayerNumber()){
            return false;
        }
        boolean isValid = true;
        for (String player : playerList) {
            isValid = isCorrectNameLength(player, isValid);
        }
        return isValid;
    }

    public boolean checkMinimumPlayerNumber(){
        return playerList.size() >= MINIMUM_PLAYER;
    }

    public boolean isCorrectNameLength(String playerName, boolean isValid) {
        return playerName.length() <= 5 && isValid;
    }

    public String getStringInput(){
        return scanner.nextLine();
    }
}
