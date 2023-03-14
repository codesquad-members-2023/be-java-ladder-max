package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputPlayerListManager {

    private final Scanner scanner;

    static final String GET_PLAYER_LIST_MESSAGE = "플레이어들의 이름을 입력해주세요 ex) a,b,c";

    static final int MINIMUM_PLAYER = 2;
    static final int MAXIMUM_PLAYER_NAME_LENGTH = 5;

    public List<String> playerList;


    public InputPlayerListManager(Scanner scanner){
        this.scanner = scanner;
    }

    // 콘솔로 String 을 입력 받고 , 를 기준으로 split 해준 배열을 List<String> 으로 반환
    public List<String> inputPlayerList(){
        playerList = stringToList(getStringInput());
        return playerList;
    }

    public List<String> stringToList(String inputPlayerString){
        return Arrays.asList(inputPlayerString.split(","));
    }

    // 최소 2인 이상의 플레이어 인지, 정해진 형식의 플레이어 이름인지 검사하고 이상 없을 경우 true 를 리턴
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
        return playerName.length() <= MAXIMUM_PLAYER_NAME_LENGTH && isValid;
    }

    public String getStringInput(){
        return scanner.nextLine();
    }
}
