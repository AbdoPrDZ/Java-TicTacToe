package dz.abdo_pr.java.tictactoe;

public class GamePad {
  private Letter[] letters = new Letter[0];

  /**
   * getLetters - get game pad letters
   * 
   * @return
   */
  public Letter[] getLetters() {
    return letters;
  }

  /**
   * insertLetter - insert an letter
   * 
   * @param letter: the new letter
   */
  public void insertLetter(Letter letter) {
    // get old letters table length
    int len = letters.length;
    // create new empty letters table with old length + 1
    Letter[] newLetters = new Letter[len + 1];

    // fill the new table with the old table items
    for (int i = 0; i < letters.length; i++)
      newLetters[i] = letters[i];

    // set new letter to the last position
    newLetters[len] = letter;

    // change the old letters table with the new
    letters = newLetters;
  }

  /**
   * getLetterAtPos - get an letter at position (x, y)
   * 
   * @param x
   * @param y
   * @return the letter if is exists or null if not exists
   */
  public Letter getLetterAtPos(int x, int y) {
    for (Letter letter : letters)
      if (letter != null && letter.getPosX() == x && letter.getPosY() == y)
        return letter;

    return null;
  }

  /**
   * drawIt - draw the game pad with letters found
   */
  public void drawIt() {
    // clear console output
    System.out.print("\033[H\033[2J");
    System.out.flush();

    // get first row letters
    Letter letter11 = getLetterAtPos(1, 1);
    Letter letter12 = getLetterAtPos(1, 2);
    Letter letter13 = getLetterAtPos(1, 3);

    // get second row letters
    Letter letter21 = getLetterAtPos(2, 1);
    Letter letter22 = getLetterAtPos(2, 2);
    Letter letter23 = getLetterAtPos(2, 3);

    // get third row letters
    Letter letter31 = getLetterAtPos(3, 1);
    Letter letter32 = getLetterAtPos(3, 2);
    Letter letter33 = getLetterAtPos(3, 3);

    // init the draw string
    String draw = "X----1-----2-----3---\n";
    draw += "|  _____ _____ _____\n"; // the top border
    draw += "| :     :     :     :\n";

    // first row "1 : X : O : X :"
    draw += "1 :  "; // the left border
    draw += (letter11 != null ? letter11.getLetter() : " ") + "  :  "; // set letter (1, 1) if exists with end border
    draw += (letter21 != null ? letter21.getLetter() : " ") + "  :  "; // set letter (2, 1) if exists with end border
    draw += (letter31 != null ? letter31.getLetter() : " ") + "  :\n"; // set letter (3, 1) if exists with end border
                                                                       // with end line

    draw += "| :_____:_____:_____:\n";
    draw += "| :     :     :     :\n";

    // second row "2 : X : O : X :"
    draw += "2 :  ";
    draw += (letter12 != null ? letter12.getLetter() : " ") + "  :  "; // set letter (1, 2) if exists with end border
    draw += (letter22 != null ? letter22.getLetter() : " ") + "  :  "; // set letter (2, 2) if exists with end border
    draw += (letter32 != null ? letter32.getLetter() : " ") + "  :\n"; // set letter (3, 2) if exists with end border
                                                                       // with end line

    draw += "| :_____:_____:_____:\n";
    draw += "| :     :     :     :\n";

    // third row "3 : X : O : X :"
    draw += "3 :  ";
    draw += (letter13 != null ? letter13.getLetter() : " ") + "  :  "; // set letter (1, 3) if exists with end border
    draw += (letter23 != null ? letter23.getLetter() : " ") + "  :  "; // set letter (2, 3) if exists with end border
    draw += (letter33 != null ? letter33.getLetter() : " ") + "  : \n"; // set letter (3, 3) if exists with end border
    // with end line

    // set the bottom border
    draw += "| :_____:_____:_____:\n";
    draw += "Y\n";

    // draw it
    System.out.print(draw);
  }

}
