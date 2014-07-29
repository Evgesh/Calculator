package calculator;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import listeners.ButtonListener;
import listeners.TextFieldListener;


public class Calculator {
    
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JLabel labelNumber1, labelNumber2, labelResult;
    private JTextField fieldNumber1, fieldNumber2, fieldResult;
    private JButton addButton;
    private JButton subtractButton;
    private JButton divadeButton;
    private JButton multiplyButton;
    private JButton resetButton;  
    private JButton saveResults; //not ready
    private JFrame myFrame;
    
    public static final String INITIAL_VALUE = "Введите число";

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AeroLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        Calculator calculator = new Calculator();
        
        calculator.createLabels();
        calculator.createTextFields();
        calculator.createButton();
        calculator.createPanel();
        calculator.createFrame();
    }
    
    private void createButton() {
        
        addButton = new JButton("Сложение");
        subtractButton = new JButton("Вычитание");
        divadeButton = new JButton("Деление");
        multiplyButton = new JButton("Умножение");
        resetButton = new JButton("Сброс");
        
        addButtonListener();
    }
    
    private void createLabels() {
        labelNumber1 = new JLabel("Число 1");
        labelNumber2 = new JLabel("Число 2");
        labelResult = new JLabel("Результат");
    }
    
    private void createTextFields() {
        fieldNumber1 = new JTextField(INITIAL_VALUE, 15);
        fieldNumber1.setForeground(Color.GRAY);
        fieldNumber2 = new JTextField(INITIAL_VALUE, 15);
        fieldNumber2.setForeground(Color.GRAY);
        
        fieldResult = new JTextField(15);
        fieldResult.setEditable(false);
        fieldResult.setFocusable(false);
        
        addTextFieldListener();
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
        
        panel4 = new JPanel(new GridLayout(2, 2, 1, 1));
        panel4.add(addButton);
        panel4.add(subtractButton);
        panel4.add(divadeButton);
        panel4.add(multiplyButton);        
        
        panel5 = new JPanel(new GridLayout(2, 2, 1, 1));
        panel5.add(resetButton);
        
    }
    
    private void createFrame() {
        
        JFrame frame = new JFrame("Calculator");
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
    
    private void addButtonListener(){
        ButtonListener buttonListener = new ButtonListener(fieldNumber1, fieldNumber2, fieldResult);
        
        subtractButton.addActionListener(buttonListener);
        addButton.addActionListener(buttonListener);
        divadeButton.addActionListener(buttonListener);
        multiplyButton.addActionListener(buttonListener);
        resetButton.addActionListener(buttonListener);
    }
    
    private void addTextFieldListener(){
        fieldNumber1.addFocusListener(new TextFieldListener(fieldNumber1));
        fieldNumber2.addFocusListener(new TextFieldListener(fieldNumber2));
    }
}
