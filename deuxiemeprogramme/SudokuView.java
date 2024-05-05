import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
/**
 * Vue de la grille et du jeu
 */
public class SudokuView {
    private JFrame frame;
    private JPanel[][] regionPanels;
    private JTextField[][] gridTextFields;
    private ArrayList<SudokuController> controllers;
    private Timer timer;
    private JLabel timerLabel;

      /**
     * Constructeur de la classe SudokuView.
     * @param gridData Les données initiales de la grille Sudoku
     */
    public SudokuView(int[][] gridData) {
        frame = new JFrame("Sudoku");
        frame.setSize(600, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 3));

        regionPanels = new JPanel[3][3];
        gridTextFields = new JTextField[9][9];
        Font textFieldFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        controllers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel regionPanel = new JPanel(new GridLayout(3, 3, 2, 2));
                regionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                for (int m = i * 3; m < i * 3 + 3; m++) {
                    for (int n = j * 3; n < j * 3 + 3; n++) {
                        JTextField textField = new JTextField();
                        textField.setPreferredSize(new Dimension(50, 50));
                        textField.setFont(textFieldFont);
                        regionPanel.add(textField);
                        gridTextFields[m][n] = textField;
                        if (gridData[m][n] != 0) {
                            textField.setText(String.valueOf(gridData[m][n]));
                            textField.setEditable(false);
                        }
                    }
                }

                regionPanels[i][j] = regionPanel;
                mainPanel.add(regionPanel);
            }
        }

        timerLabel = new JLabel();
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        frame.add(timerLabel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        createMenuBar();
    }

        /**
     * Ajoute un contrôleur à la liste des contrôleurs de cette vue.
     * @param controller Le contrôleur à ajouter
     */
    public void addController(SudokuController controller) {
        controllers.add(controller);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem = new JMenuItem("Retour au Menu");
        JMenuItem verifier = new JMenuItem("Vérifier");
        JMenuItem resoudre = new JMenuItem("Résoudre Sudoku");

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MenuView menuView = new MenuView();
                menuView.show();
            }
        });

        verifier.addActionListener(e -> {
            int[][] sudokuGridData = getSudokuGridData();
            VerifierModel verifierModel = new VerifierModel(sudokuGridData);
            if (verifierModel.verify()) {
                showMessage("La grille est correcte !");
            } else {
                showMessage("La grille contient des erreurs.");
            }
        });

        resoudre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolveSudoku();
            }
        });

        menu.add(menuItem);
        menu.add(verifier);
        menu.add(resoudre);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    private void resolveSudoku() {
        startTimer(); // Démarre le timer lorsque l'utilisateur lance la résolution automatique
        long startTime = System.nanoTime(); // Temps de départ

        int[][] sudokuGridData = this.getSudokuGridData();
        SudokuSolverModel solverModel = new SudokuSolverModel(sudokuGridData);
        if (solverModel.solve()) {
            long endTime = System.nanoTime(); // Temps d'arrêt
            long elapsedTime = endTime - startTime; // Temps écoulé en nanosecondes

            int[][] solvedGrid = solverModel.getGrid();
            updateSudokuGrid(solvedGrid);
            stopTimer(); // Arrête le timer après la résolution
            timerLabel.setText("Temps écoulé : " + elapsedTime + " ns"); // Met à jour le label du timer avec le temps écoulé
            showSuccessImage();
        } else {
            showMessage("Impossible de résoudre le Sudoku. Vérifiez la validité de la grille.");
        }
    }

    private void updateSudokuGrid(int[][] solvedGrid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField textField = gridTextFields[i][j];
                textField.setText(String.valueOf(solvedGrid[i][j]));
                textField.setEditable(false);
            }
        }
    }

    private void startTimer() {
        timerLabel.setText("Temps écoulé : "); // Initialiser avec une chaîne vide
    
        long startTime = System.nanoTime(); // Utilisation de System.nanoTime() pour une meilleure précision
    
        timer = new Timer(100, new ActionListener() { // Timer déclenche toutes les 100 millisecondes
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.nanoTime() - startTime;
                long milliseconds = elapsedTime / 1000000; // Convertir en millisecondes
                String timeString = String.valueOf(milliseconds) + " ms"; // Formatage pour inclure les millisecondes
                timerLabel.setText("Temps écoulé : " + timeString);
            }
        });
        timer.start();
    }

    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    private void showSuccessImage() {
        ImageIcon successIcon = new ImageIcon("shrek.png");
        Image img = successIcon.getImage();
        Image newImg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        JLabel successLabel = new JLabel(newIcon);
        JOptionPane.showMessageDialog(frame, successLabel, "Sudoku Résolu", JOptionPane.PLAIN_MESSAGE);
    }

    public void display() {
        frame.setVisible(true);
    }

    public JTextField[][] getGridTextFields() {
        return gridTextFields;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public int[][] getSudokuGridData() {
        int[][] gridData = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField textField = gridTextFields[i][j];
                String text = textField.getText();
                if (text.isEmpty()) {
                    gridData[i][j] = 0;
                } else {
                    gridData[i][j] = Integer.parseInt(text);
                }
            }
        }
        return gridData;
    }
}
