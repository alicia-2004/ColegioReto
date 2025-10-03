package colegioreto;

import controller.Controller;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import model.Difficulty;
import model.ExamCall;
import model.Statement;
import utilities.Utilities;

/**
 * Main class for the Colegio Reto application.
 * This class provides the main menu and handles user interactions for managing teaching units, exam calls, and statements.
 *
 * @author Deusto
 */
public class Main {

    /**
     * Displays the main menu options and reads the user's choice.
     * @return the selected menu option as an integer
     */
    public static int menu() {
        int op;
        System.out.println("------------------------------------");
        System.out.println("1. Create a teaching UNITS .");
        System.out.println("2. Create an EXAMCALL (session).");
        System.out.println("3. Create an STATEMENT by adding the UNITS it will refer to. The EXAMCALL for which it is created will also be associated.");
        System.out.println("4. Consult the STATEMENTS in which a specific UNIT is covered.");
        System.out.println("5. Consult in which EXAMCALL a specific STATEMENTS has been used.");
        System.out.println("6. View the description associated with a STATEMENTS.");
        System.out.println("7. Assign a STATEMENTS to a EXAMCALL.");
        System.out.println("8. Exit");
        System.out.println("------------------------------------");
        op = Utilities.leerInt(1, 8);
        return op;
    }
    

    /**
     * Shows the statements associated with a specific teaching unit.
     * @param cont the Controller instance to interact with the model
     */
    public static void showStatements(Controller cont) {
        int idu;
        Map<String, Statement> statements = new TreeMap<>();
        System.out.println("Insert the number of the unit you want to filter by: ");
        idu = Utilities.leerInt();
        statements = cont.showStatements(idu);

        for (Statement st : statements.values()) {
            System.out.println("--------------------------------------");
            System.out.println("ID: " + st.getId());
            System.out.println("Description: " + st.getDescription());
            System.out.println("Level: " + st.getLevel().toString());
            System.out.println("Avaliable: " + st.getAvailable());
            System.out.println("Path: " + st.getPath());
        }
    }

    /**
     * Inserts a new teaching unit into the system.
     * @param cont the Controller instance to interact with the model
     */
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

    /**
     * Inserts a new exam call into the system.
     * @param cont the Controller instance to interact with the model
     */
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
    
    
    /**
     * Creates a new statement and returns its ID.
     * @param cont the Controller instance to interact with the model
     * @return the ID of the created statement, or -1 if failed
     */
    public static int createStatement(Controller cont) {
    int idS, error = -1;
    String desc, path, available,enume;
    Difficulty level=null;
    boolean isAvailable;
        
    System.out.println("Enter Statement ID:");
    idS = Utilities.leerInt();

    System.out.println("Enter description:");
    desc = Utilities.introducirCadena();

    while (level == null) {
            System.out.println("Enter difficulty (LOW, AVERAGE, HIGH):");
            enume = Utilities.introducirCadena().toUpperCase();

            try {
                level = Difficulty.valueOf(enume);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option. Please enter LOW, AVERAGE, or HIGH.");
            }
    }

    System.out.println("Is it available? (true/false):");
    available = Utilities.introducirCadena("true","false");
    isAvailable = Boolean.parseBoolean(available);

    System.out.println("Enter file path:");
    path = Utilities.introducirCadena();

    if (cont.createStatement(idS, desc, level, isAvailable, path)) {
        System.out.println("Statement created successfully!");
        return idS;
    } else {
        return error; 
    }
}
    
    /**
     * Creates a statement with associated teaching units and exam call.
     * @param cont the Controller instance to interact with the model
     */
    public static void createStatementWithUnitsAndExamCall(Controller cont) {
    int idS,numUnits,idU,id_s;
    String call,description,course;
    LocalDate date;
    
    idS = createStatement(cont);
    
    if (idS == -1) {
        System.out.println("Error creating statement.");
    } else {
    System.out.println("How many teaching units do you want to add?");
    numUnits = Utilities.leerInt();

    for (int i = 0; i < numUnits; i++) {
        System.out.println("Enter Unit ID:");
        idU = Utilities.leerInt();

        if (cont.addUnitsToAStatement(idU, idS)) {
            System.out.println("Unit " + idU + " added to Statement " + idS);
        } else {
            System.out.println("Error adding unit " + idU);
        }
    }

    System.out.println("Insert the exam call (session):");
    call = Utilities.introducirCadena();
    System.out.println("Insert the description: ");
    description = Utilities.introducirCadena();
    System.out.println("Insert the date (dd/MM/yyyy): ");
    date = Utilities.leerFechaDMA();
    System.out.println("Insert a course: ");
    course = Utilities.introducirCadena();

    id_s = idS;
    
    System.out.println("Statement added to ExamCall " + idS);
    cont.insertExamCall(call, description, date, course, id_s); 
    }
}
    
    /**
     * Consults the exam calls associated with a specific statement.
     * @param cont the Controller instance to interact with the model
     */
    public static void consultCalls(Controller cont) {
    int ids;
    Map<String, ExamCall> calls = new TreeMap<>();
    System.out.println("Enter the ID of the Statement used to view its calls: ");
    ids = Utilities.leerInt();
    calls = cont.consultCalls(ids);

    for (ExamCall ec : calls.values()) {
        System.out.println("--------------------------------------");
        System.out.println("CALL: " + ec.getCall());
        System.out.println("DESCRIPTION: " + ec.getDescription());
        System.out.println("DATE: " + ec.getDate());
        System.out.println("COURSE: " + ec.getCourse());
        System.out.println("ID_STATEMENT: " + ec.getIdE());
    }
    }

    /**
     * Views the text document associated with a specific statement.
     * @param cont the Controller instance to interact with the model
     */
    public static void viewTextDocument(Controller cont) {
    System.out.println("Enter the id of the Statement to display its description: ");
    int id = Utilities.leerInt();

    Map<Integer, Statement> statements = cont.viewTextDocument(id);

    Statement st = statements.get(id);
    if (st != null) {
        System.out.println("DESCRIPTION: " + st.getDescription());
    } else {
        System.out.println("No statement was found with that id.");
    }
    }


    /**
     * Assigns a statement to an exam call.
     * @param cont the Controller instance to interact with the model
     */
    public static void assignStatementToExamCall(Controller cont) {
    String callExam, desc, course;
    int idS;
    LocalDate fecha;
    System.out.println("Please enter the call:");
    callExam = Utilities.introducirCadena();
    System.out.println("Please enter the description:");
    desc = Utilities.introducirCadena();
    System.out.println("Date:");
    fecha = Utilities.leerFechaDMA();
    System.out.println("Course:");
    course = Utilities.introducirCadena();
    System.out.println("Id of the statement:");
    idS = Utilities.leerInt();

    cont.assignStatementToExamCall(callExam,desc,fecha,course,idS);
    System.out.println("It was entered correctly");
    }

    /**
     * Main method to run the application.
     * @param args command line arguments
     */
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
                    createStatementWithUnitsAndExamCall(cont);
                    break;
                case 4:
                    showStatements(cont);
                    break;
                case 5:
                    consultCalls(cont);
                    break;
                case 6:
                    viewTextDocument(cont);
                    break;
                case 7:
                    assignStatementToExamCall(cont);
                    break;
                case 8:
                    System.out.println("Bye, Bye :)");
                    break;
            }
        } while (op != 8);
    }
}
