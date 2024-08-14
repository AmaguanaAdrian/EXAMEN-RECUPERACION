/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Continente;
import modelo.Direccion;
import modelo.Pais;

public class EstudianteControlador {
    
    public Estudiante estudiante;
    
    ConexionBDD conexion=new ConexionBDD();
    Connection connection=(Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    public void crearEstudiante(int idPersona){
        try {
            String consulta = "INSERT INTO estudiantes(per_id) "
                    + "VALUES (?);";
            
            ejecutar =(PreparedStatement) connection.prepareCall(consulta);
            ejecutar.setInt(1, idPersona);
            
            int res = ejecutar.executeUpdate();
            
            if(res > 0){
                ejecutar.close();
            }else{
                System.out.println("¡ERROR, CONTACTESE CON EL ADMINISTADOR!");
                ejecutar.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public ArrayList<Estudiante> listarEstudiantes(){
        ArrayList<Estudiante> listadoEstudiantes = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM personas p, estudiantes e "
                    + "WHERE p.per_id = e.per_id;";
            ejecutar =(PreparedStatement) connection.prepareCall(consulta);
            
            resultado = ejecutar.executeQuery();
            
            while(resultado.next()){
                Estudiante est = new Estudiante();
                Direccion dir = new Direccion();
                Pais pais = new Pais();
                Continente cont = new Continente();
                
                cont.setNombreContinente(resultado.getString("per_continente"));
                
                pais.setContinente(cont);
                pais.setNombrePais(resultado.getString("per_pais"));
                
                dir.setPais(pais);
                dir.setCalle(resultado.getString("per_calle"));
                dir.setCiudad(resultado.getString("per_ciudad"));
                dir.setCodPostal(resultado.getInt("per_codPostal"));
                
                est.setDireccion(dir);
                est.setNombre(resultado.getString("per_nombre"));
                est.setApellido(resultado.getString("per_apellido"));
                est.setCedula(resultado.getInt("per_cedula"));
                est.setIdEstudiante(resultado.getInt("est_id") + 100105);
                
                listadoEstudiantes.add(est);
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return listadoEstudiantes;
    }
}