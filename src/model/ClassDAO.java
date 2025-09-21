/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author acer
 */
public interface ClassDAO {

    boolean insertTeachingUnit(String acronym, String title, String assessment, String description);

    Map<String, Statement> showStatements();

    boolean insertExamCall(String call, String description, Date date, String course, int idE);
}
