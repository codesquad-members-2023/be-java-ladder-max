public class Output {
    public static void printLadder(String[][] line, String[][] person) {
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < person[0].length; j++) {
                System.out.print(person[i][j]);
                if(j < line[0].length) System.out.print(line[i][j]);
            }
        }
    }
}
