/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupos;
import aima.search.framework.Successor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Samitier
 */
public class Solucion {

    ArrayList<Helicoptero> helicopteros;
    Centros centros1; //chapuza
    Grupos grupos1;//chapuza
    
    public Solucion(Centros centros) {
        centros1 = centros;
        helicopteros = new ArrayList();
        for(int i=0; i<centros.size(); i++) {
            Centro c = centros.get(i);
            for(int j=0; j<c.getNHelicopteros(); ++j){
                Helicoptero h = new Helicoptero(c.getCoordX(),c.getCoordY());
                helicopteros.add(h);
            }
        }
    }
    
    void generarSolucion(Grupos grupos) {
        grupos1 = grupos;
        Random rand = new Random();
        for(int i=0; i<grupos.size();++i) {
            int heli = rand.nextInt(helicopteros.size());
            helicopteros.get(heli).introducirGrupo(grupos.get(i));
        }
    }

    List generarSuccesores() {
        ArrayList solutions = new ArrayList();
        for(int i=0; i<100; ++i) {
            Solucion sol = new Solucion(centros1);
            sol.generarSolucion(grupos1);
            solutions.add(new Successor("Shit", sol));
        }
        return solutions;
    }


    double tiempoTotalSalvamento() {
        double max, aux;
        max = aux =0;
        for(int i=0; i< helicopteros.size();++i){
            aux = helicopteros.get(i).getTiempoTotal();
            if(aux>max) max = aux;
        }
        return max;
    }
    
}
