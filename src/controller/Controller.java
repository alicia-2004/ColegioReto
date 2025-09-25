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
import model.*;


public class Controller {
    
    ClassDAO dao = new DBImplementation();
    
    public Map<Integer, TeachingUnitStatement> showStatementsUnit(int idu) {
        return dao.showStatementsUnit(idu);
    }
    
    Map<String, Statement> showStatements(int idu) {
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
    
    public String viewTextDocument(int id_S) {
        return dao.viewTextDocument(id_S);
    }
    
    public boolean createStatement(int id, String desc, Difficulty level, boolean available, String path){
        return dao.createStatement(id, desc, level, available, path);
    }
    
    public boolean addUnit(int id_s,int id_t) {
        return dao.addUnit(id_s, id_t);
    }
}
