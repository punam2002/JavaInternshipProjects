package com.PentagonSpace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ScientificCalc extends JFrame implements ActionListener {
    JTextField JTF1 = new JTextField(20);
    JTextField JTF2 = new JTextField(20);
    JTextField JTF3 = new JTextField(20);
    JPanel Jp1=new JPanel();
    JPanel Jp2 = new JPanel();
    JButton Ac = new JButton("AC");
    JButton pi = new JButton("PI");
    JButton sq = new JButton("Sq");
    JButton mod = new JButton("%");
    JButton back = new JButton("<-");
    JButton sin = new JButton("sin");
    JButton bt1 = new JButton("1");
    JButton bt2 = new JButton("2");
    JButton bt3 = new JButton("3");
    JButton add = new JButton("+");
    JButton cos = new JButton("cos");
    JButton bt4 = new JButton("4");
    JButton bt5 = new JButton("5");
    JButton bt6 = new JButton("6");
    JButton sub = new JButton("-");
    JButton tan = new JButton("tan");
    JButton bt7 = new JButton("7");
    JButton bt8 = new JButton("8");
    JButton bt9 = new JButton("9");
    JButton mul = new JButton("*");
    JButton cube = new JButton("cube");
    JButton dot = new JButton(".");
    JButton bt0 = new JButton("0");
    JButton equal = new JButton("=");
    JButton div = new JButton("/");
    JButton[] btnArr = {Ac, pi, sq, mod, back, sin, bt1, bt2, bt3, add, cos, bt4, bt5, bt6, sub, tan, bt7, bt8, bt9, mul, cube, dot, bt0, equal, div};


    ScientificCalc() {
        setBounds(200, 200, 400, 400);
        setTitle("Scientific Calculator");

        JTF1.setSize(400, 100);
        JTF1.setEditable(false);
        JTF1.setText("");
        JTF2.setEditable(false);
        JTF2.setText("");
        JTF3.setEditable(false);
        JTF3.setText("");

        JTF3.setBorder(null);
        JTF2.setBorder(null);
        JTF1.setBorder(null);

        JTF1.setBackground(new Color(255, 125, 178));
        JTF2.setBackground(new Color(255, 125, 178));
        JTF3.setBackground(new Color(255, 125, 178));


        Jp1.setSize(200, 200);
        Jp1.setFont(new Font("Arial", Font.BOLD, 100));
        Jp1.setBackground(new Color(62, 20, 54));
        Jp1.setLayout(new GridLayout(5, 5, 10, 10));
        for (int i = 0; i < 25; i++) {
            Jp1.add(btnArr[i]);
            btnArr[i].addActionListener(this);
        }
         Jp2.setLayout(new GridLayout(3,1));
        Jp2.add(JTF1);
        Jp2.add(JTF2);
        Jp2.add(JTF3);

        add(Jp2, "North");
        add(Jp1, "Center");


    }

    public static void main(String[] args) {
        ScientificCalc SCalc = new ScientificCalc();
        SCalc.setVisible(true);
        SCalc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String S2 = e.getActionCommand();
        if (S2.equals("PI")) {
            double valPi=Math.PI;
            JTF1.setText(JTF1.getText()+ valPi);
        }
        else if (S2.equals("AC")) {
            JTF1.setText("");
        }
        else if(S2.equals("<-")){
            String St = JTF1.getText();
            String res="";
            for(int i=0;i<St.length()-1;i++){
                res=res+String.valueOf(St.charAt(i));
            }
            JTF1.setText(res);
        }
        else if(S2.equals("sin")){
            JTF1.setText(JTF1.getText()+"sin");
        }
        else if(S2.equals("cos")){
            JTF1.setText(JTF1.getText()+"cos");
        }
        else if(S2.equals("tan")){
            JTF1.setText(JTF1.getText()+"tan");
        }
        else if(S2.equals("+")){

            JTF1.setText(JTF1.getText()+"+");
        }
        else if(S2.equals("-")){

            JTF1.setText(JTF1.getText()+"-");
        }
        else if(S2.equals("*")){

            JTF1.setText(JTF1.getText()+"*");
        }
        else if(S2.equals("/")){

            JTF1.setText(JTF1.getText()+"/");
        }
        else if(S2.equals("%")){

            JTF1.setText(JTF1.getText()+"%");
        }
        else if(S2.equals("=")){
            String St = JTF1.getText();
            String st1="";
            double sinVal, cosVal, tanVal;
            if(St.contains("sin")){
                for(int i=3;i<=St.length()-1;i++){
                   st1=st1+St.charAt(i);
                }
                System.out.println(st1);

                sinVal=Math.sin(Math.toRadians(Double.parseDouble(st1)));
                JTF1.setText(String.valueOf(sinVal));
            }
            if(St.contains("cos")){
                for(int i=3;i<=St.length()-1;i++){
                    st1=st1+St.charAt(i);
                }
                System.out.println(st1);

                cosVal=Math.cos(Math.toRadians(Double.parseDouble(st1)));
                JTF1.setText(String.valueOf(cosVal));
            }
            if(St.contains("tan")){
                for(int i=3;i<=St.length()-1;i++){
                    st1=st1+St.charAt(i);
                }
                System.out.println(st1);

                tanVal=Math.tan(Math.toRadians(Double.parseDouble(st1)));
                JTF1.setText(String.valueOf(tanVal));
            }
            char opp=' ';
            for(int i=0;i<=St.length()-1;i++){
                if (St.charAt(i) == '+'||St.charAt(i) == '-'||St.charAt(i) == '*'||St.charAt(i) == '/'||St.charAt(i) == '%') {
                    opp=St.charAt(i);
                }
            }
            if(opp=='+') {
                String St1 = JTF1.getText();
                String num = "";
                double num1 = 0.0;
                for (int i = 0; i <= St1.length() - 1; i++) {
                    while (i <= St1.length() - 1 && St1.charAt(i) != '+') {
                        num = num + St1.charAt(i);
                        i++;
                    }
                    num1 = num1 + Double.parseDouble(num);
                    num = "";
                }
                JTF1.setText(String.valueOf(num1));
            }
            else if(opp=='-') {
                String St1 = JTF1.getText();
                String num = "";
                double num1 = 0;
                for (int i = 0; i <= St1.length() - 1; i++) {
                    while (i <= St1.length() - 1 && St1.charAt(i) != '-') {
                        num = num + St1.charAt(i);
                        i++;
                    }
                    num1 = (num1*(-1))-(Double.parseDouble(num));
                    num = "";
                }

                JTF1.setText(String.valueOf(num1));
            }
            else if(opp=='*') {
                String St1 = JTF1.getText();
                String num = "";
                double num1 = 1;
                for (int i = 0; i <= St1.length() - 1; i++) {
                    while (i <= St1.length() - 1 && St1.charAt(i) != '*') {
                        num = num + St1.charAt(i);
                        i++;
                    }
                    num1 = Double.parseDouble(num)*num1;
                    num = "";
                }
                JTF1.setText(String.valueOf(num1));
            }
            else if(opp=='/') {
                String St1 = JTF1.getText();
                String num = "";
                double num1 = 1.0,num2=1.0;
                for (int i = 0; i <= St1.length() - 1; i++) {
                    while (i <= St1.length() - 1 && St1.charAt(i) != '/') {
                        num = num + St1.charAt(i);
                        i++;
                    }
                    if(num1==1.0) {
                        num1 = Double.parseDouble(num) / num1;
                    }
                    else {
                        num2 = num1 / Double.parseDouble(num);
                    }
                    num = "";
                }
                JTF1.setText(String.valueOf(num2));
            }
            else if(opp=='%') {
                String St1 = JTF1.getText();
                String num = "";
                double num1 = 1.0, n1=1.0,n2=1.0;
                for (int i = 0; i <= St1.length() - 1; i++) {
                    while (i <= St1.length() - 1 && St1.charAt(i) != '%') {
                        num = num + St1.charAt(i);
                        i++;
                    }

                    if(num1==1.0){
                        num1=(Double.parseDouble(num)/100);
                    }
                    else{
                        n1=Double.parseDouble(num);
                    }
                    n2=num1*n1;
                    num = "";
                }
                JTF1.setText(String.valueOf(n2));
            }
        }
        else if(S2.equals("Sq")){
            String num=JTF1.getText();
            double num2=Double.parseDouble(num), Sq;
            Sq=num2*num2;
            JTF1.setText(String.valueOf(Sq));
        }
        else if(S2.equals("cube")){
            String num=JTF1.getText();
            double num2=Double.parseDouble(num), Sq;
            Sq=num2*num2*num2;
            JTF1.setText(String.valueOf(Sq));
        }
        else {
            switch (S2) {
                case "1" -> {
                    JTF1.setText(JTF1.getText() + "1");
                    break;
                }
                case "2" -> {
                    JTF1.setText(JTF1.getText() + "2");
                    break;
                }
                case "3" -> {
                    JTF1.setText(JTF1.getText() + "3");
                    break;
                }
                case "4" -> {
                    JTF1.setText(JTF1.getText() + "4");
                    break;
                }
                case "5" -> {
                    JTF1.setText(JTF1.getText() + "5");
                    break;
                }
                case "6" -> {
                    JTF1.setText(JTF1.getText() + "6");
                    break;
                }
                case "7" -> {
                    JTF1.setText(JTF1.getText() + "7");
                    break;
                }
                case "8" -> {
                    JTF1.setText(JTF1.getText() + "8");
                    break;
                }
                case "9" -> {
                    JTF1.setText(JTF1.getText() + "9");
                    break;
                }
                case "0" -> {
                    JTF1.setText(JTF1.getText() + "0");
                    break;
                }
                case "." -> {
                    if(JTF1.getText().equals("")) {
                        JTF1.setText(JTF1.getText() + "0.");
                    }
                    else {
                        JTF1.setText(JTF1.getText() + ".");
                    }
                    break;
                }
            }
        }

    }
}