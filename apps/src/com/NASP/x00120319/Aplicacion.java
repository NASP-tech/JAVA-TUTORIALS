package com.NASP.x00120319;

public class Aplicacion {
    private String nombre, idioma, tipo, paquete;
    private double desc, inst, precio;

    public Aplicacion(String nombre, String idioma, String tipo, String paquete, double desc, double inst, double precio) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.paquete = paquete;
        this.desc = desc;
        this.inst = inst;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Aplicacion{" +
                "nombre='" + nombre + '\'' +
                ", idioma='" + idioma + '\'' +
                ", tipo='" + tipo + '\'' +
                ", paquete='" + paquete + '\'' +
                ", desc=" + desc +
                ", inst=" + inst +
                ", precio=" + precio +
                '}';
    }

    public String getPaquete() {
        return paquete;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDesc() {
        return desc;
    }

    public double getInst() {
        return inst;
    }

    public double getPrecio() {
        return precio;
    }
}
