
public class TicTacToeBoard {
    public static void main(String[] args) {
      // Loop through the numbers 1 to 10
      for (int i = 1; i <= 10; i++) {
        // Inner loop through the numbers 1 to 10
        for (int j = 1; j <= 10; j++) {
          // Print the multiplication table for i and j
          System.out.println(i + " x " + j + " = " + (i * j));
        }
        // Add a new line after each row of the table
        System.out.println();
      }
    }
  }
  