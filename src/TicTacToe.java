import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        int SumbuX, SumbuY;
        boolean playAgain = true;

        System.out.println("""
                  _____ _        _____            _____         \s
                 |_   _(_)      |_   _|          |_   _|        \s
                   | |  _  ___    | | ___   ___    | | ___   ___\s
                   | | | |/ __|   | |/ _ \\ / _ \\   | |/ _ \\ / _ \\
                   | | | | (__    | | (_) |  __/   | | (_) |  __/
                   \\_/ |_|\\___|   \\_/\\___/ \\___|   \\_/\\___/ \\___|
                
                """);
        
        while (playAgain) {
            Board x;
            int turn = -1; // X starts first
            x = new Board(turn);
            
            do {
                x.disp();
                System.out.println("Input coordinates (x,y) for " + (x.getTurn() == -1 ? "X" : "O"));
                
                // Get X coordinate with validation
                while (true) {
                    try {
                        System.out.print("Input x (0-2): ");
                        SumbuX = inputUser.nextInt();
                        if (SumbuX < 0 || SumbuX > 2) {
                            System.out.println("Please enter a number between 0 and 2!");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number!");
                        inputUser.next(); // Clear invalid input
                    }
                }
                
                // Get Y coordinate with validation
                while (true) {
                    try {
                        System.out.print("Input y (0-2): ");
                        SumbuY = inputUser.nextInt();
                        if (SumbuY < 0 || SumbuY > 2) {
                            System.out.println("Please enter a number between 0 and 2!");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number!");
                        inputUser.next(); // Clear invalid input
                    }
                }
                
                if (!x.setBoard(SumbuY, SumbuX)) {
                    System.out.println("That position is already taken or invalid! Try again.");
                }
            } while (!x.gameOver());
            
            x.disp();
            
            int winner = x.winner();
            if (winner == -1) {
                System.out.println("X wins! Congratulations!");
            } else if (winner == 1) {
                System.out.println("O wins! Congratulations!");
            } else {
                System.out.println("It's a draw!");
            }
            
            // Ask to play again
            System.out.print("Do you want to play again? (y/n): ");
            String response = inputUser.next().toLowerCase();
            if (!response.equals("y")) {
                playAgain = false;
            } else {
                x.resetBoard();
            }
        }
        
        System.out.println("Thanks for playing Tic Tac Toe!");
        inputUser.close();
    }
}