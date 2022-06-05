/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleCaculator;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.*;

/**
 *
 * @author UKiel
 */
public class GUI_Caculator extends JFrame {

    SInterface ss;
    CInterface client;

    private JFrame fr;
    private JTextField txt;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btncham;
    private JButton btncong, btntru, btnnhan, btnchia, btnbang;

    double num = 0;
    String lastbtn = null;
    int check = 0;

    public GUI_Caculator() {
        GUIcompoment();
        try {
            ss = (SInterface) Naming.lookup("//localhost/myObj");

            client = new ClientClass();
            UnicastRemoteObject.exportObject(client, 0);
            ss.saveRef(client);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
        }

        btn0.addActionListener(new Listener());
        btn1.addActionListener(new Listener());
        btn2.addActionListener(new Listener());
        btn3.addActionListener(new Listener());
        btn4.addActionListener(new Listener());
        btn5.addActionListener(new Listener());
        btn6.addActionListener(new Listener());
        btn7.addActionListener(new Listener());
        btn8.addActionListener(new Listener());
        btn9.addActionListener(new Listener());
        btncham.addActionListener(new Listener());

        btntru.addActionListener(new Listener());
        btnnhan.addActionListener(new Listener());
        btncong.addActionListener(new Listener());
        btnchia.addActionListener(new Listener());
        btnbang.addActionListener(new Listener());
    }

    public void GUIcompoment() {
        fr = new JFrame("Calculation");
        fr.setSize(400, 450);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new BorderLayout());
        fr.setResizable(false);

        Font fo = new Font("Times New Roman", Font.BOLD, 24);

        JPanel p1 = new JPanel();
        p1.setLayout(new CardLayout());
        p1.setPreferredSize(new Dimension(400, 50));
        fr.add(p1, BorderLayout.NORTH);

        txt = new JTextField();
        txt.setHorizontalAlignment(JTextField.RIGHT);
        txt.setFont(fo);
        p1.add(txt);

        JPanel p2 = new JPanel();
        p2.setSize(new Dimension(400, 400));
        p2.setLayout(new GridLayout(4, 4));
        fr.add(p2, BorderLayout.CENTER);

        btn7 = new JButton("7");
        btn7.setFont(fo);
        p2.add(btn7);
        btn8 = new JButton("8");
        btn8.setFont(fo);
        p2.add(btn8);
        btn9 = new JButton("9");
        btn9.setFont(fo);
        p2.add(btn9);
        btncong = new JButton("+");
        btncong.setFont(fo);
        p2.add(btncong);

        btn4 = new JButton("4");
        btn4.setFont(fo);
        p2.add(btn4);
        btn5 = new JButton("5");
        btn5.setFont(fo);
        p2.add(btn5);
        btn6 = new JButton("6");
        btn6.setFont(fo);
        p2.add(btn6);
        btntru = new JButton("-");
        btntru.setFont(fo);
        p2.add(btntru);

        btn1 = new JButton("1");
        btn1.setFont(fo);
        p2.add(btn1);
        btn2 = new JButton("2");
        btn2.setFont(fo);
        p2.add(btn2);
        btn3 = new JButton("3");
        btn3.setFont(fo);
        p2.add(btn3);
        btnnhan = new JButton("*");
        btnnhan.setFont(fo);
        p2.add(btnnhan);

        btn0 = new JButton("0");
        p2.add(btn0);
        btn0.setFont(fo);
        btncham = new JButton(".");
        btncham.setFont(fo);
        p2.add(btncham);
        btnbang = new JButton("=");
        btnbang.setFont(fo);
        p2.add(btnbang);
        btnchia = new JButton("/");
        btnchia.setFont(fo);
        p2.add(btnchia);

        fr.setVisible(true);

    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            switch (s) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." -> {
                    if (!"=".equals(lastbtn)) {
                        txt.setText(txt.getText() + s);
                    } else {
                        txt.setText("");
                        txt.setText(txt.getText() + s);
                        lastbtn = null;
                        check = 0;
                    }
                }

                case "+", "-", "*", "/" -> {
                    if (!"=".equals(lastbtn)) {
                        if (lastbtn == null) {
                            num = Double.parseDouble(txt.getText());

                        } else {
                            if (!txt.getText().isEmpty()) {
                                try {
                                    calculation();
                                } catch (Exception ex) {
                                }
                            }
                        }
                    }
                    lastbtn = s;
                    check = 0;
                    txt.setText("");
                }

                case "=" -> {
                    if (lastbtn == null) {
                        num = Double.parseDouble(txt.getText());
                        txt.setText(String.valueOf(num));
                    } else {
                        if (check == 0) {
                            try {
                                calculation();
                            } catch (Exception ex) {
                            }
                            txt.setText(String.valueOf(num));
                            lastbtn = s;
                            check = 1;
                        } else {
                            txt.setText("");
                            num = 0;
                            lastbtn = null;
                            check = 0;
                        }
                    }
                }
                default ->
                    throw new AssertionError();
            }
        }
    }

    public void calculation() throws Exception {
        // Them canh bao de trong
        Double num2 = Double.valueOf(txt.getText());
        System.out.println("last btn " + lastbtn);
        switch (lastbtn) {
            case "+" ->
                num = ss.cong(num, num2);
            case "-" ->
                num = ss.tru(num, num2);
            case "*" ->
                num = ss.nhan(num, num2);
            case "/" -> {
//                if (num2 == 0)
//                    JOptionPane.showMessageDialog(null, "Loi chia 0", "", JOptionPane.ERROR_MESSAGE);
//                else
                num = ss.chia(num, num2);
            }
            default ->
                throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        new GUI_Caculator();
    }
}
