public class SudokuBoard {
    private int[][] board;
    
    public SudokuBoard() {
        board = new int[9][9];
    }
    
    // Inicializa um tabuleiro vazio
    public void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0; // 0 representa célula vazia
            }
        }
    }
    
    // Exibe o tabuleiro no console
    public void displayBoard() {
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
                
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }
    
    // Verifica se um movimento é válido
    public boolean isValidMove(int row, int col, int num) {
        // Verifica linha e coluna
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        
        // Verifica o bloco 3x3
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // Coloca um número no tabuleiro
    public void placeNumber(int row, int col, int num) {
        board[row][col] = num;
    }
    
    // Remove um número do tabuleiro
    public void removeNumber(int row, int col) {
        board[row][col] = 0;
    }
    
    // Getters e Setters
    public int[][] getBoard() {
        return board;
    }
}