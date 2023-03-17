package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeLadder {
    private int userCount;
    private int length;

    private List<Boolean>check = new ArrayList<>(List.of(false));

    public MakeLadder(int length, int userCount) {
        this.length = length;
        this.userCount = userCount;
    }

    public List<String> finalLadder() {
        int checkIndex;
        List<String> finalLadder = new ArrayList<>();
        for (int i= 0 ; i<userCount*length; i++) {
            checkIndex = reset(i);
            finalLadder.add(checkFirst(checkIndex));

        }

        return finalLadder;
    }
    public String checkFirst(int i) {
        if(i%2==0) {
            return stick(true);
        }
        return stick(false);
    }
    public String stick(Boolean check) {
        if(check) {
            return "|";
        }
        return  dashOrBlank();
    }

    public String dashOrBlank() {
        Random random = new Random();
        if(random.nextBoolean()) {
            return checkBar();
        }
        return "     ";
    }

    public int reset(int i){
        if(i>=userCount) {
            return i%userCount;
        }
        return i;
    }
    public String listToString(){
        List<String> list = finalLadder();
        StringBuilder stringBuilder = new StringBuilder();
        int checkIndex;
        for(int i= 0 ; i<list.size(); i++) {
            checkIndex =reset(i);
            checkEnter(checkIndex,stringBuilder);
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }

    public String checkEnter(int checkIndex,StringBuilder stringBuilder) {
        if(checkIndex%userCount == 0) {
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

    String checkBar() {
        if(check.get(check.size()-1)) {
            check.set(check.size()-1,false);
            return "     ";
        }
        check.add(true);
        return "-----";
    }


}
