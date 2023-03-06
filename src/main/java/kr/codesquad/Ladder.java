package kr.codesquad;

public class Ladder {

    private int height;
    private char[][] line;

    public void createLine(int num, int height) {
        this.height = height;
        line = new char[num-1][height];

        for(int i=0; i<line.length; i++){
            for(int j=0; j<height; j++){
                line[i][j] = getRandomLine();
            }
        }
    }

    public char getRandomLine() {
        int random = (int)(Math.random()*2);
        if(random == 1) {
            return '-';
        }
        return ' ';
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<height; i++){
            sb.append("|");
            for(int j=0; j<line.length; j++){
                sb.append(line[j][i]);
                sb.append("|");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
