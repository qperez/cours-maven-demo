package fr.imt.cours.perez.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Search extends Remote 
{ 
    // Declaring the method prototype 
    public String query(String search) throws RemoteException; 
} 