/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Persona implements Humano {
    private int idPersona;
    private String nombre;
    private String apellido;
    private int cedula;
    private Direccion direccion;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellido, int cedula, Direccion direccion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void identificacion(){
        System.out.println(" -------- DATOS PERSONALES --------\n" 
                + "Nombres: " + getNombre() + "\n"
                + "Apellidos: " + getApellido() + "\n"
                + "Cédula: " + getCedula() + "\n"
                + "Calle: " + getDireccion().getCalle() + "\n"
                + "Ciudad: " + getDireccion().getCiudad() + "\n"
                + "Cod. Postal: " + getDireccion().getCodPostal() + "\n"
                + "País: " + getDireccion().getPais().getNombrePais() + "\n"
                + "Continente: " + getDireccion().getPais().getContinente().getNombreContinente()
                + "\n");
    }
}