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
      for (boolean hasLine : row) {
        String line = hasLine ? "|-" : "| ";
        sb.append(line);
      }
      sb.append("\n");
    }

    return String.valueOf(sb);
  }
}
