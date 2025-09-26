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
}
