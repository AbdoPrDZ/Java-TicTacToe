package dz.abdo_pr.java.tictactoe;

import java.util.Scanner;

public class Main {

  public static void clearConsole() {
    // clear console output
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static Player enterPlayer(Scanner scanner, String msg) {
    return enterPlayer(scanner, msg, '*');
  }

  /**
   * enterPlayer - create an player
   * 
   * @param scanner:     the scanner
   * @param firstLetter: the first letter chosen, if not exist by default will '*'
   * @return the new Player
   */
  public static Player enterPlayer(Scanner scanner, String msg, char firstLetter) {
    String name;
    String letterInput = " "; // i use it to set in there the user input
    char letter;

    clearConsole();

    // display the msg
    System.out.println(msg);

    // enter player name
    System.out.print("Enter your name: ");
    name = scanner.nextLine();

    // check if there first letter
    if (firstLetter == '*') {
      // repeat ask to enter letter while input length is not one letter and is not x
      // or o
      while (letterInput.length() != 1 || (letterInput.charAt(0) != 'X' && letterInput.charAt(0) != 'O')) {
        // ask to enter letter
        System.out.print("Enter your letter (X, O): ");
        // read user input and convert it to upper case
        letterInput = scanner.nextLine().toUpperCase();
        // verify the validation
        if (letterInput.length() != 1 || (letterInput.charAt(0) != 'X' && letterInput.charAt(0) != 'O'))
          System.err.println("Please enter valid char"); // show error
      }
      // get the letter
      letter = letterInput.charAt(0);
    } else {
      // set by default the other letter if there is first letter
      letter = firstLetter == 'X' ? 'O' : 'X';
    }
    // create the player
    return new Player(name, letter);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(
        "|--------------------------------------------------------------------------------|\n" +
            "|             ▄▄                                                                 |\n" +
            "| ███▀▀██▀▀███ ██        ███▀▀██▀▀███              ███▀▀██▀▀███                  |\n" +
            "| █▀   ██   ▀█           █▀   ██   ▀█              █▀   ██   ▀█                  |\n" +
            "|      ██    ▀███  ▄██▀██     ██     ▄█▀██▄  ▄██▀██     ██      ▄██▀██▄  ▄▄█▀██  |\n" +
            "|      ██      ██ ██▀  ██     ██    ██   ██ ██▀  ██     ██     ██▀   ▀██▄█▀   ██ |\n" +
            "|      ██      ██ ██          ██     ▄█████ ██          ██     ██     ████▀▀▀▀▀▀ |\n" +
            "|      ██      ██ ██▄    ▄    ██    ██   ██ ██▄    ▄    ██     ██▄   ▄████▄    ▄ |\n" +
            "|    ▄████▄  ▄████▄█████▀   ▄████▄  ▀████▀██▄█████▀   ▄████▄    ▀█████▀  ▀█████▀ |\n" +
            "|                                                                                |\n" +
            "|--------------------------------------------------------------------------------|\n" +
            "|          ___  _  _        ___  _        _       ___       ___   ____           |\n" +
            "|         | _ )| || |      /   \\| |__  __| | ___ | _ \\ _ _ |   \\ |_  /           |\n" +
            "|         | _ \\ \\_. |      | - ||  _ \\/ _` |/ _ \\|  _/| '_|| |) | / /            |\n" +
            "|         |___/ |__/       |_|_||____/\\__/_|\\___/|_|  |_|  |___/ /___|           |\n" +
            "|                                                                                |\n" +
            "---------------------------------------------------------------------------------|\n");

    System.out.println("\nType any thing to start");
    scanner.nextLine();

    Player playerA = enterPlayer(scanner, "Enter Player A details: ");
    Player playerB = enterPlayer(scanner, "Enter Player B details: ", playerA.getLetter());

    Game game = new Game(playerA, playerB);

    game.play(scanner);

    Player winner = game.getWinner();
    if (winner != null)
      System.out.println("The winner is " + game.getWinner());
    else
      System.out.println("There are no winner in this game");

    scanner.close();
  }

}
