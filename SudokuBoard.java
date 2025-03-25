import java.util.List;
import java.util.ArrayList;

public class SudokuBoard {
    private int[][] board;
    private boolean[][] fixedCells;
    
    public SudokuBoard() {
        board = new int[9][9];
        fixedCells = new boolean[9][9];
    }
    
    public void initializePredefinedBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
                fixedCells[i][j] = false;
            }
        }
    
        String predefinedData = 
            "2,0;9,true 4,0;8,true 5,0;6,true 6,0;2,true " +
            "1,1;3,true 4,1;7,true 7,1;9,true 8,1;6,true " +
            "1,2;6,true 4,2;1,true 8,2;5,true " +
            "0,3;5,true 2,3;3,true 7,3;8,true " +
            "1,4;9,true 3,4;1,true 4,4;2,true 5,4;5,true 7,4;6,true " +
            "1,5;4,true 6,5;1,true 8,5;7,true " +
            "0,6;7,true 4,6;3,true 7,6;1,true " +
            "0,7;9,true 1,7;8,true 3,7;6,true 4,7;4,true 7,7;2,true " +
            "2,8;6,true 3,8;8,true 4,8;5,true 6,8;4,true";
    
        String[] cells = predefinedData.split(" ");
        for (String cell : cells) {
            String[] parts = cell.split(";");
            String[] coords = parts[0].split(",");
            String[] values = parts[1].split(",");
            
            int row = Integer.parseInt(coords[0]);
            int col = Integer.parseInt(coords[1]);
            int num = Integer.parseInt(values[0]);
            
            board[row][col] = num;
            fixedCells[row][col] = true;
        }
    }
    
    public void displayBoard() {
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    System.out.print(fixedCells[i][j] ? "[" + board[i][j] + "] " : board[i][j] + "  ");
                } else {
                    System.out.print(".  ");
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
    
    public boolean isValidMove(int row, int col, int num) {
        if (fixedCells[row][col]) {
            return false;
        }
        
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        
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
    
    public void placeNumber(int row, int col, int num) {
        if (!fixedCells[row][col]) {
            board[row][col] = num;
        }
    }
    
    public void removeNumber(int row, int col) {
        if (!fixedCells[row][col]) {
            board[row][col] = 0;
        }
    }
    
    public List<Integer> getNumerosPossiveis(int row, int col) {
        List<Integer> possiveis = new ArrayList<>();
        
        if (board[row][col] != 0 || fixedCells[row][col]) {
            return possiveis;
        }
        
        for (int num = 1; num <= 9; num++) {
            if (isValidMove(row, col, num)) {
                possiveis.add(num);
            }
        }
        
        return possiveis;
    }
    
    public boolean isCellFixed(int row, int col) {
        return fixedCells[row][col];
    }
    
    public int[][] getBoard() {
        return board;
    }
}