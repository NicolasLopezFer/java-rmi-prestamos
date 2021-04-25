package com.tallerdistri.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.tallerdistri.SolicitudInterface;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, MalformedURLException {
        try {
            SolicitudInterface solInt = (SolicitudInterface) Naming.lookup("rmi://25.16.253.86:5099/proceso");

            String solicitud = "P,2,2";
            String respuesta = solInt.realizarSolicitud(solicitud);

            System.out.println("La respuesta retornada es: " + respuesta);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
