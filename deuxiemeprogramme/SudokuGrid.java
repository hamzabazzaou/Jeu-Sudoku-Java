/**
 * Représente la grille de Sudoku.
 */
public class SudokuGrid {
    private int[][] grid;

    /**
     * Constructeur de SudokuGrid.
     * Initialise la grille avec des zéros.
     */
    public SudokuGrid() {
        // Initialisation de la grille avec des zéros
        grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 0;
            }
        }
    }

     /**
     * Vérifie si le placement du nombre est valide dans la grille.
     * @param row L'indice de ligne
     * @param col L'indice de colonne
     * @param num Le nombre à placer
     * @return true si le placement est valide, sinon false
     */
    public boolean isValidMove(int row, int col, int num) {
        // Vérifie si le placement du nombre est valide dans la grille
        if (isValidRow(row, num) && isValidColumn(col, num) && isValidBox(row - row % 3, col - col % 3, num)) {
            return true;
        }
        return false;
    }

    private boolean isValidRow(int row, int num) {
        // Vérifie si le nombre est déjà présent dans la ligne
        for (int col = 0; col < 9; col++) {
            if (grid[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(int col, int num) {
        // Vérifie si le nombre est déjà présent dans la colonne
        for (int row = 0; row < 9; row++) {
            if (grid[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBox(int startRow, int startCol, int num) {
        // Vérifie si le nombre est déjà présent dans la boîte 3x3
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + startRow][col + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

     /**
     * Place un nombre dans la grille.
     * @param row L'indice de ligne
     * @param col L'indice de colonne
     * @param num Le nombre à placer
     */
    public void setNumber(int row, int col, int num) {
        // Place un nombre dans la grille
        grid[row][col] = num;
    }

        /**
     * Récupère le nombre à une position donnée dans la grille.
     * @param row L'indice de ligne
     * @param col L'indice de colonne
     * @return Le nombre à la position spécifiée
     */
    public int getNumber(int row, int col) {
        // Récupère le nombre à une position donnée dans la grille
        return grid[row][col];
    }

        /**
     * Vérifie si la grille est pleine.
     * @return true si la grille est pleine, sinon false
     */
    public boolean isGridFull() {
        // Vérifie si la grille est pleine
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

      /**
     * Résout la grille de Sudoku.
     * @return true si la grille est résolue, sinon false
     */
    public boolean solve() {
        // Résout la grille de Sudoku 
        return solveSudoku();
    }

    private boolean solveSudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidMove(row, col, num)) {
                            grid[row][col] = num;
                            if (solveSudoku()) {
                                return true;
                            }
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


}
