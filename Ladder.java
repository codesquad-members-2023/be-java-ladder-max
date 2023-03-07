import java.util.Random;

public class Ladder{
    public void gameInit() {
    System.out.println("몇 인용인가요?")
    System.out.println("몇 단계로 할까요?")
    System.out.println(System.lineSeparator());
}
    private int width;
    private int height;

    public void init(){
        width = inputer.getManNum();
        height = inputer.getLadderNum();
        makeLadder();
    }
    public void makeLadder(){
        String[][] ladderBoard = new String[height][width];
        Random rd = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 1) {
                    ladderBoard[i][j] = "|";
                }
            }
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0) {
                    if (rd.nextboolean == true)){
                        ladderBoard[i][j] = " ";
                    }else{
                        ladderBoard[i][j] = "-";
                    }
                }
            }
        }
    }
    public void makeLadder(int widthButOnlyForTest, int heightButOnlyForTest){
        String[][] ladderBoard = new String[heightButOnlyForTest][widthButOnlyForTest];
        Random rd = new Random();

        for (int i = 0; i < heightButOnlyForTest; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 1) {
                    ladderBoard[i][j] = "|";
                }
            }
            for (int j = 0; j < widthButOnlyForTest; j++) {
                if (j % 2 == 0) {
                    if (rd.nextboolean == true)){
                        ladderBoard[i][j] = " ";
                    }else{
                        ladderBoard[i][j] = "-";
                    }
                }
            }
        }
    }
    public void printResult(){
        for(int i = 0; i < height; i++){
         System.out.println(ladderBoard[i])
        }
    }
}
