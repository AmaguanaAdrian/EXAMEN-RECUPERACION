/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author USER
 */
import modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaControlador {
    
    public Persona persona;
    
    ConexionBDD conexion=new ConexionBDD();
    Connection connection=(Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    public void crearPersona(Persona p){
        try{
            String consulta = "INSERT INTO personas(per_nombre, "
                    + "per_apellido, "
                    + "per_cedula, "
                    + "per_calle, "
                    + "per_ciudad, "
                    + "per_codPostal, "
                    + "per_pais, "
                    + "per_continente) "
                    + "VALUES (?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?, "
                    + "?);";
            
            ejecutar =(PreparedStatement) connection.prepareCall(consulta);
            ejecutar.setString(1, p.getNombre());
            ejecutar.setString(2, p.getApellido());
            ejecutar.setInt(3, p.getCedula());
            ejecutar.setString(4, p.getDireccion().getCalle());
            ejecutar.setString(5, p.getDireccion().getCiudad());
            ejecutar.setInt(6, p.getDireccion().getCodPostal());
            ejecutar.setString(7, p.getDireccion().getPais().getNombrePais());
            ejecutar.setString(8, p.getDireccion().getPais().getContinente().getNombreContinente());
            
            //Ejecutar la consulta
            int res = ejecutar.executeUpdate();
            
            if(res > 0){
                ejecutar.close();
            }else{
                System.out.println("¡ERROR, CONTACTESE CON EL ADMINISTADOR!");
                ejecutar.close();
            }
        }catch(Exception e){
            System.out.println("ERROR: " + e);
        }
    }
    
    public int buscarIdPersona(int cedula){
        int idPersona = 0;
        try {
            String consulta = "SELECT per_id FROM personas "
                    + "WHERE per_cedula = ?;";
            
            ejecutar =(PreparedStatement) connection.prepareCall(consulta);
            ejecutar.setInt(1, cedula);
            
            resultado = ejecutar.executeQuery();
            
            if(resultado.next()){
                idPersona = resultado.getInt("per_id");
                ejecutar.close();
                return idPersona;
            }else{
                System.out.println("¡ERROR, CONTACTESE CON EL ADMINISTADOR!");
                ejecutar.close();
                return idPersona;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return idPersona;
    }
}