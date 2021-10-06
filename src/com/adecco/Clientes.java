package com.adecco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Clientes {
    //Atributos
    public String nombre;
    public String apellidos;
    public int id;         /* identificador unico de cliente */

    //Constructor
    public Clientes(String nombre, String apellidos, int id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setId(int id) {
        this.id = id;
    }

    //Métodos
    public String LeerporTecladoNombre() throws IOException {
        System.out.print("* Inserta el nombre del cliente:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena = br.readLine();
        return cadena;
    }
    public String LeerporTecladoApellidos() throws IOException {
        System.out.print("* Inserta los apellidos del cliente:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena = br.readLine();
        return cadena;
    }
    public String LeerporTecladoId() throws IOException {
        System.out.print("* Inserta el ID del cliente:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena = br.readLine();
        return cadena;
    }
    }

