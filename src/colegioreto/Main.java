/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegioreto;

import utilidades.Utilidades;

/**
 *
 * @author Deusto
 */
public class Main {
    
    public static int menu() {
	int op;
        System.out.println("------------------------------------");
	System.out.println("1. Agregar unidad didactica");
	System.out.println("3. Borrar convocatoria de examen");
	System.out.println("2. Ver enunciados");
	System.out.println("4. Modificar enunciado");
	System.out.println("5. Salir");
        System.out.println("------------------------------------");
	op=Utilidades.leerInt(1,5);
	return op;
    }
    
    public static void agregarUnidadDidactica () {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        do{
            switch(op=menu()){
                case 1:
                    agregarUnidadDidactica ();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while(op!=5);
    }
    
}
