public class SudokuGenerator {

    private int[][] board = new int[9][9]; // 9x9 Sudoku board

    // Generate the board using a base pattern
    public void generateBoard() {
        // Fill the board with a simple pattern
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = (row * 3 + row / 3 + col) % 9 + 1;
            }
        }

        // for swapping rows in each 3-row block
        for (int block = 0; block < 3; block++) {
            int startRow = block * 3;
            swapRows(startRow, startRow + 1); // Swap first and second row in block
            swapRows(startRow, startRow + 2); // Swap first and third row in block
        }

        // for swapping columns in each 3-column block
        for (int block = 0; block < 3; block++) {
            int startCol = block * 3;
            swapColumns(startCol, startCol + 1); // Swap first and second column in block
            swapColumns(startCol, startCol + 2); // Swap first and third column in block
        }
    }

    // this allows to swap two rows
    private void swapRows(int row1, int row2) {
        int[] temp = board[row1];
        board[row1] = board[row2];
        board[row2] = temp;
    }

    // this swaps the two columns
    private void swapColumns(int col1, int col2) {
        for (int row = 0; row < 9; row++) {
            int temp = board[row][col1];
            board[row][col1] = board[row][col2];
            board[row][col2] = temp;
        }
    }

    // this prints the board neatly
    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0 && col != 0) System.out.print("| ");
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SudokuGenerator sudoku = new SudokuGenerator();
        sudoku.generateBoard();
        sudoku.printBoard();
    }
}
