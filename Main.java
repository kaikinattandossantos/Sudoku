public class Main {
    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        game.startGame();

        SudokuRegras regras = new SudokuRegras();
        regras.mostrarRegras();
    }
}