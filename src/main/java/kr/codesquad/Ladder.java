package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int width;
    private int height;
    private List<List<String>> radder = new ArrayList<>();

    private Names names;

    public Ladder(String nameData, int height){
        String[] nameArr = nameData.split(",");
        this.width = nameArr.length-1;
        this.height = height;
        names = new Names(nameArr);
    }

    public void createRadder() {
        for(int i=0; i<height; i++){
            radder.add(createRow());
        }
    }

    public List<String> createRow() {
        List<String> row = new ArrayList<>();
        String prevLine = "";
        for(int i=0; i<width; i++){
            String line = getRandomLine(prevLine);
            row.add(line);
            prevLine = line;
        }
        return row;
    }

    public String getRandomLine(String prevLine) {
        if(prevLine.equals("-----")){
            return "     ";
        }
        int random = (int)(Math.random()*2);
        if(random == 1) {
            return "-----";
        }
        return "     ";
    }

    public void printRadder() {
        StringBuilder sb = new StringBuilder();
        // 이름 row 생성
        sb.append(names.makeNameRow() + "\n");
        // 사다리 row 생성
        for(int i=0; i<height; i++){
            sb.append(makeRowString(radder.get(i)));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public String makeRowString(List<String> row) {
        String oneRow = "  |";
        for(int i=0; i<row.size(); i++){
            oneRow += row.get(i) + "|";
        }
        return oneRow;
    }
}
