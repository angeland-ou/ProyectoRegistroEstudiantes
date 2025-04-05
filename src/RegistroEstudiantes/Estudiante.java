package RegistroEstudiantes;

import java.util.List;

public class Estudiante {
    private String nombre;
    private int edad;
    private String curso;

    private static final List<String> CURSOS_VALIDOS = List.of("1", "2", "3");

    public Estudiante(String nombre, int edad, String curso) throws NombreInvalidoException, EdadInvalidaException, CursoInvalidoException {

        if(!validarNombre(nombre)){
            throw new NombreInvalidoException("El nombre no puede estar vacío.");
        }
        if(!validarEdad(edad)){
            throw new EdadInvalidaException("La edad debe estar entre 18 y 65");
        }
        if(!validarCurso(curso)){
            throw new CursoInvalidoException("El curso no existe");
        }

        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    public static void mostrarEstudiante(Estudiante estudiante){
        System.out.println("- Nombre: "+estudiante.getNombre()+", Edad:"+estudiante.getEdad()+", Curso: "+estudiante.getCurso());
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }


    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().equals("");
    }
    public static boolean validarEdad(int edad) {
        return edad>=18 && edad<=65;
    }
    public static boolean validarCurso(String curso) {
        return curso.equals("1") || curso.equals("2") || curso.equals("3");
    }
}
