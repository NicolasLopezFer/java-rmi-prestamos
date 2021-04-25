package com.tallerdistri;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {
    public static void main(String[] args) throws RemoteException{


        System.setProperty("java.rmi.server.hostname", "25.16.253.86");

        Registry registry = LocateRegistry.createRegistry(5099);

        registry.rebind("proceso", new SolicitudImplementation());

        System.out.println("Done!!!");
        System.out.println("Servidor ahora escucha peticiones...");
    }
}
