package colegioreto;

import controller.Controller;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import model.Statement;
import utilities.Utilities;

/**
 *
 * @author Deusto
 */
public class Main {

    public static int menu() {
        int op;
        System.out.println("------------------------------------");
        System.out.println("1. Create a teaching UNITS .");
        System.out.println("2. Create an EXAMCALL (session).");
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
    
    public static 

    public static void showStatements(Controller cont) {
        int idu;
        Map<String, Statement> statements = new TreeMap<>();
        System.out.println();
        idu = Utilities.leerInt();
        statements = cont.showStatements(idu);

        for (Statement st : statements.values()) {
            System.out.println("ID: " + st.getId());
            System.out.println("Description: " + st.getDescription());
            System.out.println("Level: " + st.getLevel().toString());
            System.out.println("Avaliable: " + st.getAvailable());
            System.out.println("Path: " + st.getPath());
        }
    }

    public static void insertTeachingUnit(Controller cont) {
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

    public static void insertExamCall(Controller cont) {

        String call, description, course;
        LocalDate date;
        int id_s;

        System.out.println("Insert the exam call (session):");
        call = Utilities.introducirCadena();
        System.out.println("Insert the description: ");
        description = Utilities.introducirCadena();
        System.out.println("Insert the date (dd/MM/yyyy): ");
        date = Utilities.leerFechaDMA();
        System.out.println("Insert a course: ");
        course = Utilities.introducirCadena();
        System.out.println("Insert the id associated with a statement: ");
        id_s = Utilities.leerInt(0, 1000);

        cont.insertExamCall(call, description, date, course, id_s);

    }

    public static void main(String[] args) {
        int op;
        Controller cont = new Controller();
        do {
            switch (op = menu()) {
                case 1:
                    insertTeachingUnit(cont);
                    break;
                case 2:
                    insertExamCall(cont);
                    break;
                case 3:
                    // to implement
                    break;
                case 4:
                    showStatements(cont);
                    break;
                case 5:
                    // to implement
                    break;
                case 6:
                    // to implement
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Bye, Bye :)");
                    break;
            }
        } while (op != 8);
    }
}
