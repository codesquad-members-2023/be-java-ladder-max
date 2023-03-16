package kr.codesquad.domain;

import java.util.*;

public class Players {
    private List<String> players;
    private HashMap<String,String> result;
    private List<String> resultList;
    public Players(List<String> playersList,String resultList, int[] result){
        this.players = playersList;
        this.resultList = Arrays.asList(resultList.split(","));
        this.result = new HashMap<>();
        trim(players);
        trim(this.resultList);
        sortResult(result);
    }

    public String getNames(){
        StringBuilder sb = new StringBuilder();
        for (String name : players){
            sb.append(String.format("%-6s ", name)); // 각 이름당 주어진 자리는 6자리
        }
        return sb.toString();
    }
    public String getResultList(){ // 결과를 사다리 간격에 맞게 반환
        StringBuilder sb = new StringBuilder();
        for (String s : resultList){
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
        for (Map.Entry<String,String> entry : result.entrySet()){
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
    private String getOneResult(String id){
        String value = result.get(id);
        return id +" : "+value;
    }
    private void sortResult(int[] tmp){
        for (int i=0;i<tmp.length;i+=2){
            String key = players.get(i/2);
            String value = resultList.get(tmp[i]);
            this.result.put(key,value);
        }
    }
    private void trim(List<String> list){
        for(int i=0; i<list.size(); i++){
            list.set(i, list.get(i).trim());
        }
    }
}
