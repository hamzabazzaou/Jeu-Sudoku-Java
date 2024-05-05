import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur pour la grille Sudoku.
 */
public class SudokuController implements ActionListener {
    private SudokuGrid model;
    private SudokuView view;

    /**
     * Constructeur de SudokuController.
     * @param model Le modèle de la grille Sudoku
     * @param view La vue de la grille Sudoku
     */
    public SudokuController(SudokuGrid model, SudokuView view) {
        this.model = model;
        this.view = view;

        view.addController(this);
    }

    /**
     * Gère les événements liés à la grille Sudoku.
     * @param e L'événement à gérer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupérer la source de l'événement
        Object source = e.getSource();

        // Parcourir les zones de texte de la grille
        JTextField[][] gridTextFields = view.getGridTextFields();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (source == gridTextFields[row][col]) {
                    // Action spécifique à la zone de texte cliquée
                    String input = gridTextFields[row][col].getText();
                    if (!input.isEmpty()) {
                        try {
                            int num = Integer.parseInt(input);
                            model.setNumber(row, col, num); 
                        } catch (NumberFormatException ex) {
                            // Gérer l'erreur si l'utilisateur entre un texte non numérique
                            view.showMessage("Veuillez entrer un numéro valide.");
                        }
                    }
                }
            }
        }
    }
}
