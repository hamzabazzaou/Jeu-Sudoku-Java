import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur du menu principal de l'application Sudoku.
 */
public class MenuController implements ActionListener {
    private JFrame frame;
    private JButton jouerButton;
    private JButton commentJouerButton;
    private JButton quitterButton;

       /**
     * Constructeur du MenuController.
     * 
     * @param frame JFrame associée à l'application
     * @param jouerButton Bouton pour commencer à jouer
     * @param commentJouerButton Bouton pour afficher les instructions
     * @param quitterButton Bouton pour quitter l'application
     */
    public MenuController(JFrame frame, JButton jouerButton, JButton commentJouerButton, JButton quitterButton) {
        this.frame = frame;
        this.jouerButton = jouerButton;
        this.commentJouerButton = commentJouerButton;
        this.quitterButton = quitterButton;

        //Ecouteurs d'événements
        jouerButton.addActionListener(this);
        commentJouerButton.addActionListener(this);
        quitterButton.addActionListener(this);
            /**
     * Gère les événements des boutons du menu principal.
     * 
     * @param e L'événement déclenché
     */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jouerButton) {
            // La logique spécifique pour jouer sera traitée dans MenuView
            // Nous n'avons pas besoin d'une action spécifique ici
        } else if (e.getSource() == commentJouerButton) {
            // Logique pour afficher les instructions pour jouer
        } else if (e.getSource() == quitterButton) {
            // Logique pour quitter l'application
            System.exit(0);
        }
    }
}
