package kr.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static final String ASKING_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String ASKING_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. 각 이름은 최대 5글자까지 입니다. (이름은 쉼표(,)로 구분하세요)";
    public static final String ERROR_MASSAGE_PLAYER_NAME = "정해진 형식에 맞지 않습니다. 다시 입력해주세요";
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    BufferedReader br;

    public InputView(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getLadderHeight() throws IOException{
        System.out.println(ASKING_LADDER_HEIGHT);
        return Integer.parseInt(br.readLine());
    }

    public String[] getPlayer() throws IOException {
        System.out.println(ASKING_PLAYER_NAMES);
        return inspectPlayers(br.readLine().split(","));
    }

    private String[] inspectPlayers(String[] players) throws IOException {
        while (!correctLength(players))  {// 각 이름이 1~5 글자 사이가 아니면
            printErrorMessage(); // 에러 메세지 출력
            players = br.readLine().split(","); // 다시 받기
        }
        return players;
    }
    
    private boolean correctLength(String[] players){
        int errors = 0; // 이름이 1~5글자 사이에 있지 않으면 count
        for (String playerName : players) {
            errors += errorCount(playerName);
        }
        if (errors == 0) {
            return true;
        }
//    Arrays.stream(peopleNameArray).filter(e -> e.length() > 0 && e.length() <= 5).toArray(); // stream 사용 또 실패!!
    private boolean checkArrayLengthCorrect(String[] peopleNameArray){
        int correctLength = peopleNameArray.length; // 입력 이름 배열
        int countLength = 0; // 각 이름이 1~5글자 사이에 있는지 확인
        for (String peopleName : peopleNameArray) {
            countLength += isInNumber(peopleName);
        }
        if (correctLength != countLength) {
            return false;
        }
        return true;
    }

    private int errorCount(String playerName){
        if (playerName.length() >= MIN_NAME_LENGTH && playerName.length() <= MAX_NAME_LENGTH){
            return 0;
        }
        return 1;
    }
    private void printErrorMessage(){
        System.out.println(ERROR_MASSAGE_PLAYER_NAME);
        System.out.println(ASKING_PLAYER_NAMES);
    }

}
