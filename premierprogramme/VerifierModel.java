public class VerifierModel {
    private int[][] grid; // Représentation des données de la grille

    public VerifierModel(int[][] grid) {
        this.grid = grid;
    }

    public boolean verify() {
        // Vérification des lignes
        for (int row = 0; row < 9; row++) {
            if (!isUnique(getRow(row))) {
                return false;
            }
        }

        // Vérification des colonnes
        for (int col = 0; col < 9; col++) {
            if (!isUnique(getColumn(col))) {
                return false;
            }
        }

        // Vérification des régions
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isUnique(getRegion(row, col))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isUnique(int[] nums) {
        boolean[] seen = new boolean[10];
        for (int num : nums) {
            if (num != 0) {
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }

    // Méthodes pour obtenir une ligne, une colonne ou une région de la grille
    private int[] getRow(int row) {
        return grid[row];
    }

    private int[] getColumn(int col) {
        int[] column = new int[9];
        for (int i = 0; i < 9; i++) {
            column[i] = grid[i][col];
        }
        return column;
    }

    private int[] getRegion(int startRow, int startCol) {
        int[] region = new int[9];
        int index = 0;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                region[index++] = grid[row][col];
            }
        }
        return region;
    }
}