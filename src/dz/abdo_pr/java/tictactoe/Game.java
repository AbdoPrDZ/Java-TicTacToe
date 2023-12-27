package dz.abdo_pr.java.tictactoe;

import java.util.Scanner;

public class Game {

  private Player playerA;
  private Player playerB;
  private GamePad pad = new GamePad();
  private boolean playerATurn = true; // we use it later
  private Player winnerPlayer = null;

  public Game(Player playerA, Player playerB) {
    this.playerA = playerA;
    this.playerB = playerB;
  }

  /**
   * insertLetter - insert new letter of next player at position (x, y)
   * 
   * @param posX
   * @param posY
   * @return true if success, false if there error
   */
  private boolean insertLetter(int posX, int posY) {
    Letter oldLetter = this.pad.getLetterAtPos(posX, posY);

    if (posX < 1 || posX > 3)
      System.err.println("ERROR[POS-X]: the position must be just 1, 2 or 3");
    else if (posY < 1 || posY > 3)
      System.err.println("ERROR[POS-Y]: the position must be just 1, 2 or 3");
    else if (oldLetter != null)
      System.err.println("ERROR[POS]: This position (" + posX + ", " + posY + ") already used");
    else {
      Letter letter = new Letter(
          (playerATurn ? playerA : playerB).getLetter(),
          posX, posY);
      pad.insertLetter(letter);
      // change the turn if is true will be false, of false will be true
      playerATurn = !playerATurn;
      return true;
    }
    return false;
  }

  /**
   * checkCase - check for case if all letters are the same
   * 
   * @param letters: the letters (size 3)
   * @return: true if all letters is the same, false not
   */
  private boolean checkCase(Letter[] letters) {
    // check if all letters are not null
    for (int i = 0; i < 3; i++)
      if (letters[i] == null)
        return false;

    // get letters char
    char letter1 = letters[0].getLetter();
    char letter2 = letters[1].getLetter();
    char letter3 = letters[2].getLetter();

    // check if all letters is tha same
    return letter1 == letter2 && letter1 == letter3;
  }

  private void checkWinner() {
    // first row letters
    Letter letter11 = pad.getLetterAtPos(1, 1);
    Letter letter12 = pad.getLetterAtPos(1, 2);
    Letter letter13 = pad.getLetterAtPos(1, 3);

    // second row letters
    Letter letter21 = pad.getLetterAtPos(2, 1);
    Letter letter22 = pad.getLetterAtPos(2, 2);
    Letter letter23 = pad.getLetterAtPos(2, 3);

    // third row letters
    Letter letter31 = pad.getLetterAtPos(3, 1);
    Letter letter32 = pad.getLetterAtPos(3, 2);
    Letter letter33 = pad.getLetterAtPos(3, 3);

    // xxx 1
    Letter[] row1 = { letter11, letter21, letter31 };
    // xxx 2
    Letter[] row2 = { letter12, letter22, letter32 };
    // xxx 3
    Letter[] row3 = { letter13, letter23, letter33 };

    // x3
    // x3
    // x3
    Letter[] col1 = { letter11, letter12, letter13 };
    // x3
    // x3
    // x3
    Letter[] col2 = { letter21, letter22, letter23 };
    // x3
    // x3
    // x3
    Letter[] col3 = { letter31, letter32, letter33 };

    // X
    // X
    // X
    Letter[] corn1 = { letter11, letter22, letter33 };
    // X
    // X
    // X
    Letter[] corn2 = { letter31, letter22, letter13 };

    // store all cases in one table
    // [][] means table of table of letters
    Letter[][] cases = {
        row1, row2, row3,
        col1, col2, col3,
        corn1, corn2,
    };

    for (Letter[] _case : cases) {
      if (checkCase(_case)) {
        winnerPlayer = playerA.getLetter() == letter11.getLetter() ? playerA : playerB;
      }
    }
  }

  /**
   * play - start play the game
   * 
   * @param scanner: the scanner
   */
  public void play(Scanner scanner) {
    // letter positions (x, y)
    int posX, posY;

    // keep looping while no winner and number of letters is less then 9
    while (winnerPlayer == null && pad.getLetters().length < 9) {
      pad.drawIt(); // draw the game pad
      // get current turn player
      Player turnPlayer = playerATurn ? playerA : playerB;
      // display the current turn with his letter
      System.out.println("Turn: " + turnPlayer.getName() + " '" + turnPlayer.getLetter() + "'");
      // enter letter positions
      System.out.print("Enter letter pos X: ");
      posX = scanner.nextInt();
      System.out.print("Enter letter pos Y: ");
      posY = scanner.nextInt();

      // insert the letter
      boolean insertSuccess = insertLetter(posX, posY);

      // check for insert success
      if (insertSuccess == false) {
        scanner.next();
      } // we use this to stop the loop

      // check if there is winner
      checkWinner();
    }

    // draw the last insert
    pad.drawIt();
  }

  public Player getWinner() {
    return winnerPlayer;
  }

}
