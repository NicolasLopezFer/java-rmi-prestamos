package com.tallerdistri;

import java.rmi.RemoteException;

public class SolicitudImplementation implements SolicitudInterface{


    @Override
    public String realizarSolicitud(String solicitud) throws RemoteException {
        String respuesta = "Libro no disponible";
        
        // TODO: Realizar proceso base de datos

        System.out.println("Llego solicitud: " + solicitud);

        return respuesta;
    }

    
}
