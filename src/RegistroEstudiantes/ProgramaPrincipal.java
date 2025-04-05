package RegistroEstudiantes;
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int opcion;
        Estudiante nuevoEstudiante;
        RegistroEstudiantes nuevoRegistroEstudiantes = new RegistroEstudiantes();
        boolean salir = false;

        do {
            mostrarMenu();
            try{
                opcion = Integer.parseInt(scn.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("has elegido "+opcion+" Registrar estudiante\n");
                        nuevoRegistroEstudiantes.registrarEstudiante(validarEstudiante());
                        break;
                    case 2:
                        System.out.println("has elegido "+opcion+" Mostrar lista de estudiantes\n");
                        nuevoRegistroEstudiantes.mostrarRegistroEstudiantes();
                        break;
                    case 3:
                        System.out.println("has elegido "+opcion+" Guardar en archivo\n");
                        break;
                    case 4:
                        System.out.println("has elegido "+opcion+" Cargar desde archivo\n");
                        break;
                    case 5:
                        System.out.println("has elegido "+opcion+" Salir\n");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }


            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número del 1 al 5");
                opcion = 0;
            } catch (NombreInvalidoException | EdadInvalidaException  | CursoInvalidoException exc){
                System.out.println("Error Personalizado: "+exc.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }

        } while (!salir);
    }

    private static void mostrarMenu() {
        System.out.println("MENÚ:");
        System.out.println("1. Agregar Estudiante");
        System.out.println("2. Mostrar Lista");
        System.out.println("3. Agregar a archivo");
        System.out.println("4. Cargar desde archivo");
        System.out.println("5. Salir");
    }

    public static Estudiante validarEstudiante() throws NombreInvalidoException, EdadInvalidaException, CursoInvalidoException {
        Scanner scn = new Scanner(System.in);
        Estudiante estudianteNuevo;
        String nombre, curso;
        int edad = 0;
        boolean crearEstudiante = false;

        do{
            System.out.println("Nombre del estudiante: ");
            nombre = scn.nextLine();

            System.out.println("Edad del estudiante: ");
            edad = Integer.parseInt(scn.nextLine());

            System.out.println("Curso del estudiante: ");
            System.out.println("1. Java\n2. Python\n3. Bases de Datos");
            curso = scn.nextLine();

            if( Estudiante.validarNombre(nombre) && Estudiante.validarEdad(edad) && Estudiante.validarCurso(curso)){
                estudianteNuevo = new Estudiante(nombre, edad, curso);
                crearEstudiante = true;
            } else {
                estudianteNuevo = new Estudiante(nombre, edad, curso);
                System.out.println("Vuelve a introducir el estudiante con los datos correctos");
            }

        } while (!crearEstudiante);

        return estudianteNuevo;
    }
}
