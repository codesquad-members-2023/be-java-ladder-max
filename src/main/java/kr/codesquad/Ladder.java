package kr.codesquad;

public class Ladder {

    private int height;
    private char[][] radder;

    public void createRadder(int num, int height) {
        this.height = height;
        radder = new char[num-1][height];

        for(int i = 0; i< radder.length; i++){
            createOneColumn(i);
        }
    }

    public void createOneColumn(int index){
        for(int i=0; i<height; i++){
            radder[index][i] = getRandomLine();
        }
    }

    public char getRandomLine() {
        int random = (int)(Math.random()*2);
        if(random == 1) {
            return '-';
        }
        return ' ';
    }

    public void printRadder() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<height; i++){
            sb.append(makeOneRow(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public String makeOneRow(int row) {
        String oneRow = "|";
        for(int i=0; i<radder.length; i++){
            oneRow += radder[i][row] + "|";
        }
        return oneRow;
    }
}
