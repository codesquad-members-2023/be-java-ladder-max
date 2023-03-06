public class Output {
    public static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.line.length; i++) {
            for (int j = 0; j < ladder.person[0].length; j++) {
                System.out.print(ladder.person[i][j]);
                if(j < ladder.line[0].length) System.out.print(ladder.line[i][j]);
            }
            System.out.println();
        }
    }
}
