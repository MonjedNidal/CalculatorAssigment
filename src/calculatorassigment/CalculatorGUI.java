
package calculatorassigment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements ActionListener{
    JFrame frame = new JFrame("");
    JButton backspace,clear,inv,dot,add,sub,mul,div,equal;
    JButton zero,one,two,three,four,five,six,seven,eight,nine;
    JLabel resultLabel = new JLabel("");

    double num1,num2;
    char operation;
    CalculatorGUI(){

        resultLabel.setPreferredSize(new Dimension(90,50));
        resultLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // outer border
                BorderFactory.createLoweredBevelBorder()));

        backspace = new JButton("⬅");
        clear = new JButton("C");
        inv = new JButton("±");
        dot = new JButton(".");
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        equal = new JButton("=");

        backspace.addActionListener(this);
        clear.addActionListener(this);
        inv.addActionListener(this);
        dot.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        equal.addActionListener(this);

        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(4,5,5,10));

        p1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // outer border
                BorderFactory.createLoweredBevelBorder()));

        p1.add(backspace);
        p1.add(clear);
        p1.add(inv);
        p1.add(dot);
        p1.add(add);
        p1.add(zero);
        p1.add(one);
        p1.add(two);
        p1.add(three);
        p1.add(sub);
        p1.add(four);
        p1.add(five);
        p1.add(six);
        p1.add(seven);
        p1.add(mul);
        p1.add(eight);
        p1.add(nine);
        p1.add(equal);
        p1.add(div);


        frame.add(resultLabel,BorderLayout.NORTH);
        frame.add(p1,BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290,250);
        frame.setLocationRelativeTo(null);
        frame.setFont(new Font("Verdana", Font.PLAIN, 18));
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Object clickedButton = e.getSource();
            ifNumber(clickedButton);
            ifOperation(clickedButton);
        }catch (Exception exception){
            System.out.print(exception.getMessage());
        }

    }

    private void ifOperation(Object clickedButton) {
        if (clickedButton == backspace){
            try{
                StringBuilder sb= new StringBuilder(resultLabel.getText());
                sb.deleteCharAt(sb.length()-1);

                resultLabel.setText(String.valueOf(sb));
            }catch (Exception e){
                JOptionPane.showMessageDialog(resultLabel,"Invalid Input!");
            }

        }else if (clickedButton == clear){
            resultLabel.setText("");
        }else if (clickedButton == inv){
            double num = Double.parseDouble(resultLabel.getText());
            num *= -1;
            resultLabel.setText(String.valueOf(num));
        }else if (clickedButton == dot){
            resultLabel.setText(resultLabel.getText()+".");
        }else if (clickedButton == add){
            if (resultLabel.getText() != null){
                num1 = Double.parseDouble(resultLabel.getText());
                operation = '+';
                resultLabel.setText("");
            }
        }else if (clickedButton == sub){
            if (resultLabel.getText() != null){
                num1 = Double.parseDouble(resultLabel.getText());
                operation = '-';
                resultLabel.setText("");
            }
        }else if (clickedButton == mul){
            if (resultLabel.getText() != null){
                num1 = Double.parseDouble(resultLabel.getText());
                operation = '*';
                resultLabel.setText("");
            }
        }else if (clickedButton == div){
            if (resultLabel.getText() != null && !resultLabel.getText().equals("0")){
                num1 = Double.parseDouble(resultLabel.getText());
                operation = '/';
                resultLabel.setText("");
            }
        }else if (clickedButton == equal){
            calcAnswer();
        }
    }

    private void calcAnswer() {
        try{
            num2 = Double.parseDouble(resultLabel.getText());
            double res;
            switch (operation){
                case '+':
                    res = num1+num2;
                    resultLabel.setText(String.valueOf(res));
                    break;
                case '-':
                    resultLabel.setText(String.valueOf(num1-num2));
                    break;
                case '*':
                    resultLabel.setText(String.valueOf(num1*num2));
                    break;
                case '/':
                    resultLabel.setText(String.valueOf(num1/num2));
                    break;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(resultLabel,"Invalid Input!");
        }

    }

    private void ifNumber(Object clickedButton) {
        if (clickedButton == zero){
            resultLabel.setText(resultLabel.getText()+"0");
        }else if (clickedButton == one){
            resultLabel.setText(resultLabel.getText()+"1");
        }else if (clickedButton == two){
            resultLabel.setText(resultLabel.getText()+"2");
        }else if (clickedButton == three){
            resultLabel.setText(resultLabel.getText()+"3");
        }else if (clickedButton == four){
            resultLabel.setText(resultLabel.getText()+"4");
        }else if (clickedButton == five){
            resultLabel.setText(resultLabel.getText()+"5");
        }else if (clickedButton == six){
            resultLabel.setText(resultLabel.getText()+"6");
        }else if (clickedButton == seven){
            resultLabel.setText(resultLabel.getText()+"7");
        }else if (clickedButton == eight){
            resultLabel.setText(resultLabel.getText()+"8");
        }else if (clickedButton == nine){
            resultLabel.setText(resultLabel.getText()+"9");
        }
    }
}
