import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        jouerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileSelectionDialog();
            }
        });
        commentJouerButton = new JButton("Comment jouer ?");
        commentJouerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RulesExplanationWindow rulesWindow = new RulesExplanationWindow();
                rulesWindow.setVisible(true);
            }
        });
        quitterButton = new JButton("Quitter");

        Font buttonFont = new Font(jouerButton.getFont().getName(), Font.PLAIN, 18);
        jouerButton.setFont(buttonFont);
        commentJouerButton.setFont(buttonFont);
        quitterButton.setFont(buttonFont);

        panel.add(jouerButton);
        panel.add(commentJouerButton);
        panel.add(quitterButton);

        backgroundLabel.setLayout(new BorderLayout());
        backgroundLabel.add(panel, BorderLayout.CENTER);

        frame.setContentPane(backgroundLabel);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void openFileSelectionDialog() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            ChargerSauvegardeController charger = new ChargerSauvegardeController();
            int[][] savedGridData = charger.loadGridData(filePath, frame);

            if (savedGridData != null) {
                frame.dispose();
                SudokuView sudokuView = new SudokuView(savedGridData);
                sudokuView.display();
            }
        }
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

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuView menuView = new MenuView();
                menuView.show();
            }
        });
    }
}

class RulesExplanationWindow extends JFrame {

    public RulesExplanationWindow() {
        setTitle("Comment jouer ?");
        setSize(600, 400); // Ajustez les dimensions ici
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setText("Les règles de notre Sudoku sont simples :\n\n"
                + "1. Remplissez la grille avec des chiffres de 1 à 9 de telle sorte que chaque ligne, chaque colonne et chaque région 3x3 contiennent tous les chiffres de 1 à 9 sans répétition.\n\n"
                + "2. Après avoir complété une ligne, une colonne ou une région, cliquez sur le bouton \"Menu\" en haut à gauche, puis sur \"Vérifier\" pour vous assurer que les chiffres sont corrects.\n\n"
                + "3. En cas de difficulté, utilisez le bouton \"Menu\" en haut à gauche et sélectionnez \"Résoudre Sudoku\".\n\n"
                + "4. Une fois la grille remplie avec des chiffres valides, le Sudoku est résolu !");

        JScrollPane scrollPane = new JScrollPane(rulesTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton quitterButton = new JButton("Quitter");
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre actuelle
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(quitterButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}