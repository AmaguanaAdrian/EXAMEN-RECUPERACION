/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Profesor extends Persona {
    private int idProfesor;
    private String despacho;

    public Profesor() {
    }

    public Profesor(int idProfesor, String despacho, int idPersona, String nombre, String apellido, int cedula, Direccion direccion) {
        super(idPersona, nombre, apellido, cedula, direccion);
        this.idProfesor = idProfesor;
        this.despacho = despacho;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }
    
    @Override
    public String toString() {
        return " -------- DATOS PROFESOR -----------"
                + getIdProfesor() + " --------\n" 
                + "Nombres: " + getNombre() + "\n"
                + "Apellidos: " + getApellido() + "\n"
                + "Cédula: " + getCedula() + "\n"
                + "Calle: " + getDireccion().getCalle() + "\n"
                + "Ciudad: " + getDireccion().getCiudad() + "\n"
                + "Cod. Postal: " + getDireccion().getCodPostal() + "\n"
                + "País: " + getDireccion().getPais().getNombrePais() + "\n"
                + "Continente: " + getDireccion().getPais().getContinente().getNombreContinente() + "\n"
                + "Despacho: " + getDespacho() + "\n";
    }
    
    @Override
    public void identificacion(){
        System.out.println(toString());
    }
}
