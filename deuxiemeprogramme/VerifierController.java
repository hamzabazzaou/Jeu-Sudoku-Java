import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFrame;

/**
 * Le contrôleur chargé de gérer les actions liées à la vérification de la grille de Sudoku.
 */
public class VerifierController {
    private VerifierView view;

    
    /**
     * Constructeur de la classe VerifierController.
     * @param view La vue associée à ce contrôleur.
     */
    public VerifierController(VerifierView view) {
        this.view = view;
    }

    
    /**
     * Affiche un message dans une boîte de dialogue.
     * @param message Le message à afficher.
     */
    public void showMessage(String message) {
        JFrame frame = view.getFrame();

        // Afficher le message dans une boîte de dialogue
        JOptionPane.showMessageDialog(frame, message);
    }
}
