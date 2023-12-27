package dz.abdo_pr.java.tictactoe;

public class Player {
  private String name;
  private char letter;

  public Player(String name, char letter) {
    this.name = name;
    this.letter = letter;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public char getLetter() {
    return letter;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  @Override
  public String toString() {
    return "Player [name=" + name + ", letter=" + letter + "]";
  }

}
