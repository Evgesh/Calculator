
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonListener implements ActionListener{
    
    private JPanel panel;
    
    public ButtonListener (JPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        JOptionPane.showConfirmDialog(panel, "Test!");
    }
    
}
