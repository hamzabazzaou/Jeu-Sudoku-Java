import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame; 

public class VerifierController implements ActionListener {
    private VerifierModel model;
    private VerifierView view;

    public VerifierController(VerifierModel model, VerifierView view) {
        this.model = model;
        this.view = view;
        view.getVerifierButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == view.getVerifierButton()) {
            if (model.verify()) {
                JOptionPane.showMessageDialog((JFrame)view.getVerifierButton().getTopLevelAncestor(), "Grille valide !");
            } else {
                JOptionPane.showMessageDialog((JFrame)view.getVerifierButton().getTopLevelAncestor(), "Grille invalide !");
            }
        }
    }
}
