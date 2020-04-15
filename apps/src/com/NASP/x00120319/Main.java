package com.NASP.x00120319;


import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre, idioma, tipo, paquete;
        double desc, inst, precio;

        String menu = "1. Agregar app a la tienda\n" +
                "2. Consultar app de la tienda\n" +
                "3. Instalar app\n" +
                "4. Desinstalar app\n" +
                "5. Mostrar app instaladasn\n" +
                "6. Mostrar datos y almacenamiento restante\n" +
                "0. Salir";

        Tienda playStore = new Tienda();
        Smartphone disp = new Smartphone("Xiaomi", "Redmi Note 8", "Android", 20, 64);

        byte op = 0;

        do{
            System.out.println(menu); op = in.nextByte(); in.nextLine();

            switch(op){
                case 1:
                    System.out.print("Nombre: "); nombre = in.nextLine();
                    System.out.print("Idioma: "); idioma = in.nextLine();
                    System.out.print("Tipo: "); tipo = in.nextLine();
                    System.out.print("Paquete: "); paquete = in.nextLine();
                    System.out.print("Tam. desc: "); desc = in.nextDouble();
                    System.out.print("Tam. inst: "); inst = in.nextDouble();
                    System.out.print("Precio: "); precio = in.nextDouble();

                    playStore.agregarAplicacion(new Aplicacion(nombre, idioma, tipo, paquete,
                            desc, inst, precio));
                    break;
                case 2:
                    System.out.println(playStore.consultarAplicaciones());
                    break;
                case 3:
                    try{
                        System.out.print("Nombre de paquete de app a instalar: ");
                        paquete = in.nextLine();

                        Aplicacion instalar = playStore.buscarAplicacion(paquete);

                        if(instalar == null)
                            throw new NotFoundException("No existe la aplicacion en la tienda");

                        disp.instalarApp(instalar);
                    }
                    catch(NotFoundException ex){
                        System.out.println(ex.getMessage());
                    }
                    catch(AlreadyExistAppException ex){
                        System.out.println(ex.getMessage());
                    }
                    catch(InsufficientDataException ex){
                        System.out.println(ex.getMessage());
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try{
                        System.out.print("Nombre de paquete de app a desinstalar: ");
                        paquete = in.nextLine();

                        disp.desinstalarAplicacion(paquete);
                    }
                    catch(NotFoundException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    System.out.println(disp.consultarAplicaciones());
                    break;
                case 6:
                    System.out.println(disp.datosSmartphone());
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            System.out.println();
        } while(op != 0);
    }
}

