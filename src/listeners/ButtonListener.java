
package listeners;

import calculator.Operations;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ButtonListener implements ActionListener{
    
    private final JTextField fieldNumber1;
    private final JTextField fieldNumber2;
    private final JTextField fieldResult;
    private String s1, s2;
    private double number1, number2;

    public ButtonListener(JTextField fieldNumber1, JTextField fieldNumber2, JTextField fieldResult) {
        this.fieldNumber1 = fieldNumber1;
        this.fieldNumber2 = fieldNumber2;
        this.fieldResult = fieldResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(e.getSource() instanceof JButton)){
            return;
        }
        JButton button = (JButton)e.getSource();
        if(button.getActionCommand().equals("Сброс")){
            clearFields();
            return;
        }
        s1 = fieldNumber1.getText();
        s2 = fieldNumber2.getText();
        if(checkNumbers(s1, s2)){
            number1 = Double.parseDouble(fieldNumber1.getText());
            number2 = Double.parseDouble(fieldNumber2.getText());
        } else {
            JOptionPane.showMessageDialog(fieldNumber1, "Проверьте введенные числа.\nРазделитель - запятая");
            clearFields();
            return;
        }
        
        
        if(button.getActionCommand().equals("Сложение")){
            fieldResult.setText(String.valueOf(Operations.add(number1, number2)));
        }else if(button.getActionCommand().equals("Вычитание")){
            fieldResult.setText(String.valueOf(Operations.subtract(number1, number2)));
        }else if(button.getActionCommand().equals("Деление")){
            fieldResult.setText(String.valueOf(Operations.divade(number1, number2)));
        }else if (button.getActionCommand().equals("Умножение")){
            fieldResult.setText(String.valueOf(Operations.multiply(number1, number2)));
        }else if(button.getActionCommand().equals("Сброс")){
            clearFields();
        }
    }
    private boolean checkNumbers(String a, String b){
        return !a.equals(calculator.Calculator.INITIAL_VALUE)
            && a.matches("([0-9]*)?\\.?([0-9]*)")
            && !b.equals(calculator.Calculator.INITIAL_VALUE)
            && b.matches("([0-9]*)?\\.?([0-9]*)");
    }
    private void clearFields(){
        fieldNumber1.setText(calculator.Calculator.INITIAL_VALUE);
            fieldNumber1.setForeground(Color.GRAY);
            fieldNumber2.setText(calculator.Calculator.INITIAL_VALUE);
            fieldNumber2.setForeground(Color.GRAY);
            fieldResult.setText("");
    }
}
