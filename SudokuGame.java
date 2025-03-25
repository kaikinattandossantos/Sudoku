import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;
    private Scanner scanner;
    
    public SudokuGame() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }
    
    public void startGame() {
        System.out.println("Bem-vindo ao Sudoku!");
        board.initializeBoard();
        board.displayBoard();
        
        boolean playing = true;
        
        while (playing) {
            System.out.println("\nComandos:");
            System.out.println("1. Inserir número (linha coluna número)");
            System.out.println("2. Remover número (linha coluna)");
            System.out.println("3. Verificar solução");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Digite linha (1-9), coluna (1-9) e número (1-9): ");
                    int row = scanner.nextInt() - 1;
                    int col = scanner.nextInt() - 1;
                    int num = scanner.nextInt();
                    
                    if (board.isValidMove(row, col, num)) {
                        board.placeNumber(row, col, num);
                        board.displayBoard();
                    } else {
                        System.out.println("Movimento inválido!");
                    }
                    break;
                    
                case 2:
                    System.out.print("Digite linha (1-9) e coluna (1-9) para remover: ");
                    row = scanner.nextInt() - 1;
                    col = scanner.nextInt() - 1;
                    board.removeNumber(row, col);
                    board.displayBoard();
                    break;
                    
                case 3:
                    if (isBoardComplete()) {
                        System.out.println("Parabéns! Você completou o Sudoku corretamente!");
                    } else {
                        System.out.println("O tabuleiro ainda não está completo ou contém erros.");
                    }
                    break;
                    
                case 4:
                    playing = false;
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
        System.out.println("Obrigado por jogar!");
    }
    
    private boolean isBoardComplete() {
        int[][] currentBoard = board.getBoard();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (currentBoard[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}