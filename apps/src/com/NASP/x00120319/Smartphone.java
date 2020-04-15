package com.NASP.x00120319;

import java.util.ArrayList;
import java.util.Scanner;

public class Smartphone {
    private String marca, modelo, OS;
    private double datos, almacenamiento;
    private ArrayList<Aplicacion> appsInstaladas;

    public Smartphone(String marca, String modelo, String OS, double datos, double almacenamiento) {
        this.marca = marca;
        this.modelo = modelo;
        this.OS = OS;
        this.datos = datos;
        this.almacenamiento = almacenamiento;
        appsInstaladas = new ArrayList<>();
    }

    public void instalarApp(Aplicacion app) throws AlreadyExistAppException, InsufficientDataException {
        for(Aplicacion a : appsInstaladas){
            if(a.getPaquete().equals(app.getPaquete()))
                throw new AlreadyExistAppException("Ya existe una aplicacion instalada con el mismo nombre" +
                        "de paquete");
        }

        if(app.getDesc() > datos)
            throw new InsufficientDataException("No tienes suficientes datos para descargar esta aplicacion");

        if(app.getInst() > almacenamiento)
            throw new InsufficientDataException("No tienes suficiente espacio para instalar esta aplicacion");

        if(app.getPrecio() > 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("La aplicacion cuesta $" + app.getPrecio() + ", seguro que desea instalar? " +
                    "(S/N)\t");
            String aux = in.nextLine();

            if(aux.equals("n"))
                return;
        }

        appsInstaladas.add(app);
        datos -= app.getDesc();
        almacenamiento -= app.getInst();
    }

    public void desinstalarAplicacion(String paquete) throws NotFoundException {
        Aplicacion aux = null;

        for(Aplicacion app : appsInstaladas){
            if(app.getPaquete().equals(paquete))
                aux = app;
        }

        if(aux != null) {
            appsInstaladas.remove(aux);
            almacenamiento += aux.getInst();
        }
        else
            throw new NotFoundException("Aplicacion no encontrada, no es posible desinstalar");
    }

    public String consultarAplicaciones(){
        String mensaje = "";

        for(Aplicacion app : appsInstaladas)
            mensaje += app.toString() + "\n";

        return mensaje;
    }

    public String datosSmartphone(){
        return "Datos restantes: " + datos + ", almacenamiento disponible: " + almacenamiento;
    }
}
