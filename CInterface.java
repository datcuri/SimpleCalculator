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
public interface CInterface extends Remote{
    void printMsg(String mes) throws RemoteException;
}
