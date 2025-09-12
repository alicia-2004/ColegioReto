/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deusto
 */
public class UnidadDidactica {
    private int id;
    private String acronimo;
    private String evaluacion;
    private String descripcion;

    public UnidadDidactica(int id, String acronimo, String evaluacion, String descripcion) {
        this.id = id;
        this.acronimo = acronimo;
        this.evaluacion = evaluacion;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "UnidadDidactica{" + "id=" + id + ", acronimo=" + acronimo + ", evaluacion=" + evaluacion + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
