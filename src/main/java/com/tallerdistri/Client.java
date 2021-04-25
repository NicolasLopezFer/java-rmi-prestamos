package com.tallerdistri;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        SolicitudInterface solInt = (SolicitudInterface) Naming.lookup("rmi://25.16.253.86:5099/procesoo");

        String solicitud = "P,2,2";
        String respuesta = solInt.realizarSolicitud(solicitud);

         System.out.println("La respuesta retornada es: " + respuesta);
    }
}
