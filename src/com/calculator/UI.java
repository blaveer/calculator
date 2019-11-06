package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 这个类中直画了UI，并没有实现任何功能函数，如果要查看功能函数，可以在calculatorEngine中声明*/
public class UI extends JFrame {
    public boolean hasDot=false;
    public boolean clickOperator=false;
    public boolean clickEqual=false;
    public JTextField input=new JTextField();

    public JButton Num0=new JButton("0");
    public JButton Num1=new JButton("1");
    public JButton Num2=new JButton("2");
    public JButton Num3=new JButton("3");
    public JButton Num4=new JButton("4");
    public JButton Num5=new JButton("5");
    public JButton Num6=new JButton("6");
    public JButton Num7=new JButton("7");
    public JButton Num8=new JButton("8");
    public JButton Num9=new JButton("9");

    public JButton operate_add=new JButton("+");
    public JButton operate_min=new JButton("-");
    public JButton operate_mul=new JButton("*");
    public JButton operate_div=new JButton("/");

    public JButton dot=new JButton(".");

    public JButton equal_sign=new JButton("=");

    public JPanel input_panel=new JPanel(null);
    public JPanel calculator=new JPanel(new GridLayout(4,4));

    public UI(String title){
        super(title);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setBounds(0,0,490,40);
        input_panel.add(input);
        input_panel.setBounds(0,0,490,40);
        add(input_panel);

        calculator.add(Num1);
        calculator.add(Num2);
        calculator.add(Num3);
        calculator.add(operate_add);
        calculator.add(Num4);
        calculator.add(Num5);
        calculator.add(Num6);
        calculator.add(operate_min);
        calculator.add(Num7);
        calculator.add(Num8);
        calculator.add(Num9);
        calculator.add(operate_mul);
        calculator.add(Num0);
        calculator.add(dot);
        calculator.add(equal_sign);
        calculator.add(operate_div);
        calculator.setBounds(0,40,500,320);
        add(calculator);

        this.setBounds(600, 300, 500, 400);
        this.setResizable(false);
        this.setVisible(true);
    }

    public String getInput(){
        try{
            return input.getText().trim();
        }catch (Exception ex){
            System.out.println("获取输入框的字串时候出错");
            return null;
        }
    }

}
