/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;

/**
 *
 * @author acer
 */
public interface ClaseDAO {
    
    public boolean insertarUnidad (int id,String acronimo,String calificacion,String evaluacion,String descripcion);
    
    public Map <String,Enunciado> mostrarEnunciados ();
}
