import java.util.Random;

public class ladderController {

    private String[][] ladder;
    private int ladderX;
    private int ladderY;

    public void getInput(){
        UserInput userInput = new UserInput();
        System.out.println("플레이어");
        ladderX = userInput.integerInput();
        System.out.println("줄 높이");
        ladderY = userInput.integerInput();
    }

    public void createLadder() {
        ladder = new String[ladderY][ladderX * 2 - 1];
        drawLadder();
    }
    public void drawLadder(){
        for(int i = 0; i < ladder.length; i++){
            ladderDrawColumn(i);
            ladderDrawLine(i);
        }
    }

    public void ladderDrawColumn(int ladderYNumber) {
        for (int i = 0; i < ladder[ladderYNumber].length; i+=2){
            ladder[ladderYNumber][i] = "ㅣ";
        }
    }

    public void ladderDrawLine(int ladderYNumber) {
        for(int i = 1; i < ladder[ladderYNumber].length; i+=2){
            ladder[ladderYNumber][i] = randomSetLine();
        }
    }

    public String randomSetLine(){
        if(randomBoolean())
            return " ";
        return "-";
    }

    public boolean randomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    public void testPrintLadder(){
        for(int i = 0; i<ladder.length; i++){
            for(int j = 0; j<ladder[i].length; j++){
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] getLadder(){
        return ladder;
    }
}