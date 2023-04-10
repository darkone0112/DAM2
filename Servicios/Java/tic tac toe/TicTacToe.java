import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        resetBoard();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();

            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter your move (row column): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!makeMove(currentPlayer, row, col));

            if (checkForWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (checkForDraw()) {
                System.out.println("Draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static boolean makeMove(char player, int row, int col) {
        if (board[row][col] != ' ') {
            return false;
        }
        board[row][col] = player;
        return true;
    }

    private static boolean checkForWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }

        return false;
    }
    private static void printBoard() {
        System.out.println("  0  1  2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static boolean checkForDraw() {
        boolean state = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3;j++) {
                if (board[i][j] == ' ') {
                    return false;
            }
        }
    }
    return state;
}
}

        
       
