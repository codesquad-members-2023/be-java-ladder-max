package kr.ladder.domain;

import kr.ladder.view.InputView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class InputValidation {
    public static final String ERROR_MASSAGE_PLAYER_NAME = "정해진 형식에 맞지 않습니다. 다시 입력해주세요";
    public static final String ERROR_MESSAGE_LADDER_HEIGHT = "다시 입력해주세요. 최소 사다리 높이는 1입니다.";
    public static final String ERROR_MESSAGE_LADDER_TYPE = "정수를 입력해 주세요.";
    public static final String ERROR_MASSAGE_PRIZES_NUMBER = "경품을 다시 입력해주세요. 인원 수와 같은 수가 들어와야 합니다.";
    private static final String ERROR_MASSAGE_NO_PLAYER_NAME = "해당 참가자가 없습니다.";
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final InputView inputView;
    public InputValidation(){
        this.inputView = new InputView();
    }

//
    /* 사람 이름 검사()
    while 정상적인 사람 이름이 아니라면
        1. 1~5 글자 사이가 아닌 경우 ✅
        2. null이 들어온 경우
            - 각 이름중에 null이 있는 경우
        3. 쉼표로 끝난 경우
        4. 영어, 한글이 아닌 문자가 들어온 경우
        5. 같은 이름을 가진 플레이어가 있을 경우
       -> player 입력을 다시 받는다
    // 🤔InputView에서 요청해서 다시 받는게 맞나??
    return 위에서 검증을 마친(정상적인) 플레이어 이름 배열
     */
    public String[] inspectPlayers() throws IOException {
        return inspectPlayersNameLength(inputView.getPlayer());
    }

    private String[] inspectPlayersNameLength(String[] players) throws IOException {
        while (!correctLength(players))  {// 각 이름이 1~5 글자 사이가 아니면
            System.out.println(ERROR_MASSAGE_PLAYER_NAME);
            players = inputView.getPlayer();
        }
        return players;
    }

    private boolean correctLength(String[] words){
        int errors = 0; // 이름이 1~5글자 사이에 있지 않으면 count
        for (String word : words) {
            errors += countOverScopeName(word);
        }
        return (errors == 0);
    }

    private int countOverScopeName(String word){
        if (word.length() >= MIN_NAME_LENGTH && word.length() <= MAX_NAME_LENGTH){
            return 0;
        }
        return 1;
    }

    /* 사다리 높이 검사()
     while 정상적인 사다리 높이가 아니라면
         1. 사다리 높이가 0 이하 ✅
         2. int가 아닌 경우 ✅
        -> 입력을 다시 받는다
     return 정상적인 사다리 높이
     */
    public int inspectLadderHeight() throws IOException {
        String ladderHeight = inputView.getLadderHeight();
        while (!isInteger(ladderHeight) || !isAvailableHeight(Integer.parseInt(ladderHeight))) {
            ladderHeight = inputView.getLadderHeight();
        }
        return Integer.parseInt(ladderHeight);
    }

    private boolean isAvailableHeight(int ladderHeight){
        if (ladderHeight < 1) {
            System.out.println(ERROR_MESSAGE_LADDER_HEIGHT);
            return false;
        }
        return true;
    }

    private boolean isInteger(String ladderHeight) {
        try {
            Integer.parseInt(ladderHeight);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE_LADDER_TYPE);
            return false;
        }
    }

    /*
    상품 목록 검사
    while 정상적인 경품 목록이 아니라면
        1. 1~5 글자 사이가 아닌 경우 ✅(사람 이름 검사 로직 재사용)
        2. 플레이어 숫자와 동일한 갯수가 아닐 경우
        -> 경품 입력을 다시 받는다.
    return 정상적인 경품 목록
     */

    public String[] inspectPrizes(int playersNumber) throws IOException {
        String[] prizes = inputView.getPrizes();
        while (!correctPrizeLength(prizes) || !sameNumberAsPlayers(prizes.length, playersNumber)) {
            prizes = inputView.getPrizes();
        }
        return prizes;
    }

    private boolean correctPrizeLength(String[] prizes) throws IOException {
        if (!correctLength(prizes))  {// 각 이름이 1~5 글자 사이가 아니면
            System.out.println(ERROR_MASSAGE_PLAYER_NAME);
            return false;
        }
        return true;
    }

    private boolean sameNumberAsPlayers(int prizesNumber, int playersNumber){
        if (prizesNumber != playersNumber) {
            System.out.println(ERROR_MASSAGE_PRIZES_NUMBER);
            return false;
        }
        return true;
    }

    /*
    결과를 보고 싶은 사람 검사
        players에 있는 사람만 입력받을 수 있도록 한다.
     */
    public String inspectCommand(String[] players) throws IOException {
        String command = inputView.getCommand();

        if (command.equals("all") || command.equals("춘식이")) { // 모두 출력하거나 실행 종료하는 로직은 다른 클래스에 위임한다.
            return command;
        }
        Optional<String> matchedPlayer = Arrays.stream(players).filter(p -> p.equals(command)).findFirst();
        while (matchedPlayer.isEmpty()){
            System.out.println(ERROR_MASSAGE_NO_PLAYER_NAME);
            String newCommand = inputView.getCommand();
            matchedPlayer = Arrays.stream(players).filter(p -> p.equals(newCommand)).findFirst();
        }
        return command;
    }
}
