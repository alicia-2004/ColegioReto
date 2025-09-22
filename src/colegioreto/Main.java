package colegioreto;

import controller.Controller;
import utilities.Utilities;

/**
 *
 * @author Deusto
 */
public class Main {

    public static int menu() {
        int op;
        System.out.println("------------------------------------");
        System.out.println("1. Create a teaching unit (Unit) .");
        System.out.println("2. Create an exam session (examCall).");
        System.out.println("3. Create an STATEMENT by adding the UNITS it will refer to. The EXAMCALL for which it is created will also be associated.");
        System.out.println("4. Consult the STATEMENTS in which a specific UNIT is covered.");
        System.out.println("5. Consult in which EXAMCALL a specific STATEMENTS has been used.");
        System.out.println("6. View the text document associated with a STATEMENTS.");
        System.out.println("7. Assign a STATEMENTS to a EXAMCALL.");
        System.out.println("8. Exit");
        System.out.println("------------------------------------");
        op = Utilities.leerInt(1, 8);
        return op;
    }

    public static void addTeachingUnit(Controller cont) {
        String acronym, title, assessment, description;
        System.out.println("Insert the acronym to be used:");
        acronym = Utilities.introducirCadena();
        System.out.println("Insert the title to be used: ");
        title = Utilities.introducirCadena();
        System.out.println("Insert the assessment it belongs to: ");
        assessment = Utilities.introducirCadena();
        System.out.println("Insert a description: ");
        description = Utilities.introducirCadena();

        cont.insertTeachingUnit(acronym, title, assessment, description);
    }

    public static void main(String[] args) {
        int op;
        Controller cont = new Controller();
        do {
            switch (op = menu()) {
                case 1:
                    addTeachingUnit(cont);
                    break;
                case 2:
                    // to implement
                    break;
                case 3:
                    // to implement
                    break;
                case 4:
                    // to implement
                    break;
                case 5:
                    // to implement
                    break;
                case 6:
                    // to implement
                    break;
            }
        } while (op != 8);
    }
}
