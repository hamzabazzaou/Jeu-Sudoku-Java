import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe principale de l'application Sudoku.
 */
public class Main {
    /**
     * Point d'entrée de l'application.
     * 
     * @param args Arguments de la ligne de commande
     */
    public static void main(String[] args) {
        // Création de la vue du menu
        MenuView menuView = new MenuView();

        // Obtention des boutons du menu
        JButton jouerButton = menuView.getJouerButton();
        JButton commentJouerButton = menuView.getCommentJouerButton();
        JButton quitterButton = menuView.getQuitterButton();

        // Création du contrôleur du menu
        JFrame frame = menuView.getFrame(); 
        MenuController menuController = new MenuController(frame, jouerButton, commentJouerButton, quitterButton);

        // Ajout du contrôleur du menu aux boutons du menu
        jouerButton.addActionListener(menuController);
        commentJouerButton.addActionListener(menuController);
        quitterButton.addActionListener(menuController);

        // Affichage de la vue du menu
        menuView.show();

    }

}

