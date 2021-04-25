package com.tallerdistri.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.tallerdistri.SolicitudImplementation;
import com.tallerdistri.SolicitudInterface;

public class Server {
    public static void main(String[] args) {
        SolicitudImplementation implementation = new SolicitudImplementation();

        try {
            SolicitudInterface solInt = (SolicitudInterface) UnicastRemoteObject.exportObject(implementation,0);
            Registry registry = LocateRegistry.createRegistry(5099);

            registry.rebind("proceso", solInt);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return;
        }

        System.out.println("Done!!!");
        System.out.println("Servidor ahora escucha peticiones...");
    }
}
