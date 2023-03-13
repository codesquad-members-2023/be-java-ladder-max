package kr.codesquad;

import java.util.ArrayList;

public class Ladder {
  private final ArrayList<ArrayList<Boolean>> ladder;

  public Ladder(ArrayList<ArrayList<Boolean>> ladder) {
    this.ladder = ladder;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (ArrayList<Boolean> row : ladder) {
      sb.append("  "); // 사람 이름 5글자가 기준이므로 사다리 앞에 2칸의 간격 추가
      for (boolean hasLine : row) {
        String line = hasLine ? "|-----" : "|     ";
        sb.append(line);
      }
      sb.append("\n");
    }

    return String.valueOf(sb);
  }
}
