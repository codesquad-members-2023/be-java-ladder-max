import java.util.Random;
import java.util.ArrayList;

public class Ladder {
    private int width;
    private int height;
    private String[][] ladderBoard;
    private List<String> names;
    public void init() {
        width = inputer.getManNum();
        height = inputer.getLadderNum();
        makeLadder();
    }
//    private int manNum = manNumFake * (manNumFake - 1);
    private void makeNames() {
        String[] str = inputer.getNames().split(",");
        names = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            names.add(str[i]);
        }
    }

    private void makeLadder() {
        makeNames();
        ladderBoard = new String[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            functionForMakeLadder1(i);
            functionForMakeLadder2(i);
        }
    }
    private void smallIfSentence1InFunctionForMakeLadder2(int j) {
        if (j % 2 == 0 && random.nextboolean == true))) {
            ladderBoard[i][j] = " ";
        }
    }
    private void ifSentenceInFunctionForMakeLadder2(int j) {
        if (j % 2 == 0 && random.nextboolean == false))) {
                ladderBoard[i][j] = "-";
            }
    }
    private void functionForMakeLadder2(int i) {
        for (int j = 0; j < width; j++) {
            ifSentence1InFunctionForMakeLadder2(j);
            ifSentence2InFunctionForMakeLadder2(j);
        }
    }
    private void ifSentenceInFunctionForMakeLadder1(int j) {
        if (j % 2 == 1) {
            ladderBoard[i][j] = "|";
        }
    }
    private void functionForMakeLadder1(int i) {
        for (int j = 0; j < width; j++) {
            ifSentenceInFunctionForMakeLadder1(int j)
        }
    }
    public void printResult() {
        for (int i = 0; i < height; i++) {
            System.out.println(ladderBoard[i])
        }
    }
//    public void makeLadder(int widthButOnlyForTest, int heightButOnlyForTest) {
//        String[][] ladderBoard = new String[heightButOnlyForTest][widthButOnlyForTest];
//        Random random = new Random();
//
//        for (int i = 0; i < heightButOnlyForTest; i++) {
//            for (int j = 0; j < width; j++) {
//                if (j % 2 == 1) {
//                    ladderBoard[i][j] = "|";
//                }
//            }
//            for (int j = 0; j < widthButOnlyForTest; j++) {
//                if (j % 2 == 0) {
//                    if (rd.nextboolean == true)){
//                        ladderBoard[i][j] = " ";
//                    }
//                    if (rd.nextboolean == false)){
//                        ladderBoard[i][j] = "-";
//                    }
//                }
//            }
//        }
//    }
}
