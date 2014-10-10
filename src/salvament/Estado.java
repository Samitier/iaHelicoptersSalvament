/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.*;

/**
 *
 * @author Samitier
 */
public class Estado {

    final int NUM_CENTROS = 5;
    final int NUM_HELICOPTEROS = 1;
    final int NUM_GRUPOS = 100;
    final int SEED = 1234;
    
    Centros centros;
    Grupos grupos;
    Viajes viajes;
    
    public Estado() {
    }

    void generarProblema() {
        centros = new Centros(NUM_CENTROS, NUM_HELICOPTEROS, SEED);
        grupos =  new Grupos(NUM_GRUPOS, SEED);
        grupos.get(2).getCoordX();
    }

    void generarSolucion() {
        
    }
    
}
