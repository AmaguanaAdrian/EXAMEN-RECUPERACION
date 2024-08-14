/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import controlador.EstudianteControlador;
import controlador.PersonaControlador;
import controlador.ProfesorControlador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Continente;
import modelo.Direccion;
import modelo.Estudiante;
import modelo.Pais;
import modelo.Persona;
import modelo.Profesor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            clearScreen();
            System.out.println("=========== Menú Principal ===========");
            System.out.println("1. Añadir Estudiante                 ||");
            System.out.println("2. Añadir Profesor                   ||");
            System.out.println("3. Ver Estudiantes                   ||");
            System.out.println("4. Ver Profesores                    ||");
            System.out.println("5. Salir                             ||");
            System.out.println("======================================");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    clearScreen();
                    addStudent();
                    break;
                case "2":
                    clearScreen();
                    addTeacher();
                    break;
                case "3":
                    clearScreen();
                    viewStudents();
                    break;
                case "4":
                    clearScreen();
                    viewTeachers();
                    break;
                case "5":
                    clearScreen();
                    System.out.println("¡Saliendo del programa!");
                    break;
                default:
                    clearScreen();
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        } while (!choice.equals("5"));
    }

    private static void addStudent() {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Persona person = new Persona();
            Direccion address = new Direccion();
            Pais country = new Pais();
            Continente continent = new Continente();

            System.out.println("Ingreso de Datos del Estudiante:");
            System.out.print("Ingrese nombres: ");
            person.setNombre(reader.readLine().toUpperCase());
            System.out.print("Ingrese apellidos: ");
            person.setApellido(reader.readLine().toUpperCase());
            System.out.print("Ingrese cédula: ");
            person.setCedula(scanner.nextInt());
            scanner.nextLine(); // Consume newline

            System.out.println("Dirección");
            System.out.print("Ingrese calle: ");
            address.setCalle(reader.readLine().toUpperCase());
            System.out.print("Ingrese ciudad: ");
            address.setCiudad(reader.readLine().toUpperCase());
            System.out.print("Ingrese código postal: ");
            address.setCodPostal(scanner.nextInt());
            scanner.nextLine(); // Consume newline

            System.out.print("Ingrese país: ");
            country.setNombrePais(reader.readLine().toUpperCase());

            System.out.print("Ingrese continente: ");
            continent.setNombreContinente(reader.readLine().toUpperCase());

            country.setContinente(continent);
            address.setPais(country);
            person.setDireccion(address);

            PersonaControlador personController = new PersonaControlador();
            personController.crearPersona(person);
            int personId = personController.buscarIdPersona(person.getCedula());

            EstudianteControlador studentController = new EstudianteControlador();
            studentController.crearEstudiante(personId);

            clearScreen();
            System.out.println("¡Estudiante creado exitosamente!");
            person.identificacion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTeacher() {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Persona person = new Persona();
            Profesor teacher = new Profesor();
            Direccion address = new Direccion();
            Pais country = new Pais();
            Continente continent = new Continente();

            System.out.println("Ingreso de Datos del Profesor:");
            System.out.print("Ingrese nombres: ");
            person.setNombre(reader.readLine().toUpperCase());
            System.out.print("Ingrese apellidos: ");
            person.setApellido(reader.readLine().toUpperCase());
            System.out.print("Ingrese cédula: ");
            person.setCedula(scanner.nextInt());
            scanner.nextLine(); // Consume newline
            System.out.print("Ingrese despacho: ");
            teacher.setDespacho(reader.readLine().toUpperCase());

            System.out.println("Dirección");
            System.out.print("Ingrese calle: ");
            address.setCalle(reader.readLine().toUpperCase());
            System.out.print("Ingrese ciudad: ");
            address.setCiudad(reader.readLine().toUpperCase());
            System.out.print("Ingrese código postal: ");
            address.setCodPostal(scanner.nextInt());
            scanner.nextLine(); // Consume newline

            System.out.print("Ingrese país: ");
            country.setNombrePais(reader.readLine().toUpperCase());

            System.out.print("Ingrese continente: ");
            continent.setNombreContinente(reader.readLine().toUpperCase());

            country.setContinente(continent);
            address.setPais(country);
            person.setDireccion(address);

            PersonaControlador personController = new PersonaControlador();
            personController.crearPersona(person);
            int personId = personController.buscarIdPersona(person.getCedula());

            ProfesorControlador teacherController = new ProfesorControlador();
            teacherController.crearProfesor(personId, teacher);

            clearScreen();
            System.out.println("¡Profesor creado exitosamente!");
            person.identificacion();
            System.out.println("Despacho: " + teacher.getDespacho());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void viewStudents() {
        EstudianteControlador studentController = new EstudianteControlador();
        ArrayList<Estudiante> students = studentController.listarEstudiantes();
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            students.forEach(Estudiante::identificacion);
        }
    }

    private static void viewTeachers() {
        ProfesorControlador teacherController = new ProfesorControlador();
        ArrayList<Profesor> teachers = teacherController.listarProfesores();
        if (teachers.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            teachers.forEach(Profesor::identificacion);
        }
    }
}
