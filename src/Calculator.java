import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberBtn = new JButton[10]; // 0 -> 9
    JButton[] functionBtn = new JButton[8];
    JButton addBtn, subtractBtn, multiplyBtn, divideBtn, decimalBtn, equalBtn, deleteBtn, clearBtn;
    JPanel panel;
    Font myFont = new Font("Serif", Font.BOLD, 25);
    double num1=0, num2=0, result=0;
    char operator;
    Calculator () {
        frame = new JFrame("My 1st Calculator in Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false); // to prevent the user to edit the text box manually.

        addBtn = new JButton("+");
        subtractBtn = new JButton("-");
        multiplyBtn = new JButton("×");
        divideBtn = new JButton("÷");
        decimalBtn = new JButton(",");
        equalBtn = new JButton("=");
        deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");

        functionBtn[0] = addBtn;
        functionBtn[1] = subtractBtn;
        functionBtn[2] = multiplyBtn;
        functionBtn[3] = divideBtn;
        functionBtn[4] = decimalBtn;
        functionBtn[5] = equalBtn;
        functionBtn[6] = deleteBtn;
        functionBtn[7] = clearBtn;

        for (int i = 0; i < functionBtn.length; i++) {
            functionBtn[i].addActionListener(this);
            functionBtn[i].setFont(myFont);
            functionBtn[i].setFocusable(false);

        }

        for (int i = 0; i < numberBtn.length; i++) {
            numberBtn[i] = new JButton(String.valueOf(i));

            numberBtn[i].addActionListener(this);
            numberBtn[i].setFont(myFont);
            numberBtn[i].setFocusable(false);
        }

        deleteBtn.setBounds(40, 430, 140, 50);
        clearBtn.setBounds(250, 430, 140, 50);

        panel = new JPanel();
//        panel.setBounds();

        frame.add(deleteBtn);
        frame.add(clearBtn);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator Calculator = new Calculator();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}