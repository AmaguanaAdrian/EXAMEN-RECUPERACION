/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Estudiante extends Persona {
    private int idEstudiante;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, int idPersona, String nombre, String apellido, int cedula, Direccion direccion) {
        super(idPersona, nombre, apellido, cedula, direccion);
        this.idEstudiante = idEstudiante;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    @Override
    public String toString() {
        return " -------- DATOS ESTUDIANTES -------------"
                + getIdEstudiante() + " --------\n" 
                + "Nombres: " + getNombre() + "\n"
                + "Apellidos: " + getApellido() + "\n"
                + "Cédula: " + getCedula() + "\n"
                + "Calle: " + getDireccion().getCalle() + "\n"
                + "Ciudad: " + getDireccion().getCiudad() + "\n"
                + "Cod. Postal: " + getDireccion().getCodPostal() + "\n"
                + "País: " + getDireccion().getPais().getNombrePais() + "\n"
                + "Continente: " + getDireccion().getPais().getContinente().getNombreContinente()
                + "\n";
    }
    
    @Override
    public void identificacion(){
        System.out.println(toString());
    }
}