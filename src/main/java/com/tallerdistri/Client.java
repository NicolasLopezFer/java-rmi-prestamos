package com.tallerdistri;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        System.setProperty("jnava.rmi.server.hostname", "25.9.62.240");
        SolicitudInterface solInt = (SolicitudInterface) Naming.lookup("rmi://25.16.253.86:10005/proceso");

        String solicitud = "P,2,2";
        String respuesta = solInt.realizarSolicitud(solicitud);

         System.out.println("La respuesta retornada es: " + respuesta);
    }
}
