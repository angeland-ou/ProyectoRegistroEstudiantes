package RegistroEstudiantes;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import static RegistroEstudiantes.Estudiante.mostrarEstudiante;

public class RegistroEstudiantes {
    private LinkedList<Estudiante> registroEstudiantes;

    public RegistroEstudiantes (){
        this.registroEstudiantes = new LinkedList<>();
    }

    public void registrarEstudiante(Estudiante nuevoEstudiante) {
        this.registroEstudiantes.add(nuevoEstudiante);
        System.out.println("Se ha registrado el estudiante");
    }

    public void mostrarRegistroEstudiantes(){
        for (Estudiante estudiante : registroEstudiantes){
            mostrarEstudiante(estudiante);
        }
    }

    public void guardarEnArchivo(String rutaArchivo) {
        Scanner scn = new Scanner(System.in);
        try {
            FileWriter fileW = new FileWriter(rutaArchivo,true);
            PrintWriter print = new PrintWriter(fileW);
            System.out.println("Escribe lo que quieras guardar en el archivo: ");
            print.println(scn.nextLine());
        } catch (IOException ioe) {
            System.out.println("Ha habido un error con el documento.");
        }
    }

    public void cargarDesdeArchivo(String rutaArchivo) throws FileNotFoundException {
        File file = new File("documento.txt");
        if(file.exists()){
            FileReader fileR = new FileReader("documento.txt");
            BufferedReader reader = new BufferedReader(fileR);
        }
        else {
            throw new FileNotFoundException("Archivo no encontrado");
        }
    }
}
