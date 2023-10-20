import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
    
    private static JButton addButton;
    private static JButton subButton;
    private static JButton mulButton;
    private static JButton summary;
    private static JButton divButton;
    private static JButton sqrtButton;
    private static JButton powButton;
    private static JButton clear;
    private static JButton floatingPoint;
    private static JButton zeroButton;
    private static JButton oneButton;
    private static JButton twoButton;
    private static JButton threeButton;
    private static JButton fourButton;
    private static JButton fiveButton;
    private static JButton sixButton;
    private static JButton sevenButton;
    private static JButton eightButton;
    private static JButton nineButton;
    private static JLabel sumLabel;
    private static Double currentNumber = 0.0;
    private static Double prevNumber = 0.0;
    private static Double sum = 0.0;
    private static String str;
    private static int mode;

    public Calculator(){

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(270, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        frame.setTitle("Calculator");
        panel.setLayout(null);

        zeroButton = new JButton("0");
        zeroButton.setBounds(10, 170, 50, 25);
        zeroButton.addActionListener(this);

        oneButton = new JButton("1");
        oneButton.setBounds(10, 140, 50, 25);
        oneButton.addActionListener(this);

        twoButton = new JButton("2");
        twoButton.setBounds(70, 140, 50, 25);
        twoButton.addActionListener(this);

        threeButton = new JButton("3");
        threeButton.setBounds(130, 140, 50, 25);
        threeButton.addActionListener(this);

        fourButton = new JButton("4");
        fourButton.setBounds(10, 110, 50, 25);
        fourButton.addActionListener(this);

        fiveButton = new JButton("5");
        fiveButton.setBounds(70, 110, 50, 25);
        fiveButton.addActionListener(this);

        sixButton = new JButton("6");
        sixButton.setBounds(130, 110, 50, 25);
        sixButton.addActionListener(this);

        sevenButton = new JButton("7");
        sevenButton.setBounds(10, 80, 50, 25);
        sevenButton.addActionListener(this);

        eightButton = new JButton("8");
        eightButton.setBounds(70, 80, 50, 25);
        eightButton.addActionListener(this);

        nineButton = new JButton("9");
        nineButton.setBounds(130, 80, 50, 25);
        nineButton.addActionListener(this);

        clear = new JButton("C");
        clear.setBounds(10, 50, 50, 25);
        clear.addActionListener(e -> {
            sumLabel.setText("");
            prevNumber = 0.0;
            currentNumber = 0.0;
        });

        addButton = new JButton("+");
        addButton.setBounds(190, 110, 50, 25);
        addButton.addActionListener(e -> {
            try{
                prevNumber = Double.parseDouble(sumLabel.getText());
            } catch(Exception exc){}
            sumLabel.setText("+");
            currentNumber = 0.0;
            mode = 0;
        });

        subButton = new JButton("-");
        subButton.setBounds(190, 80, 50, 25);
        subButton.addActionListener(e -> {
            try{
                prevNumber = Double.parseDouble(sumLabel.getText());
            } catch(Exception exc){}
            sumLabel.setText("-");
            currentNumber = 0.0;
            mode = 1;
        });

        mulButton = new JButton("*");
        mulButton.setBounds(190, 50, 50, 25);
        mulButton.addActionListener(e -> {
            try{
                prevNumber = Double.parseDouble(sumLabel.getText());
            } catch(Exception exc){}
            sumLabel.setText("*");
            currentNumber = 0.0;
            mode = 2;
        });

        divButton = new JButton("/");
        divButton.setBounds(130, 170, 50, 25);
        divButton.addActionListener(e -> {
            try{
                prevNumber = Double.parseDouble(sumLabel.getText());
            } catch(Exception exc){}
            sumLabel.setText("/");
            currentNumber = 0.0;
            mode = 3;
        });

        sqrtButton = new JButton("√");
        sqrtButton.setBounds(70, 50, 50, 25);
        sqrtButton.addActionListener(e -> {
            try{
                currentNumber = Double.parseDouble(sumLabel.getText());
            } catch(Exception exc){}
            sumLabel.setText(Double.toString(Math.sqrt(currentNumber)));
            if(currentNumber<0){                                                                                        
                sumLabel.setText("Error");
                currentNumber = 0.0;
                prevNumber = 0.0;
            }
            else{
                currentNumber = Math.sqrt(currentNumber);
                mode = 4;
            }
        });

        powButton = new JButton("^");
        powButton.setBounds(130, 50, 50, 25);
        powButton.addActionListener(e -> {
            try{
                prevNumber = Double.parseDouble(sumLabel.getText());
            } catch(Exception exc){}
            sumLabel.setText("^");
            currentNumber = 0.0;
            mode = 5;
        });

        floatingPoint = new JButton(".");
        floatingPoint.setBounds(70, 170, 50, 25);
        floatingPoint.addActionListener(e -> {
            sumLabel.setText(sumLabel.getText()+".");
        });

        summary = new JButton("=");
        summary.setBounds(190, 140, 50, 55);
        summary.addActionListener(e -> {
            try{
                currentNumber = Double.parseDouble(sumLabel.getText());
            } catch (Exception exc){
                switch(mode){
                    case 0, 1 -> {currentNumber = 0.0;}
                    case 2,3,5 -> {currentNumber = 1.0;}
                }
            }
            switch (mode) {
                case 0 -> {
                    sum = prevNumber + currentNumber;
                }
                case 1 -> {
                    sum = prevNumber - currentNumber;
                }
                case 2 -> {
                    sum = prevNumber * currentNumber;
                }
                case 3 -> {
                    sum = prevNumber / currentNumber;
                }
                case 4 -> {
                    sum = Math.sqrt(prevNumber);
                }
                case 5 -> {
                    sum = Math.pow(prevNumber, currentNumber);
                }
            }
            currentNumber = sum;
            str = Double.toString(sum);
            if(str.equals("Infinity")){
                str = "Error";
                prevNumber = 0.0;
                currentNumber = 0.0;
            }
            sumLabel.setText(str);
        });

        panel.add(addButton);
        panel.add(summary);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(sqrtButton);
        panel.add(powButton);
        panel.add(clear);
        panel.add(floatingPoint);
        panel.add(zeroButton);
        panel.add(oneButton);
        panel.add(twoButton);
        panel.add(threeButton);
        panel.add(fourButton);
        panel.add(fiveButton);
        panel.add(sixButton);
        panel.add(sevenButton);
        panel.add(eightButton);
        panel.add(nineButton);

        sumLabel = new JLabel("");
        sumLabel.setBounds(15, 10, 300, 25);
        sumLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(sumLabel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Double.parseDouble(sumLabel.getText());
        } catch(Exception exc){
            sumLabel.setText("");
        }
        if(e.getSource()==zeroButton){
            sumLabel.setText(sumLabel.getText()+"0");
        }   
        else if(e.getSource()==oneButton){
            sumLabel.setText(sumLabel.getText()+"1");
        } 
        else if(e.getSource()==twoButton){
            sumLabel.setText(sumLabel.getText()+"2");    
        } 
        else if(e.getSource()==threeButton){
            sumLabel.setText(sumLabel.getText()+"3");    
        } 
        else if(e.getSource()==fourButton){
            sumLabel.setText(sumLabel.getText()+"4");    
        } 
        else if(e.getSource()==fiveButton){
            sumLabel.setText(sumLabel.getText()+"5");    
        } 
        else if(e.getSource()==sixButton){
            sumLabel.setText(sumLabel.getText()+"6");    
        } 
        else if(e.getSource()==sevenButton){
            sumLabel.setText(sumLabel.getText()+"7");    
        } 
        else if(e.getSource()==eightButton){
            sumLabel.setText(sumLabel.getText()+"8");    
        } 
        else{
            sumLabel.setText(sumLabel.getText()+"9");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
