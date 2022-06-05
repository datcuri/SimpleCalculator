/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleCaculator;
import java.net.MalformedURLException;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.rmi.*;
/**
 *
 * @author UKiel
 */

public class Sever {
    public static void main(String[] args) {
        try {
            ServerClass myObject = new ServerClass();
            UnicastRemoteObject.exportObject(myObject, 1100);
            LocateRegistry.createRegistry(1099);
            Naming.bind("//localhost/myObj", myObject);
            System.out.println("Server ready...");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException ex) {
            System.out.println("Server error: " + ex);
        }
    }    
}
