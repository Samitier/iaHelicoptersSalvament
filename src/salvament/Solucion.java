/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Samitier
 */
public class Solucion {

    ArrayList<Helicoptero> helicopteros;
    
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

    List generarSuccesores() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    boolean esSolucionFinal() {
        return true;
    }

    double obtenerHeuristico() {
        int max, aux;
        max = aux =0;
        for(int i=0; i< helicopteros.size();++i){
            helicopteros.get(i).
        }
        return solucio;
    }
    void(){
    int guarro = 0;
    }
    
}
