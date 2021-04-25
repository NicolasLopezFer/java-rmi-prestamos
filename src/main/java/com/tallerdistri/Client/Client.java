package com.tallerdistri.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.tallerdistri.SolicitudInterface;

public class Client {
    public static void main(String[] args) throws NotBoundException {
        try {
            String nombre = "proceso";
            Registry registry = LocateRegistry.getRegistry("localhost");
            SolicitudInterface solInt = (SolicitudInterface) registry.lookup(nombre);

            String solicitud = "P,2,2";
            solInt.realizarSolicitud(solicitud);
            String respuesta = solInt.realizarSolicitud(solicitud);

            System.out.println("La respuesta retornada es: " + respuesta);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
