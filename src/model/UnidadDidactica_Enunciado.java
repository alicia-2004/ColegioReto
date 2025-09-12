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
public class UnidadDidactica_Enunciado {
    private int idUD;
    private int idE;

    public UnidadDidactica_Enunciado(int idUD, int idE) {
        this.idUD = idUD;
        this.idE = idE;
    }

    @Override
    public String toString() {
        return "UnidadDidactica_Enunciado{" + "idUD=" + idUD + ", idE=" + idE + '}';
    }
    
    
    
    
}
