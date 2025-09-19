/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioreto;

import model.Controller;
import utilidades.Utilidades;

/**
 *
 * @author Deusto
 */
public class Main {

    public static int menu() {
        int op;
        System.out.println("------------------------------------");
        System.out.println("1. Create a teaching unit (Unit) and an exam session (Session).");
        System.out.println("2. Create an exam statement by adding the teaching units that it will refer to. The session for\n"
                + "which it is created will also be associated\n"
                + "with this statement.");
        System.out.println("3. Consult the exam statements in which a\n"
                + "specific teaching unit is covered.");
        System.out.println("4. Consult in which sessions a specific\n"
                + "statement has been used.");
        System.out.println("5. View the text document associated with a\n"
                + "statement.");
        System.out.println("6. Assign a statement to a session.");
        System.out.println("7. Exit");
        System.out.println("------------------------------------");
        op = Utilidades.leerInt(1, 5);
        return op;
    }

    public static void agregarUnidadDidactica(Controller cont) {
        String acronimo, titulo, evaluacion, descripcion;
        System.out.println("Inserte el acornimo que se usara:");
        acronimo = Utilidades.introducirCadena();
        System.out.println("Inserte el titulo que se usara: ");
        titulo = Utilidades.introducirCadena();
        System.out.println("Inserte la evaluacion a la que pertenecera: ");
        evaluacion = Utilidades.introducirCadena();
        System.out.println("Inserte una descripcion: ");
        descripcion = Utilidades.introducirCadena();

        cont.insertarUnidad(acronimo, titulo, evaluacion, descripcion);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        Controller cont = new Controller();
        do {
            switch (op = menu()) {
                case 1:
                    agregarUnidadDidactica(cont);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (op != 5);
    }

}
