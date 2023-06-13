package kr.ladder.view;

public class OutputView {
    private static final int DEFAULT_WIDTH = 6;
    private static final String EXIT_MASSAGE = "게임을 종료합니다.";
    private static final String RESULT_MESSAGE = "실행 결과";
    StringBuilder sb;

    public OutputView(){
         sb = new StringBuilder();
    }

    public void printAll(String[] players, String ladder, String[] prizes) {
        sb.append("\n").append("사다리 결과").append("\n").append("\n");
        printName(players);
        printLadder(ladder);
        printName(prizes);

        sb.deleteCharAt(sb.length() - 1); // 마지막 개행 제거
        System.out.println(sb);
        sb.setLength(0); // stringBuilder 초기화 (리셋)
    }

    private void printName(String[] words){
        for (String word : words) {
            sb.append(insertBlankAroundName(word));
        }
        sb.append("\n");
    }

    // TODO: 테스트를 위해 private -> public로 변경했는데 더 나은 방법이 없을까?
    public String insertBlankAroundName(String word){
        return insertFront(word.length()) + word + insertBack(word.length());
    }

    private String insertFront(int word){ // 글자수가 홀수면 (이름 뒤에 들어가는 공백 수 - 1) 개가 들어가야 한다.
        return " ".repeat((int)Math.floor((double)(DEFAULT_WIDTH - word) / 2));
    }

    private String insertBack(int word){ // 글자수가 홀수면 (이름 앞에 들어가는 공백 수 + 1) 개가 들어가야 한다.
        return " ".repeat((int)Math.ceil((double)(DEFAULT_WIDTH - word) / 2));
    }


    private void printLadder(String ladder){
        sb.append(ladder);
    }

    public void printExitMassage() {
        System.out.println(EXIT_MASSAGE);
    }

    public void print(String str) {
        System.out.println("\n" + RESULT_MESSAGE);
        System.out.println(str);
    }
}
