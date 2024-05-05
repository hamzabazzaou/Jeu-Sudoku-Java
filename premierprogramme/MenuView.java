import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuView {
    private JFrame frame;
    private JPanel panel;
    private JButton jouerButton;
    private JButton commentJouerButton;
    private JButton quitterButton;

    public MenuView() {
        frame = new JFrame();
        frame.setSize(600, 360);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon("Menu.png");
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundIcon);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        jouerButton = new JButton("Jouer");
        commentJouerButton = new JButton("Comment jouer ?");
        quitterButton = new JButton("Quitter");

        Font buttonFont = new Font(jouerButton.getFont().getName(), Font.PLAIN, 18);
        jouerButton.setFont(buttonFont);
        commentJouerButton.setFont(buttonFont);
        quitterButton.setFont(buttonFont);

        jouerButton.addActionListener(e -> {
            frame.setVisible(false); // Masquer la fenêtre du menu
        });

        commentJouerButton.addActionListener(e -> {
            // Créer une nouvelle fenêtre pour afficher les règles du jeu
            JFrame reglesFrame = new JFrame("Comment Jouer ?");
            reglesFrame.setSize(600, 400); // Ajuster la taille de la fenêtre
            reglesFrame.setLocationRelativeTo(frame); // Centrer la fenêtre par rapport à la fenêtre du menu principal

            // Créer un JTextArea pour afficher les règles
            JTextArea reglesTextArea = new JTextArea();
            reglesTextArea.setEditable(false);
            reglesTextArea.setLineWrap(true);
            reglesTextArea.setWrapStyleWord(true);
            reglesTextArea.setText("Les règles de notre Sudoku sont simples :\n\n"
                    + "1. Remplissez la grille avec des chiffres de 1 à 9 de telle sorte que chaque ligne, chaque colonne et chaque région 3x3 contiennent tous les chiffres de 1 à 9 sans répétition.\n\n"
                    + "2. Après avoir complété une ligne, une colonne ou une région, cliquez sur le bouton \"Menu\" en haut à gauche, puis sur \"Vérifier\" pour vous assurer que les chiffres sont corrects.\n\n"
                    + "3. En cas de difficulté, utilisez le bouton \"Menu\" en haut à gauche et sélectionnez \"Résoudre Sudoku\".\n\n"
                    + "4. Une fois la grille remplie avec des chiffres valides, le Sudoku est résolu !");

            // Ajouter le JTextArea à la fenêtre
            reglesFrame.add(reglesTextArea);

            // Ajouter un bouton "Quitter" à la fenêtre des règles
            JButton quitterButtonRegles = new JButton("Quitter");
            quitterButtonRegles.addActionListener(e1 -> {
                reglesFrame.dispose(); // Fermer la fenêtre des règles
            });

            // Ajouter le bouton "Quitter" à la fenêtre
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.add(quitterButtonRegles);
            reglesFrame.add(buttonPanel, BorderLayout.SOUTH);

            // Rendre la fenêtre visible
            reglesFrame.setVisible(true);
        });

        quitterButton.addActionListener(e -> {
            System.exit(0); // Quitter l'application
        });

        panel.add(jouerButton);
        panel.add(commentJouerButton);
        panel.add(quitterButton);

        backgroundLabel.setLayout(new BorderLayout());
        backgroundLabel.add(panel, BorderLayout.CENTER);

        frame.setContentPane(backgroundLabel);
        frame.add(panel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    public JButton getJouerButton() {
        return jouerButton;
    }

    public JButton getCommentJouerButton() {
        return commentJouerButton;
    }

    public JButton getQuitterButton() {
        return quitterButton;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuView menu = new MenuView();
            menu.show();
        });
    }
}