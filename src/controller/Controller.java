/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 * Controller class that acts as an intermediary between the view and the model.
 * It handles business logic and delegates data operations to the DAO.
 *
 * @author acer
 */

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import model.ClassDAO;
import model.Statement;
import model.DBImplementation;
import model.Difficulty;
import model.ExamCall;
import model.TeachingUnitStatement;


public class Controller {
    
    ClassDAO dao = new DBImplementation();
    
    /**
     * Retrieves the statements associated with a teaching unit.
     * @param idu the ID of the teaching unit
     * @return a map of statements
     */
    public Map<String, Statement> showStatements(int idu) {
        return dao.showStatements(idu);
    }
    
    /**
     * Inserts a new teaching unit.
     * @param acronym the acronym of the unit
     * @param title the title of the unit
     * @param assessment the assessment
     * @param description the description
     * @return true if successful, false otherwise
     */
    public boolean insertTeachingUnit(String acronym, String title, String assessment, String description) {
        return dao.insertTeachingUnit(acronym, title, assessment, description);
    }
    
    /**
     * Inserts a new exam call.
     * @param call the call name
     * @param description the description
     * @param date the date
     * @param course the course
     * @param idE the statement ID
     * @return true if successful, false otherwise
     */
    public boolean insertExamCall(String call, String description, LocalDate date, String course, int idE) {
        return dao.insertExamCall(call, description, date, course, idE);
    }
    
    /**
     * Consults the exam calls for a statement.
     * @param id_S the statement ID
     * @return a map of exam calls
     */
    public Map<String, ExamCall> consultCalls(int id_S) {
        return dao.consultCalls(id_S);
    }
    
    /**
     * Views the text document for a statement.
     * @param id the statement ID
     * @return a map of statements
     */
    public Map<Integer, Statement> viewTextDocument(int id) {
        return dao.viewTextDocument(id);
    }
    
    /**
     * Assigns a statement to an exam call.
     * @param callExam the exam call name
     * @param desc the description
     * @param fecha the date
     * @param course the course
     * @param idS the statement ID
     * @return true if successful, false otherwise
     */
    public boolean assignStatementToExamCall(String callExam, String desc, LocalDate fecha, String course, int idS) {
        return dao.assignStatementToExamCall(callExam, desc, fecha, course, idS);
    }
    
    /**
     * Creates a new statement.
     * @param idS the statement ID
     * @param desc the description
     * @param level the difficulty level
     * @param available availability
     * @param path the file path
     * @return true if successful, false otherwise
     */
    public boolean createStatement (int idS, String desc, Difficulty level, boolean available, String path) {
        return dao.createStatement(idS, desc, level, available, path);
    }
    
    /**
     * Adds teaching units to a statement.
     * @param id_U the unit ID
     * @param id_S the statement ID
     * @return true if successful, false otherwise
     */
    public boolean addUnitsToAStatement (int id_U, int id_S) {
        return dao.addUnitsToAStatement(id_U, id_S);
    }
}
