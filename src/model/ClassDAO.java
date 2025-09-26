/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface ClassDAO {

    boolean insertTeachingUnit(String acronym, String title, String assessment, String description);
    
    Map<String, Statement> showStatements(int idu);

    boolean insertExamCall(String call, String description, LocalDate date, String course, int idE);
    
    Map<String, ExamCall> consultCalls(int id_S);
    
    String viewTextDocument(int id_S);

}
