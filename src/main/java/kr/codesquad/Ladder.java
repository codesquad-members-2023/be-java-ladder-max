package kr.codesquad;

public class Ladder {
  private final boolean[][] ladder;

  public Ladder(boolean[][] ladder) {
    this.ladder = ladder;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (boolean[] row : ladder) {
      for (boolean hasLine : row) {
        String line = hasLine ? "|-" : "| ";
        sb.append(line);
      }
      sb.append("\n");
    }

    return String.valueOf(sb);
  }
}
