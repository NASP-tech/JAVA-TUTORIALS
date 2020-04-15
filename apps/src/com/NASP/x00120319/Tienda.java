package com.NASP.x00120319;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Aplicacion> appsEnTienda;

    public Tienda() {
        appsEnTienda = new ArrayList<>();
    }

    public void agregarAplicacion(Aplicacion app){
        try{
            boolean existe = false;

            for(Aplicacion a : appsEnTienda){
                if(a.getPaquete().equals(app.getPaquete()))
                    existe = true;
            }

            if(existe)
                throw new AlreadyExistAppException("Ya existe una aplicacion en la tienda con ese nombre" +
                        "de paquete");

            appsEnTienda.add(app);
        }
        catch(AlreadyExistAppException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Aplicacion buscarAplicacion(String paquete){
        for(Aplicacion app : appsEnTienda){
            if(app.getPaquete().equals(paquete))
                return app;
        }
        return null;
    }

    public String consultarAplicaciones(){
        String cadena = "";

        for(Aplicacion app : appsEnTienda){
            cadena += app.toString() + "\n";
        }

        return cadena;
    }
}
