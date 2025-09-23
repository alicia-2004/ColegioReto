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
    final String SQLSHOWSTATEMENTS = "SELECT DESCRIPTION_S FROM STATEMENT";
    final String SQLADDTEACHINGUNIT = "INSERT INTO TEACHINGUNIT (ACRONYM, TITLE, ASSESSMENT, DESCRIPTION_T) VALUES(?,?,?,?)";
    final String SQLINSERTEXAMCALL = "INSERT INTO EXAMCALL VALUES(?,?,?,?,?)";
    final String SQL_CALL ="SELECT * FROM EXAMCALL WHERE ID_S = ?";
    final String SQL_VIEWTEXT = "SELECT DESCRIPTION_S FROM STATEMENT WHERE ID_S = ?";
    final String SQL_INSERT = "INSERT INTO EXAMCALL (CALL_EXAM, DESCRIPTION_EXAM, DATE_EXAM, COURSE, ID_S) VALUES (?, ?, ?, ?, ?)";

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

    public DBImplementation() {
        this.configFile = ResourceBundle.getBundle("model.configClass");
        this.driverDB = this.configFile.getString("Driver");
        this.urlDB = this.configFile.getString("Conn");
        this.userDB = this.configFile.getString("DBUser");
        this.passwordDB = this.configFile.getString("DBPass");
    }
    
    @Override
    public Map<String, Statement> showStatements() {
        ResultSet rs = null;
        Map<String, Statement> statements = new TreeMap<>();
        Statement st;
        
        this.openConnection();
        
        try {
            stmt = con.prepareStatement(SQLSHOWSTATEMENTS);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                st = new Statement();
                st.setDescription(rs.getString("DESCRIPTION_S"));
                statements.put(st.getDescription(), st);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error getting the statements: " + e.getMessage());
        }
        return statements;
    }
    
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
            System.out.println("Error adding exam call: " + e.getMessage());
        }
        
        return success;
    }
    
    public Map <String, ExamCall> consultCalls (int id_S) {
        ResultSet rs = null;
	Map<String,ExamCall> calls = new TreeMap<>();
	ExamCall call;
		
	this.openConnection();
		
	try {
            stmt = con.prepareStatement(SQL_CALL);
            stmt.setInt(1, id_S); 
            rs = stmt.executeQuery();

            while (rs.next()) {
		call = new ExamCall();
		call.setCall(rs.getString("CALL_EXAM"));
		call.setDescription(rs.getString("DESCRIPTION"));
		call.setDate(rs.getDate("DATE_EXAM").toLocalDate());
		call.setCourse(rs.getString("COURSE"));
                call.setIdE(rs.getInt("ID_S"));
		calls.put(call.getCall(), call);
            }

            rs.close();
            stmt.close();
            con.close();
            } catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
            }
            return calls;
    }
    
    public String viewTextDocument(int id_S) {
    String description = null;

    this.openConnection();

    try {
        stmt = con.prepareStatement(SQL_VIEWTEXT);
        stmt.setInt(1, id_S);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            description = rs.getString("DESCRIPTION_S");
        }

        rs.close();
        stmt.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return description;
    }
	
    @Override
    public boolean insertExamCall(String callExam, String descriptionExam, LocalDate dateExam, String course, int idStatement) {
    boolean success = false;
    this.openConnection(); 

    try {
        stmt = con.prepareStatement(SQL_INSERT);
        stmt.setString(1, callExam);
        stmt.setString(2, descriptionExam);
        stmt.setDate(3, java.sql.Date.valueOf(dateExam));
        stmt.setString(4, course);
        stmt.setInt(5, idStatement);

        if (stmt.executeUpdate() > 0) {
            success = true;
        }

        stmt.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error adding exam call: " + e.getMessage());
    }

    return success;
    }
}