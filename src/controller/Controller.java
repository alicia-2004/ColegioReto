/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
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
    
    public Map<String, Statement> showStatements(int idu) {
        return dao.showStatements(idu);
    }
    
    public boolean insertTeachingUnit(String acronym, String title, String assessment, String description) {
        return dao.insertTeachingUnit(acronym, title, assessment, description);
    }
    
    public boolean insertExamCall(String call, String description, LocalDate date, String course, int idE) {
        return dao.insertExamCall(call, description, date, course, idE);
    }
    
    public Map<String, ExamCall> consultCalls(int id_S) {
        return dao.consultCalls(id_S);
    }
    
    public Map<Integer, Statement> viewTextDocument(int id) {
        return dao.viewTextDocument(id);
    }
    
    public boolean assignStatementToExamCall(String callExam, String desc, LocalDate fecha, String course, int idS) {
        return dao.assignStatementToExamCall(callExam, desc, fecha, course, idS);
    }
    
    public boolean createStatement (int idS, String desc, Difficulty level, boolean available, String path) {
        return dao.createStatement(idS, desc, level, available, path);
    }
    
    public boolean addUnitsToAStatement (int id_U, int id_S) {
        return dao.addUnitsToAStatement(id_U, id_S);
    }
}
