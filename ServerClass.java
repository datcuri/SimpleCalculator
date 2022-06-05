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
public class ServerClass implements SInterface{

    CInterface client;//Phục vụ callback
    
    
    @Override
    public void saveRef(CInterface c) throws RemoteException {//Phục vụ callback
        this.client = c;
    }
    
    @Override
    public double cong(double a, double b) throws RemoteException {
        return a + b;
    }
    
    @Override
    public double tru(double a, double b) throws RemoteException {
        return a - b;
    }
    
    @Override
    public double nhan(double a, double b) throws RemoteException {
        return a * b;
    }
    
    @Override
    public double chia(double a, double b) throws RemoteException {
        if(b == 0)
//            JOptionPane.showMessageDialog(null,"Loi chia cho 0. Hay nhap lai!", "Loi nhap lieu" ,JOptionPane.ERROR_MESSAGE);
            this.client.printMsg("Loi chia cho 0. Hay nhap lai!"); //callback
        return a / b;    
    }    
}