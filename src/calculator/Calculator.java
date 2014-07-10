

package calculator;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import listeners.ButtonListener;


public class Calculator {
    
    private JPanel panel1, panel2, panel3, panel4, panel5;
        
    private JLabel labelNumber1, labelNumber2, labelResult;
    private JTextField fieldNumber1, fieldNumber2, fieldResult;
    
    private JButton addButton;
    private JButton subtractButton;
    private JButton divadeButton;
    private JButton multiplyButton;
    private JButton resultButton;
    
    private JFrame myFrame;
    
    private ButtonListener listener;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AeroLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        Calculator calculator = new Calculator();
        calculator.createButton();
        calculator.createLabels();
        calculator.createTextFields();
        calculator.createPanel();
        calculator.createFrame();
    }
    private void createButton() {
        
        addButton = new JButton("Сложение");
        subtractButton = new JButton("Вычитание");
        divadeButton = new JButton("Деление");
        multiplyButton = new JButton("Умножение");
        resultButton = new JButton("Результат");
    }
    private void createLabels() {
        labelNumber1 = new JLabel("Число 1");
        labelNumber2 = new JLabel("Число 2");
        labelResult = new JLabel("Результат");
    }
    private void createTextFields() {
        fieldNumber1 = new JTextField(15);
        
        fieldNumber2 = new JTextField(15);
        
        fieldResult = new JTextField(15);
        fieldResult.setEditable(false);
        fieldResult.setFocusable(false);
    }
    private void createPanel() {
        
        panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                
        panel1.add(labelNumber1);
        panel1.add(fieldNumber1);
        
        panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        panel2.add(labelNumber2);
        panel2.add(fieldNumber2);
        
        panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        panel3.add(labelResult);
        panel3.add(fieldResult);
        
        listener = new ButtonListener(panel4);
        panel4 = new JPanel(new GridLayout(2, 2, 1, 1));
        panel4.add(addButton);
        addButton.addActionListener(listener);
        panel4.add(subtractButton);
        subtractButton.addActionListener(listener);
        panel4.add(divadeButton);
        divadeButton.addActionListener(listener);
        panel4.add(multiplyButton);
        multiplyButton.addActionListener(listener);
        
        
        panel5 = new JPanel(new GridLayout(1, 2, 1, 1));
        panel5.add(resultButton);
        
    }
    private void createFrame() {
        
        JFrame frame = new JFrame("Калькулятор");
        frame.setIconImage(new ImageIcon("c:\\MyJava\\apple.png").getImage());
        frame.setSize(250, 300);
        GridLayout gl1 = new GridLayout(5, 1, 3, 3);
        frame.setLayout(gl1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(250, 350));
        frame.setResizable(false);
        
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(panel3);
        frame.getContentPane().add(panel4);
        frame.getContentPane().add(panel5);
        
        
        frame.setVisible(true);
    }
}
