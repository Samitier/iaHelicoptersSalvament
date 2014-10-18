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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samitier
 */
public class Solucion implements Cloneable{

    ArrayList<Helicoptero> helicopteros;

    public Solucion() {
    }
    
    @Override
    protected Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Solucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Solucion(Centros centros) {
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
        Random rand = new Random();
        for(int i=0; i<grupos.size();++i) {
            int heli = rand.nextInt(helicopteros.size());
            helicopteros.get(heli).introducirGrupo(grupos.get(i));
        }
    }

    double getTiempoTotalSalvamento() {
        double max, aux;
        max = aux =0;
        for(Helicoptero heli: helicopteros){
            aux = heli.getTiempoTotal();
            if(aux>max) max = aux;
        }
        return max;
    }
    
}
