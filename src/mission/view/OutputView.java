package mission.view;

public class OutputView {

    public void printStrings(String[][] strings){
        for (String[] row: strings) {
            for (String column: row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

}
