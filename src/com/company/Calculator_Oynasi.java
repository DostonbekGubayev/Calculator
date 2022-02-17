package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_Oynasi extends JFrame implements ActionListener {
    JButton functionButtons[]=new JButton[10];
    JButton numberButtons[]=new JButton[10];
    JButton subButton,mulButton,addButton,divButton,decButton,delButton,clrButton,equButton,minButton;
    JTextField textField;
    JPanel panel;
    Font myFont;
   double num1,num2,result;
    char amal;
    KlassForKeyboard klass;
    Operator_Klass operator=new Operator_Klass();

    public Calculator_Oynasi(){
        super("Calculator");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(297,310);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(Color.GRAY.darker());

       // klass=new KlassForKeyboard(this);

        myFont=new Font("Arial",Font.ITALIC,25);
        textField=new JTextField();
        textField.setBounds(10,10,266,30);
        add(textField);
        //Panel Number
        panel=new JPanel();
        panel.setLayout(new GridLayout(4,4,8,8));
        panel.setBounds(10,50,210,180);
        panel.setBackground(Color.DARK_GRAY);
        add(panel);
        //Row Function Buttons
        subButton=new JButton("-");
        subButton.setBounds(225,50,50,40);
        add(subButton);

        addButton=new JButton("+");
        addButton.setBounds(225,97,50,40);
        add(addButton);

        mulButton=new JButton("*");
        mulButton.setBounds(225,144,50,40);
        add(mulButton);

        divButton=new JButton("/");
        divButton.setBounds(225,190,50,40);
        add(divButton);
        decButton=new JButton(".");

        delButton=new JButton("Del");
        delButton.setBounds(83,235,86,35);
        add(delButton);

        clrButton=new JButton("Clr");
        clrButton.setBounds(174,235,105,35);
        add(clrButton);

        equButton=new JButton("=");
      minButton=new JButton("(-)");
      minButton.setBounds(10,235,65,35);
      minButton.addActionListener(this);
      add(minButton);


      operator.setBounds(310,20,100,90);
      operator.setVisible(false);
      add(operator);

        functionButtons[0]=subButton;
        functionButtons[1]=mulButton;
        functionButtons[2]=addButton;

        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=delButton;
        functionButtons[6]=clrButton;
        functionButtons[7]=equButton;
        functionButtons[8]=minButton;


        for (int j=0;j<9;j++){
            functionButtons[j].setFont(myFont);
            functionButtons[j].addActionListener(this);
            functionButtons[j].setFocusable(false);
            functionButtons[j].setBackground(Color.BLACK);
            functionButtons[j].setForeground(Color.ORANGE);

        }

        numberButtons[0]=new JButton("0");
     //   panel.add(numberButtons[0]);
                numberButtons[0].setFont(myFont);
        numberButtons[0].setBackground(Color.BLACK);
        numberButtons[0].setForeground(Color.ORANGE);
        numberButtons[0].addActionListener(this);

        for (int i=1;i<numberButtons.length;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setForeground(Color.ORANGE);
            numberButtons[i].addActionListener(this::actionPerformed);

            panel.add(numberButtons[i]);
            panel.add(equButton);
            panel.add(decButton);
            panel.add(numberButtons[0]);

        }

    }

    @Override
    public void actionPerformed(ActionEvent hodisa) {
        for (int i=0;i<10;i++){
            if (hodisa.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(hodisa.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (hodisa.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            amal='+';
            textField.setText(textField.getText());
        }
        if (hodisa.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            amal='-';
            textField.setText("");
        }
        if (hodisa.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            amal='*';
            textField.setText("");
        }
        if (hodisa.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            amal='/';
            textField.setText("");
        }

        if (hodisa.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());


            switch (amal){
                case '+': result=num1+num2;
                break;
                case '-': result=num1-num2;
                    break;
                case '*': result=num1*num2;
                    break;
                case '/': result=num1/num2;
                    break;
                case '^':result=Math.sqrt(num1);
            }
            textField.setText(Double.toString(result));
            num1=result;
        }
        if (hodisa.getSource()==clrButton){
            textField.setText("");
        }
        if (hodisa.getSource()==delButton){
            String qator=textField.getText();
            textField.setText("");
            for (int i=0;i<qator.length()-1;i++){
                textField.setText(textField.getText()+qator.charAt(i));
            }
            if (hodisa.getSource()==minButton){
                int temp=Integer.parseInt(textField.getText());
                textField.setText("");
                num1*=temp;
                num2*=temp;
                temp*=(-1);

                textField.setText(Integer.toString(temp));

            }

        }
    }

}
