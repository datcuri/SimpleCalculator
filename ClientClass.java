/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleCaculator;

import java.rmi.*;
import javax.swing.*;


/**
 *
 * @author UKiel
 */
public class ClientClass extends JFrame implements CInterface{
    @Override
    public void printMsg(String mes) throws RemoteException {
       JOptionPane.showMessageDialog(null, mes, "Lỗi nhập liệu", HEIGHT);
    }   
}
