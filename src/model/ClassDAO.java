/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Map;

/**
 * Interface for data access operations in the Colegio Reto application.
 * Defines methods for managing teaching units, exam calls, and statements.
 *
 * @author acer
 */
public interface ClassDAO {

    /**
     * Inserts a new teaching unit.
     * @param acronym the acronym
     * @param title the title
     * @param assessment the assessment
     * @param description the description
     * @return true if successful
     */
    boolean insertTeachingUnit(String acronym, String title, String assessment, String description);
    
    /**
     * Retrieves statements for a teaching unit.
     * @param idu the unit ID
     * @return map of statements
     */
    Map<String, Statement> showStatements(int idu);

    /**
     * Inserts a new exam call.
     * @param call the call
     * @param description the description
     * @param date the date
     * @param course the course
     * @param idE the statement ID
     * @return true if successful
     */
    boolean insertExamCall(String call, String description, LocalDate date, String course, int idE);
    
    /**
     * Consults exam calls for a statement.
     * @param id_S the statement ID
     * @return map of exam calls
     */
    Map<String, ExamCall> consultCalls(int id_S);
    
    /**
     * Views the text document for a statement.
     * @param id the statement ID
     * @return map of statements
     */
    Map<Integer, Statement> viewTextDocument(int id);
    
    /**
     * Assigns a statement to an exam call.
     * @param callExam the exam call
     * @param desc the description
     * @param fecha the date
     * @param course the course
     * @param idS the statement ID
     * @return true if successful
     */
    boolean assignStatementToExamCall(String callExam, String desc, LocalDate fecha, String course, int idS);
    
    /**
     * Creates a new statement.
     * @param idS the ID
     * @param desc the description
     * @param level the difficulty
     * @param available availability
     * @param path the path
     * @return true if successful
     */
    boolean createStatement (int idS, String desc, Difficulty level, boolean available, String path);
    
    /**
     * Adds units to a statement.
     * @param id_U the unit ID
     * @param id_S the statement ID
     * @return true if successful
     */
    boolean addUnitsToAStatement (int id_U, int id_S);

}
