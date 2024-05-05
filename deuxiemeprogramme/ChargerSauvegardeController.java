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
            int col = 0;

            while ((line = reader.readLine()) != null && row < 9) {
                // Parcourir chaque caractère de la ligne
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c) || c == '0') { // Inclure les caractères '0'
                        int decimalValue = convertToDecimal(c); // Convertir en décimal
                        gridData[row][col] = decimalValue;
                        col++; // Passer à la colonne suivante
                        // Passer à la ligne suivante si nous avons atteint la fin de la ligne
                        if (col == 9) {
                            col = 0;
                            row++;
                        }
                    }
                }
            }

            reader.close();
            System.out.println("Grille chargée avec succès.");
            return gridData;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Erreur lors du chargement de la grille : " + e.getMessage());
        }
        return null;
    }

    // Méthode pour convertir un caractère en entier décimal
    private int convertToDecimal(char c) {
        if (Character.isDigit(c)) {
            return Character.getNumericValue(c);
        } else {
            return 0; // Pour les caractères autres que les chiffres, nous retournons 0
        }
    }
}
