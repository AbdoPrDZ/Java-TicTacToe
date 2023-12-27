package dz.abdo_pr.java.tictactoe;

public class Letter {
  private char letter;
  private int posX;
  private int posY;

  public Letter(char letter, int posX, int posY) {
    this.letter = letter;
    this.posX = posX;
    this.posY = posY;
  }

  public char getLetter() {
    return letter;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }
}
