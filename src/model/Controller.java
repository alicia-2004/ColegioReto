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

import java.util.Date;
import java.util.Map;


public class Controller {
    
    ClaseDAO dao = new ImplementacionDB();
    
    
    public Map <String,Enunciado> mostrarEnunciados () {
        return dao.mostrarEnunciados();
    }
    
    public boolean insertarUnidad (String acronimo, String titulo, String evaluacion, String descripcion){
        return dao.insertarUnidad(acronimo, titulo, evaluacion, descripcion);
    }
    
    public boolean insertarConvocatoriaExamen(String convocatoria,String descripcion,Date fecha,String curso, int idE){
        return dao.insertarConvocatoriaExamen(convocatoria, descripcion, fecha, curso, idE);
    }
}
