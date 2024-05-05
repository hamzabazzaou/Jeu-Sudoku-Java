import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Contrôleur chargé de charger et sauvegarder des grilles de Sudoku.
 */
public class ChargerSauvegardeController {
    /**
     * Charge les données de la grille à partir d'un fichier.
     * 
     * @param filePath Chemin du fichier de sauvegarde
     * @param frame JFrame associée à l'application
     * @return La grille de Sudoku chargée sous forme d'un tableau d'entiers
     */
    public int[][] loadGridData(String filePath, JFrame frame) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int[][] gridData = new int[9][9];
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 9) {
                for (int col = 0; col < 9 && col < line.length(); col++) {
                    char c = line.charAt(col);
                    if (c == '.') {
                        gridData[row][col] = 0;
                    } else if (Character.isDigit(c)) {
                        gridData[row][col] = Character.getNumericValue(c);
                    } else {
                        gridData[row][col] = -1;
                    }
                }
                row++;
            }
            reader.close();
            System.out.println("Grille chargée avec succès.");
            return gridData;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Erreur lors du chargement de la grille : " + e.getMessage());
        }
        return null;
    }
}
