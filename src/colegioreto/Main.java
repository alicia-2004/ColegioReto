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
        System.out.println("1. Create a teaching unit (Unit) and an exam session (Session).");
        System.out.println("2. Create an exam statement by adding the teaching units it will refer to. The session for\n"
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
        op = Utilities.leerInt(1, 7);
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
        } while (op != 7);
    }
}
