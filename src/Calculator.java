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
    Font myFont = new Font("Serif", Font.BOLD, 20);
    double num1=0, num2=0, result=0;
    Character operator = 'x';
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

        for (JButton jButton : functionBtn) {
            jButton.addActionListener(this);
            jButton.setFont(myFont);
            jButton.setFocusable(false);

        }

        for (int i = 0; i < numberBtn.length; i++) {
            numberBtn[i] = new JButton(String.valueOf(i));

            numberBtn[i].addActionListener(this);
            numberBtn[i].setFont(myFont);
            numberBtn[i].setFocusable(false);
        }

        deleteBtn.setBounds(50, 430, 140, 50);
        clearBtn.setBounds(210, 430, 140, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4, 10, 10));
        panel.add(numberBtn[7]);
        panel.add(numberBtn[8]);
        panel.add(numberBtn[9]);
        panel.add(addBtn);
        panel.add(numberBtn[4]);
        panel.add(numberBtn[5]);
        panel.add(numberBtn[6]);
        panel.add(subtractBtn);
        panel.add(numberBtn[1]);
        panel.add(numberBtn[2]);
        panel.add(numberBtn[3]);
        panel.add(multiplyBtn);
        panel.add(decimalBtn);
        panel.add(numberBtn[0]);
        panel.add(equalBtn);
        panel.add(divideBtn);

        frame.add(panel);
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
        for (int i = 0; i < numberBtn.length; i++) {
            if (e.getSource() == numberBtn[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decimalBtn) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addBtn) {
            setOperator('+');
        }
        if (e.getSource() == subtractBtn) {
            setOperator('-');
        }
        if (e.getSource() == multiplyBtn) {
            setOperator('*');
        }
        if (e.getSource() == divideBtn) {
            setOperator('/');
        }
        if (e.getSource() == equalBtn) {
            num2 = !textField.getText().isEmpty() ?  Double.parseDouble(textField.getText()) : 0;
            boolean isEmpty = false;
            System.out.println(operator);
            switch (operator) {
                case '-' -> result=num1-num2;
                case '+' -> result=num1+num2;
                case '*' -> result=num1*num2;
                case '/' -> result=num1/num2;
                default -> isEmpty=true;
            }
            if (isEmpty ) {
                result = 0;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == deleteBtn) {
            StringBuilder currentValue = new StringBuilder(textField.getText());
            if (!textField.getText().isEmpty()) {
            currentValue.delete(currentValue.length()-1, currentValue.length());
            textField.setText(String.valueOf(currentValue));
            }
            System.out.println(textField.getText());
        }
        if (e.getSource() == clearBtn) {
            textField.setText("");
        }
    }

    public void setOperator(char operator) {
        num1 = !textField.getText().isEmpty() ? Double.parseDouble(textField.getText()) : 0;
        this.operator = !textField.getText().isEmpty() ? operator : 'x';
        textField.setText("");
    }
}