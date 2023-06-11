package kr.ladder.view;

public class OutputView {
    private static final int DEFAULT_WIDTH = 6;
    StringBuilder sb;

    public OutputView(){
         sb = new StringBuilder();
    }

    public void printResult(String[] players, String ladder, String[] prizes){
        printName(players);
        printLadder(ladder);
        printName(prizes);

        sb.deleteCharAt(sb.length()-1); // 마지막 개행 제거
        System.out.println(sb);
        sb.setLength(0); // stringBuilder 초기화 (리셋)
    }

    // 이 부분은 OutputView 의 일이 아니지 않나 고민중...
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
}
