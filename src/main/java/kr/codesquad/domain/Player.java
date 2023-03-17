package kr.codesquad.domain;

public class Player {
  private final String name;
  private int col;
  private int row;

  public Player(String name, int col) {
    this.name = name;
    this.col = col;
    this.row = 0;
  }

  public String getName() {
    return name;
  }

  public int getCol() {
    return col;
  }

  public int getRow() {
    return row;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public void setRow(int row) {
    this.row = row;
  }
}
