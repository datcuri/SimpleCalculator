/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SimpleCaculator;

import java.rmi.*;
import javax.swing.*;


/**
 *
 * @author UKiel
 */
public interface SInterface extends Remote{
    double cong(double a, double b) throws RemoteException;
    double tru(double a, double b) throws RemoteException;
    double nhan(double a, double b) throws RemoteException;
    double chia(double a, double b) throws RemoteException;
    void saveRef(CInterface c) throws RemoteException;//Phục vụ callback
}
