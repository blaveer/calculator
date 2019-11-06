package com.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 继承自UI类
 * 如果要开始只要在主函数中声明一个这个类的实例就行，像下面这样
 * calculatorEngine calculatorEngine=new calculatorEngine("Calculator-CopyRight刘钰鸿 学号18301049");
 * 所有的组件的函数处理和算术代码都在这个类中
 * */
public class calculatorEngine extends UI{
    public calculatorEngine(String title){
        super(title);
        //region 添加数字键的点击事件
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hasDot){
                    System.out.println("已经有小数点了");
                }
                else{
                    input.setText(input.getText()+".");
                    hasDot=true;
                }
            }
        });
        Num0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("0");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"0");
                }
            }
        });
        Num1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("1");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"1");
                }
            }
        });
        Num2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("2");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"2");
                }
            }
        });
        Num3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("3");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"3");
                }
            }
        });
        Num4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("4");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"4");
                }
            }
        });
        Num5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("5");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"5");
                }
            }
        });
        Num6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickEqual) {
                    input.setText("6");
                    clickEqual=false;
                } else {
                    input.setText(input.getText() + "6");
                }
            }
        });
        Num7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clickEqual) {
                    input.setText("7");
                    clickEqual=false;
                } else {
                    input.setText(input.getText() + "7");
                }
            }
        });
        Num8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("8");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"8");
                }
            }
        });
        Num9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickEqual){
                    input.setText("9");
                    clickEqual=false;
                }else{
                    input.setText(input.getText()+"9");
                }
            }
        });
        //endregion
        //region  运算符的点击事件
        operate_mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOperator){
                    ShowDialog();
                }
                else {
                    setEnteredNumber(input.getText());
                    setSelectedAction("*");
                    input.setText("");
                    hasDot = false;
                    clickOperator=true;
                }
            }
        });
        operate_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOperator){
                    ShowDialog();
                }
                else {
                    setEnteredNumber(input.getText());
                    setSelectedAction("/");
                    input.setText("");
                    hasDot = false;
                    clickOperator=true;
                }
            }
        });
        operate_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOperator){
                    ShowDialog();
                }
                else {
                    setEnteredNumber(input.getText());
                    setSelectedAction("+");
                    input.setText("");
                    hasDot = false;
                    clickOperator=true;
                }
            }
        });
        operate_min.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOperator){
                    ShowDialog();
                }
                else {
                    setEnteredNumber(input.getText());
                    setSelectedAction("-");
                    input.setText("");
                    hasDot = false;
                    clickOperator=true;
                }
            }
        });
        equal_sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickOperator){
                    clickOperator=false;
                    hasDot=false;
                    setCurrentNumber(input.getText());
                    input.setText(String.valueOf(getResult()));
                    clickEqual=true;
                }
                else {

                }
            }
        });
        //endregion
    }
    public boolean dot_visible=true;
    private double currentNumber=0;  //第二个运算数
    private double enteredNumber=0;    //第一个运算数
    public String selectedAction="";

    public void setSelectedAction(String selectedAction) {
        this.selectedAction = selectedAction;
    }

    public void setEnteredNumber(String enteredNumber) {
        try{
            this.enteredNumber = Double.valueOf(enteredNumber.trim());
        }catch (Exception ex){
            System.out.println("输入有误");
        }
    }


    public void setCurrentNumber(String currentNumber) {
        try {
            this.currentNumber = Double.valueOf(currentNumber.trim());
        }catch (Exception ex){
            System.out.println("输入有误");
        }
    }

    public double getResult(){
        double result;
        switch (selectedAction){
            case "+":
                result=enteredNumber+currentNumber;
                break;
            case "-":
                result=enteredNumber-currentNumber;
                break;
            case "*":
                result=enteredNumber*currentNumber;
                break;
            case "/":
                try {
                    result = enteredNumber / currentNumber;
                }catch (Exception ex){
                    System.out.println("发生除零错误");
                    result=0;
                }
                break;
            default:
                result=0;
                break;
        }
        dot_visible=true;
        return result;
    }

    /**当已经输入两个算数的时候，再点击运算符输入第三个运算数就会弹窗提示该点等号了*/
    private void ShowDialog(){
        JOptionPane.showMessageDialog(this, "您已经输入两个运算数了，请点击等号", "提示",JOptionPane.WARNING_MESSAGE);
    }
}
