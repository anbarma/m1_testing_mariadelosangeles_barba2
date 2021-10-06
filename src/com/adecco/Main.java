package com.adecco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// Mi proyecto JAVA

public class Main {


    public static void main(String[] args) throws IOException {
        //Crear 2 clientes
        Clientes Cliente1 = new Clientes("Juan", "González Bermúdez", 1);
        Clientes Cliente2 = new Clientes("Dolores", "Marrero Dïaz", 2);
        //Clientes VarImprimir = new Clientes ("","",0);
        //Crear la lista de clientes meter los clientes
        ArrayList<Clientes> cuentaClientes = new ArrayList<Clientes>();
        cuentaClientes.add(Cliente1);
        cuentaClientes.add(Cliente2);

        //Imprimir por pantalla los clientes
        PresentarporPantalla(cuentaClientes);

        //Escribir por pantalla las opciones y leer por teclado
        System.out.println("¿Qué operación quieres realizar? Insertar(I)/Leer(L)/Modificar(M)/Borrar(B)/BorrarTodo(BT)");
        System.out.println("Para salir pulsa S");
        String cadena = LeerporTeclado();
        while (cadena.equals("I") || cadena.equals("L") || cadena.equals("M") || cadena.equals("B") || cadena.equals("BT")) {

            switch (cadena) {
                case "I":
                    Clientes clienteNuevo = new Clientes("", "", 99);
                    cadena = clienteNuevo.LeerporTecladoNombre();
                    clienteNuevo.nombre = cadena;
                    cadena = clienteNuevo.LeerporTecladoApellidos();
                    clienteNuevo.apellidos = cadena;
                    clienteNuevo.id = cuentaClientes.size() + 1;

                    Boolean ok = cuentaClientes.add(clienteNuevo);
                    if (ok = true) {
                        System.out.println("El nuevo cliente ha sido guardado en la base de datos.");
                    }
                    PresentarporPantalla(cuentaClientes);
                    break;
                case "L":
                    cadena = Cliente1.LeerporTecladoId();
                    int identificador = Integer.parseInt(cadena);
                    if (identificador - 1 <= cuentaClientes.size()) {
                        Cliente1 = cuentaClientes.get(identificador - 1);
                        System.out.println(Cliente1.getId() + "-" + Cliente1.getNombre() + " " + Cliente1.getApellidos());
                    } else
                        System.out.println("El identificador de cliente no existe.");
                    break;
                case "M":
                    cadena = Cliente1.LeerporTecladoId();
                    identificador = Integer.parseInt(cadena);
                    if (identificador-1 <= cuentaClientes.size()) {
                        Cliente1 = cuentaClientes.get(identificador - 1);
                        System.out.println("Se modificará el siguiente cliente.");
                        System.out.println(Cliente1.getId() + "-" + Cliente1.getNombre() + " " + Cliente1.getApellidos());
                        PresentarporPantalla(cuentaClientes);
                        Cliente2.nombre = Cliente1.LeerporTecladoNombre();
                        Cliente2.apellidos = Cliente1.LeerporTecladoApellidos();
                        Cliente2.id = identificador;
                        cuentaClientes.set(identificador - 1, Cliente2);
                        PresentarporPantalla(cuentaClientes);
                        //el set está haciendo algo raro grabando el cliente en la posición y en la siguiente ???
                    } else
                        System.out.println("El identificador de cliente no existe.");
                    break;
                case "B":
                    cadena = Cliente1.LeerporTecladoId();
                    identificador = Integer.parseInt(cadena);
                    if (identificador - 1 <= cuentaClientes.size()) {
                        Cliente1 = cuentaClientes.get(identificador - 1);
                        System.out.println(Cliente1.getId() + "-" + Cliente1.getNombre() + " " + Cliente1.getApellidos());
                        System.out.println("Se borrará el cliente anterior.");
                        cuentaClientes.remove(identificador - 1);
                        ReorganizarArrayList(cuentaClientes, identificador);
                        PresentarporPantalla(cuentaClientes);
                    } else
                        System.out.println("El identificador de cliente no existe.");
                    break;
                case "BT":
                    cuentaClientes.clear();
                    System.out.println("Se han borrado todos los clientes registrados");
                    PresentarporPantalla(cuentaClientes);
                    break;
                default:
                    System.out.println("No se ha reconocido la operación a realizar");
                    break;
            }
            System.out.println("¿Qué operación quieres realizar? Insertar(I)/Leer(L)/Modificar(M)/Borrar(B)/BorrarTodo(BT)");
            System.out.println("Para salir pulsa S");
            cadena = LeerporTeclado();
        }
    }
    //System.out.println(Cliente1.getId()+"-"+Cliente1.getNombre()+ " "+ Cliente1.getApellidos());
    //System.out.println(Cliente2.getId()+"-"+Cliente2.getNombre()+ " "+ Cliente2.getApellidos());

    //Función que imprime todos los clientes por pantalla
    public static void PresentarporPantalla(ArrayList<Clientes> cuentadeClientes) {
        System.out.println("* Los clientes de mi base de datos son:");
        Clientes VarImprimir = new Clientes("", "", 0);
        for (int i = 0; i < cuentadeClientes.size(); i++) {
            VarImprimir = cuentadeClientes.get(i);
            System.out.println(VarImprimir.getId() + "-" + VarImprimir.getNombre() + " " + VarImprimir.getApellidos());
        }
    }
    //Función para leer por teclado la operación a realizar
    public static String LeerporTeclado() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena = br.readLine();
        return cadena;
    }
    //Función para reorganizar el ArrayList después de borrar un elemento
    public static void ReorganizarArrayList(ArrayList<Clientes> cuentadeClientes, int identificador) {
        Clientes VarReordenar = new Clientes("", "", 0);
        int j = 0;
        for (int i = identificador; i <= cuentadeClientes.size(); i++) {
            VarReordenar = cuentadeClientes.get(identificador - 1 + j);
            int id= VarReordenar.id;
            VarReordenar.id=id-1;
            int index = identificador -1;
            cuentadeClientes.set(index + j, VarReordenar);
            j=j+1;
        }


    }

}