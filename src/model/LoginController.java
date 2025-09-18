/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author acer
 */

import java.util.Map;
import model.*;

public class LoginController {
    
    ClaseDAO dao = new ImplementacionDB();
    
    
    public Map <String,Enunciado> mostrarEnunciados () {
        return dao.mostrarEnunciados();
    }
    
    public boolean insertarUnidad (int id,String acronimo,String calificacion,String evaluacion,String descripcion){
        return dao.insertarUnidad(id,acronimo,calificacion,evaluacion,descripcion);
    }
}
