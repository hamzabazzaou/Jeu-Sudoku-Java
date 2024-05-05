import javax.swing.*;

/**
 * La vue chargée d'afficher l'interface utilisateur pour la vérification de la grille de Sudoku.
 */
public class VerifierView {
    private JFrame frame;
    private JButton verifierButton;

       /**
     * Constructeur de la classe VerifierView.
     */
    public VerifierView() {
        frame = new JFrame("Vérifier Sudoku");
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        verifierButton = new JButton("Vérifier");
        frame.add(verifierButton);
    }

     /**
     * Affiche la fenêtre de vérification.
     */
    public void show() {
        frame.setVisible(true);
    }

      /**
     * Obtient le bouton de vérification.
     * @return Le bouton de vérification.
     */
    public JButton getVerifierButton() {
        return verifierButton;
    }

       /**
     * Obtient la fenêtre de la vue.
     * @return La fenêtre de la vue.
     */
    public JFrame getFrame() {
        return frame;
    }
}
