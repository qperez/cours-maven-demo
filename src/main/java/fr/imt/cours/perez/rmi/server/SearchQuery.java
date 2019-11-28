package fr.imt.cours.perez.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SearchQuery extends UnicastRemoteObject implements Search { 
	// Default constructor to throw RemoteException 
	// from its parent constructor 
	public SearchQuery() throws RemoteException { 
		super(); 
	} 

	// Implementation of the query interface 
	public String query(String search) throws RemoteException { 
		String result; 
		if (search.equals("Reflection in Java")) 
			result = "Found"; 
		else
			result = "Not Found"; 

		return result; 
	}
	
	// Implementation of the query interface 
	public String query(MyOwnObject myOwnObject) throws RemoteException, MyOwnException { 
		if(myOwnObject==null) {
			throw new MyOwnException();
		}
		
		String result; 
		if (myOwnObject.returnQueryString().equals("Reflection in Java")) 
			result = "Found"; 
		else
			result = "Not Found"; 

		return result; 
	} 
} 
