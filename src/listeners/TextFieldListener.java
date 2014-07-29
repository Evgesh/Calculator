
package listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class TextFieldListener implements FocusListener{
    private JTextField field;
    
    public TextFieldListener(JTextField field){
        this.field = field;
    }
    @Override
    public void focusGained(FocusEvent e) {
        if(field.getText().equals(calculator.Calculator.INITIAL_VALUE)){
            field.setText("");
            field.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(field.getText().trim().equals("")){
            field.setText(calculator.Calculator.INITIAL_VALUE);
            field.setForeground(Color.GRAY);
        }
    }
    
}
