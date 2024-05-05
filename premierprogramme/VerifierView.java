import javax.swing.*;

public class VerifierView {
    private JFrame frame;
    private JButton verifierButton;

    public VerifierView() {
        frame = new JFrame("Vérifier Sudoku");
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        verifierButton = new JButton("Vérifier");
        frame.add(verifierButton);
    }

    public void show() {
        frame.setVisible(true);
    }

    public JButton getVerifierButton() {
        return verifierButton;
    }
}