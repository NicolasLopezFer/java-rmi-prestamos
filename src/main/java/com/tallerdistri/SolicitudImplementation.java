package com.tallerdistri;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SolicitudImplementation extends UnicastRemoteObject implements SolicitudInterface{


    public SolicitudImplementation() throws RemoteException {
        super();
    }

    @Override
    public String realizarSolicitud(String solicitud) throws RemoteException {
        String respuesta = "Libro no disponible";
        
        // TODO: Realizar proceso base de datos

        System.out.println("Llego solicitud: " + solicitud);

        return respuesta;
    }

    
}
