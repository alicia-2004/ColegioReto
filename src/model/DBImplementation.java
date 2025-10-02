package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * Implementation of ClassDAO using database operations.
 * Handles all database interactions for the application.
 *
 * @author acer
 */
public class DBImplementation implements ClassDAO {

    private Connection con;
    private PreparedStatement stmt;

    // The following attributes are used to retrieve values from the config file
    private ResourceBundle configFile;
    private String driverDB;
    private String urlDB;
    private String userDB;
    private String passwordDB;

    // SQL statements
    final String SQLSELECTIIDS = "SELECT ID_S FROM TEACHINGUNIT_STATEMENT WHERE ID_T = ?";
    final String SQLSHOWSTATEMENTS = "SELECT * FROM STATEMENT WHERE ID_S = ?"; //hacer
    final String SQLADDTEACHINGUNIT = "INSERT INTO TEACHINGUNIT (ACRONYM, TITLE, ASSESSMENT, DESCRIPTION_T) VALUES(?,?,?,?)";
    final String SQLINSERTEXAMCALL = "INSERT INTO EXAMCALL VALUES(?,?,?,?,?)";
    final String SQL_CALL = "SELECT * FROM EXAMCALL WHERE ID_S = ?";
    final String SQL_VIEWTEXT = "SELECT DESCRIPTION_S, ID_S FROM STATEMENT WHERE ID_S = ?";
    final String SQL_INSERT = "INSERT INTO EXAMCALL (CALL_EXAM, DESCRIPTION_EXAM, DATE_EXAM, COURSE, ID_S) VALUES (?, ?, ?, ?, ?)";
    final String SQL_CREATESTATEMENT = "INSERT INTO STATEMENT (ID_S,DESCRIPTION_S,LEVEL_S,AVAILABLE,ROUTE) VALUES (?,?,?,?,?)";
    final String SQL_ADDUNIT = "INSERT INTO TEACHINGUNIT_STATEMENT (ID_T,ID_S) VALUES (?,?)";
    final String SQL_CREATEEXAMCALL = "INSERT INTO EXAMCALL (CALL_EXAM,DESCRIPTION_EXAM,DATE_EXAM,COURSE,ID_S) VALUES (?,?,?,?,?)";

    /**
     * Opens a database connection.
     */
    private void openConnection() {
        try {
            con = DriverManager.getConnection(urlDB, this.userDB, this.passwordDB);
        } catch (SQLException e) {
            System.out.println("Error trying to open the DB");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor that initializes the database configuration.
     */
    public DBImplementation() {
        this.configFile = ResourceBundle.getBundle("model.configClass");
        this.driverDB = this.configFile.getString("Driver");
        this.urlDB = this.configFile.getString("Conn");
        this.userDB = this.configFile.getString("DBUser");
        this.passwordDB = this.configFile.getString("DBPass");
    }

    /**
     * Retrieves teaching unit statements for a unit.
     * @param idu the unit ID
     * @return map of teaching unit statements
     */
    public Map<Integer, TeachingUnitStatement> showStatementsUnit(int idu) {
        ResultSet rs = null;
        Map<Integer, TeachingUnitStatement> teachingUnitStatement = new TreeMap<>();
        TeachingUnitStatement tus;
        //SQLSELECTIIDS

        this.openConnection();
        try {
            stmt = con.prepareStatement(SQLSELECTIIDS);
            stmt.setInt(1, idu);
            rs = stmt.executeQuery();

            while (rs.next()) {
                tus = new TeachingUnitStatement();
                tus.setStatementId(rs.getInt("ID_S"));
                teachingUnitStatement.put(tus.getStatementId(), tus);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error getting the statements: " + e.getMessage());
        }
        return teachingUnitStatement;
    }

    /**
     * Retrieves the statements associated with a teaching unit.
     * @param idu the unit ID
     * @return map of statements
     */
    @Override
    public Map<String, Statement> showStatements(int idu) {
        ResultSet rs = null;
        Map<Integer, TeachingUnitStatement> teachingUnitStatement;
        teachingUnitStatement = new TreeMap<>();
        teachingUnitStatement = showStatementsUnit(idu);
        Map<String, Statement> statements = new TreeMap<>();
        Statement st;
        int s;

        this.openConnection();
        try {
        for (Map.Entry<Integer, TeachingUnitStatement> suobj : teachingUnitStatement.entrySet()) {
            
                stmt = con.prepareStatement(SQLSHOWSTATEMENTS);
                stmt.setInt(1, suobj.getValue().getStatementId());
                rs = stmt.executeQuery();



                while (rs.next()) {
                    st = new Statement();
                    st.setId(rs.getInt("ID_S"));
                    st.setDescription(rs.getString("DESCRIPTION_S"));
                    st.setLevel(Difficulty.valueOf(rs.getString("LEVEL_S")));

                    st.setAvailable(rs.getBoolean("AVAILABLE"));
                    st.setPath(rs.getString("ROUTE"));
                    
                    statements.put(st.getDescription(), st);
                }
                
            

            }
                rs.close();
                stmt.close();
                con.close();
            }catch (SQLException e) {
                System.out.println("Error getting the statements: " + e.getMessage());
        


    }
        return statements;
    }

    /**
     * Inserts a new teaching unit into the database.
     * @param acronym the acronym
     * @param title the title
     * @param assessment the assessment
     * @param description the description
     * @return true if successful, false otherwise
     */
    @Override
    public boolean insertTeachingUnit(String acronym, String title, String assessment, String description) {
        boolean success = false;

        this.openConnection();

        try {
            stmt = con.prepareStatement(SQLADDTEACHINGUNIT);
            stmt.setString(1, acronym);
            stmt.setString(2, title);
            stmt.setString(3, assessment);
            stmt.setString(4, description);

            if (stmt.executeUpdate() > 0) {
                success = true;
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error adding teaching unit: " + e.getMessage());
        }

        return success;
    }

    /**
     * Inserts a new exam call into the database.
     * @param call the call name
     * @param description the description
     * @param date the date
     * @param course the course
     * @param idE the statement ID
     * @return true if successful, false otherwise
     */
    @Override
    public boolean insertExamCall(String call, String description, LocalDate date, String course, int idE) {
        boolean success = false;

        this.openConnection();

        try {
            stmt = con.prepareStatement(SQLINSERTEXAMCALL);
            stmt.setString(1, call);
            stmt.setString(2, description);
            stmt.setDate(3, java.sql.Date.valueOf(date));
            stmt.setString(4, course);
            stmt.setInt(5, idE);

            if (stmt.executeUpdate() > 0) {
                success = true;
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error adding a exam call: " + e.getMessage());
        }

        return success;
    }
    
    /**
     * Consults the exam calls associated with a statement.
     * @param id_S the statement ID
     * @return map of exam calls
     */
    @Override
    public Map<String, ExamCall> consultCalls(int id_S) {
        ResultSet rs = null;
        Map<String, ExamCall> calls = new TreeMap<>();
        ExamCall call;

        this.openConnection();

        try {
            stmt = con.prepareStatement(SQL_CALL);
            stmt.setInt(1, id_S);
            rs = stmt.executeQuery();

            while (rs.next()) {
                call = new ExamCall();
                call.setCall(rs.getString("CALL_EXAM"));
                call.setDescription(rs.getString("DESCRIPTION_EXAM"));
                call.setDate(rs.getDate("DATE_EXAM").toLocalDate());
                call.setCourse(rs.getString("COURSE"));
                call.setIdE(rs.getInt("ID_S"));
                calls.put(call.getCall(), call);
            }

            rs.close();
            stmt.close();
            con.close();
            
            } catch (SQLException e) {
			System.out.println("Error to consult calls: " + e.getMessage());
            }
            return calls;
    }

    /**
     * Views the text document for a statement.
     * @param id the statement ID
     * @return map of statements
     */
    @Override
    public Map<Integer, Statement> viewTextDocument(int id) {
    Map<Integer, Statement> statements = new TreeMap<>();
    this.openConnection();

    try {
        stmt = con.prepareStatement(SQL_VIEWTEXT);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Statement statement = new Statement();
            statement.setDescription(rs.getString("DESCRIPTION_S")); 
            statement.setId(rs.getInt("ID_S"));
            
            statements.put(statement.getId(), statement);
        }

        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error to view a text document: " + e.getMessage());
    }

    return statements;
    }
    
    /**
     * Assigns a statement to an exam call.
     * @param callExam the exam call name
     * @param desc the description
     * @param fecha the date
     * @param course the course
     * @param idS the statement ID
     * @return true if successful
     */
    @Override
    public boolean assignStatementToExamCall(String callExam, String desc, LocalDate fecha, String course, int idS) {
    boolean success = false;
    this.openConnection(); 

    try {
        stmt = con.prepareStatement(SQL_CREATEEXAMCALL);
        stmt.setString(1, callExam);
        stmt.setString(2, desc);
        stmt.setDate(3, java.sql.Date.valueOf(fecha));
        stmt.setString(4, course);
        stmt.setInt(5, idS);

        if (stmt.executeUpdate() > 0) {
            success = true;
        }

        stmt.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error adding a statement: " + e.getMessage());
    }

    return success; 
    }
    
    /**
     * Creates a new statement.
     * @param idS the ID
     * @param desc the description
     * @param level the difficulty level
     * @param available availability
     * @param path the path
     * @return true if successful
     */
    @Override
    public boolean createStatement (int idS, String desc, Difficulty level, boolean available, String path) {
    boolean success = false;
    this.openConnection(); 

    try {
        stmt = con.prepareStatement(SQL_CREATESTATEMENT);
        stmt.setInt(1, idS);
        stmt.setString(2, desc);
        stmt.setString(3, level.name());
        stmt.setBoolean(4, available);
        stmt.setString(5, path);

        if (stmt.executeUpdate() > 0) {
            success = true;
        }

        stmt.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error adding a statement: " + e.getMessage());
    }

    return success; 
    }
    
    /**
     * Adds teaching units to a statement.
     * @param id_U the unit ID
     * @param id_S the statement ID
     * @return true if successful
     */
    @Override
    public boolean addUnitsToAStatement (int id_U, int id_S) {
    boolean success = false;
    this.openConnection(); 

    try {
        stmt = con.prepareStatement(SQL_ADDUNIT);
        stmt.setInt(1, id_U);
        stmt.setInt(2, id_S);

        if (stmt.executeUpdate() > 0) {
            success = true;
        }

        stmt.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error adding a statement: " + e.getMessage());
    }

    return success; 
    }
}
