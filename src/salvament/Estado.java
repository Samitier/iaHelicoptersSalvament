/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.*;
import java.util.List;

/**
 *
 * @author Samitier
 */
public class Estado {

    ////Variables del problema///////
    final int NUM_CENTROS = 5;
    final int NUM_HELICOPTEROS = 1;
    final int NUM_GRUPOS = 100;
    ////////////////////////////////
   
    final int SEED = 1234;
    
    Centros centros;
    Grupos grupos;
    Solucion solucion;
    
    public Estado() {
    }

    void generarProblema() {
        centros = new Centros(NUM_CENTROS, NUM_HELICOPTEROS, SEED);
        grupos =  new Grupos(NUM_GRUPOS, SEED);
    }

    void generarSolucion() {
        solucion = new Solucion(centros);
        solucion.generarSolucion1(grupos,centros);
    }  
}
