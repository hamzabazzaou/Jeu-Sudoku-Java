import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Contrôleur chargé de sauvegarder les données d'une grille Sudoku.
 */
public class SauvegardeController {
     /**
     * Sauvegarde les données de la grille Sudoku dans un fichier.
     * @param sudokuGridData Les données de la grille Sudoku à sauvegarder.
     * @param frame La fenêtre JFrame associée à l'application.
     */
    public void saveData(int[][] sudokuGridData, JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (sudokuGridData[i][j] == 0) {
                            writer.write('.');
                        } else {
                            writer.write(String.valueOf(sudokuGridData[i][j]));
                        }
                    }
                    writer.newLine();
                }
                writer.close();
                System.out.println("Données sauvegardées avec succès.");
            } catch (IOException e) {
                System.err.println("Erreur lors de la sauvegarde des données : " + e.getMessage());
            }
        }
    }
}
