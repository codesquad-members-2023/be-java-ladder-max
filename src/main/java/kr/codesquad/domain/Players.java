package kr.codesquad.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Players {
    private List<String> players;
    private HashMap<String,String> playerResult;
    private List<String> result;
    public Players(List<String> playersList,String result, String ladder){
        this.players = playersList;
        this.result = Arrays.asList(result.split(","));
        trim(players);
        trim(this.result);
        getResult(ladder);
    }
    private void getResult(String ladder){
        for (int i=0;i< players.size();i++){
            String result = getOneResult(ladder,i);
            playerResult.put(players.get(i),result);
        }
    }
    private String getOneResult(String ladder, int idx){
        String[] lines = ladder.split("\n"); // 사다리 한 줄이 요소 하나

        for (String row : lines) {
            String[] point = row.trim().split("\\|"); // 사다리를 "|"를 기준으로 나눔
            if (checkLeft(point,idx)){
                idx--;
                continue;
            }
            if (checkRight(point,idx)){
                idx++;
            }
        }
        return result.get(idx);
    }
    private boolean checkLeft(String[] point,int idx){ // 사다리 왼쪽에 줄이 있는지 검사
        if (idx==0) {return false;}
        if ("-----".equals(point[idx-1])){
            return true;
        }
        return false;
    }
    private boolean checkRight(String[] point, int idx){ // 사다리 오른쪽에 줄이 있는지 검사
        if (idx==players.size()-1) {return false;}
        if ("-----".equals(point[idx])){
            return true;
        }
        return false;
    }
    private void trim(List<String> list){
        for(int i=0; i<list.size(); i++){
            list.set(i, list.get(i).trim());
        }
    }
}
