package kr.codesquad.domain;

import java.util.*;

public class Players {
    private List<String> players;
    private HashMap<String,String> playerResult;
    private List<String> result;
    public Players(List<String> playersList,String result, String ladder){
        this.players = playersList;
        this.result = Arrays.asList(result.split(","));
        playerResult = new HashMap<>();
        trim(players);
        trim(this.result);
        calculateResult(ladder);
    }
    public String getNames(){
        StringBuilder sb = new StringBuilder();
        for (String name : players){
            sb.append(String.format("%-6s ", name)); // 각 이름당 주어진 자리는 6자리
        }
        return sb.toString();
    }
    public String getResult(){ // 결과를 사다리 간격에 맞게 반환
        StringBuilder sb = new StringBuilder();
        for (String s : result){
            sb.append(String.format("%-6s ",s));
        }
        return sb.toString();
    }
    public String searchResult(String id) {
        if ("all".equals(id)){
            return getAllResult();
        }
        return getOneResult(id);
    }
    private String getAllResult(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> entry : playerResult.entrySet()){
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
    private String getOneResult(String id){
        String value = playerResult.get(id);
        return id +" : "+value;
    }
    private void calculateResult(String ladder){
        for (int i=0;i< players.size();i++){
            String result = calculateOneResult(ladder,i);
            playerResult.put(players.get(i),result);
        }
    }
    private String calculateOneResult(String ladder, int idx){
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
