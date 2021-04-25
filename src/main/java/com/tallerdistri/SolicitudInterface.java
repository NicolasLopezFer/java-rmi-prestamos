package com.tallerdistri;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SolicitudInterface extends Remote{
    public String realizarSolicitud( String solicitud ) throws RemoteException;

}
