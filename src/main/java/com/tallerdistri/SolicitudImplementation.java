package com.tallerdistri;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import com.tallerdistri.model.Libro;
import com.tallerdistri.model.Usuario;

public class SolicitudImplementation extends UnicastRemoteObject implements SolicitudInterface{


    protected SolicitudImplementation() throws RemoteException {
        super();
    }

    @Override
    public String realizarSolicitud(String solicitud) throws RemoteException {
        String respuesta = generarRespuesta(solicitud); 

        System.out.println("Llego solicitud: " + solicitud);

        return respuesta;
    }

    String generarRespuesta(String solicitud) {
        String respuesta = "";

        //Leer Usuarios
        String dirUsuarios= "./database/UsuariosTaller.txt";
        String dirLibros= "./database/LibrosTaller.txt";
        
        ArrayList<Usuario> usuarios;
        ArrayList<Libro> libros;

        usuarios=leerUsuarios(dirUsuarios);
        libros=leerLibros(dirLibros);

        System.out.println(usuarios.size());
        System.out.println(libros.size());
        
        String prestamo="P,2,5003";
        leerPrestamo(prestamo,usuarios,libros,dirLibros);
        
        return respuesta;
    }

    public static ArrayList<Usuario> leerUsuarios(String dir) {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        File archivo = new File(dir);

        try {
            Scanner s = new Scanner(archivo);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] properties = line.split(",");
                Usuario user = new Usuario();
                user.setIdentificacion(Long.parseLong(properties[0]));
                user.setNombreCompleto(properties[1]);
                user.setEmail(properties[2]);
                user.setTelefono(properties[3]);

                usuarios.add(user);
            }
            s.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return usuarios;
    }

    public static ArrayList<Libro> leerLibros(String dir) {
        
        ArrayList<Libro> libros = new ArrayList<Libro>();

        File archivo = new File(dir);

        try {
            Scanner s = new Scanner(archivo);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] properties = line.split(",");
                Libro libro = new Libro();
                libro.setId(Long.parseLong(properties[0]));
                libro.setIsbn(properties[1]);
                libro.setNombre(properties[2]);
                libro.setCantidadTotal(Integer.parseInt(properties[3]));
                libro.setCantidadPrestada(Integer.parseInt(properties[4]));

                libros.add(libro);
            }
            s.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return libros;
    }

    public static void leerPrestamo(String prestamo,ArrayList<Usuario> usuarios,ArrayList<Libro> libros,String dirLibros) {
            
        String[] properties = prestamo.split(",");
        String operacion=properties[0];
        if(operacion.equals("P")){
            Usuario usuario=validarUsuario(Long.parseLong(properties[1]),usuarios);
            if(usuario==null){
                System.out.println("Error: El usuario recibido no existe en la base de datos");
                return;
            } 
            Libro libro=validarLibro(properties[2],libros);
            if(libro==null){
                System.out.println("Error: El libro recibido no existe en la base de datos");
                return;
            }
            if(libro.getCantidadTotal()<=libro.getCantidadPrestada()){
                System.out.println("No se tiene disponibilidad del libro");
                return;
            }
            libro.setCantidadPrestada(libro.getCantidadPrestada()+1);
            actualizarLibro(libro,dirLibros,libros); 
        }              
    }

    public static Libro validarLibro(String isbn,ArrayList<Libro> libros){
        for(Libro libro:libros){
            if(libro.getIsbn().equals(isbn))
                return libro;
        }
        return null;
    }

    public static Usuario validarUsuario(long idUsuario,ArrayList<Usuario> usuarios){
        for(Usuario user:usuarios){
            if(user.getIdentificacion()==idUsuario)
                return user;
        }
        return null;
    }

    public static boolean actualizarLibro(Libro libro,String dirLibros,ArrayList<Libro>libros){

        try {
            FileWriter fichero = new FileWriter(dirLibros);
            
			for (Libro l:libros) {
                String linea=l.getId()+","+l.getIsbn()+","+l.getCantidadTotal()+","+l.getCantidadPrestada();
				fichero.write(linea + "\n");
			}
			fichero.close();
            System.out.println("Libro prestado correctamente");
            return true;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
        return false;
    }
}
