package mission.view;

import mission.model.Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String ASKING_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String ASKING_PEOPLE_NAME = "참여할 사람 이름을 입력하세요. 각 이름은 최대 5글자까지 입니다. (이름은 쉼표(,)로 구분하세요)";
    public static final String ERROR_MASSAGE_ABOUT_PEOPLE_NAME = "정해진 형식에 맞지 않습니다. 다시 입력해주세요";
    BufferedReader br;

    public InputView(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getLadderHeight() throws IOException{
        System.out.println(ASKING_LADDER_HEIGHT);
        return Integer.parseInt(br.readLine());
    }

    public String[] getPeopleName() throws IOException {
        System.out.println(ASKING_PEOPLE_NAME);
        return makeArrayFromString(br.readLine());
    }

    private String[] makeArrayFromString(String string) throws IOException {
        return checkCorrectPeopleName(string.split(","));
    }

    private String[] checkCorrectPeopleName(String[] peopleNameArray) throws IOException {
        while ((peopleNameArray.length == 0) // 1️⃣ array.lenth()가 0이거나
            || !checkArrayLengthCorrect(peopleNameArray))  {// 2️⃣ 각 이름이 1~5 글자 사이가 아니면
            printErrorMessageAboutPeopleName(); // 에러 메세지 출력
            peopleNameArray = br.readLine().split(","); // 다시 받기
        }
        return peopleNameArray;
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

    private int isInNumber(String peopleName){
        if (peopleName.length() > 0 && peopleName.length() <= 5){
            return 1;
        }
        return 0;
    }
    private void printErrorMessageAboutPeopleName(){
        System.out.println(ERROR_MASSAGE_ABOUT_PEOPLE_NAME);
        System.out.println(ASKING_PEOPLE_NAME);
    }

}
