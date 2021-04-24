package com.tallerdistri;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Hello world!
 *
 */
public class Client 
{
    public static void main( String[] args ) throws MalformedURLException, RemoteException, NotBoundException
    {
        HelloService service = (HelloService) Naming.lookup("rmi://localhost:5099/hello");
        System.out.println("----" + service.echo("Hey server"));
    
    }
}
