/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Profesor;
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

public class ProfesorControlador {
    
    public Profesor profesor;
    
    ConexionBDD conexion=new ConexionBDD();
    Connection connection=(Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    public void crearProfesor(int idPersona, Profesor p){
        try {
            String consulta = "INSERT INTO profesores(pro_despacho, "
                    + "per_id) "
                    + "VALUES (?, "
                    + "?);";
            
            ejecutar =(PreparedStatement) connection.prepareCall(consulta);
            ejecutar.setString(1, p.getDespacho());
            ejecutar.setInt(2, idPersona);
            
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
    
    public ArrayList<Profesor> listarProfesores(){
        ArrayList<Profesor> listadoProfesores = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM personas p, profesores r "
                    + "WHERE p.per_id = r.per_id;";
            ejecutar =(PreparedStatement) connection.prepareCall(consulta);
            
            resultado = ejecutar.executeQuery();
            
            while(resultado.next()){
                Profesor pro = new Profesor();
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
                
                pro.setDireccion(dir);
                pro.setNombre(resultado.getString("per_nombre"));
                pro.setApellido(resultado.getString("per_apellido"));
                pro.setCedula(resultado.getInt("per_cedula"));
                pro.setIdProfesor(resultado.getInt("pro_id") + 301007);
                
                pro.setDespacho(resultado.getString("pro_despacho"));
                
                listadoProfesores.add(pro);
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return listadoProfesores;
    }
}