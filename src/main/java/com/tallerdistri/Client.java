package com.tallerdistri;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, FileNotFoundException {

        File myObj = new File("./provider/PS.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            //Send to server
            SolicitudInterface solInt = (SolicitudInterface) Naming.lookup("rmi://25.16.253.86:10005/proceso");

            String respuesta = solInt.realizarSolicitud(data);

            System.out.println(respuesta);

        }
        myReader.close();
    }
}
