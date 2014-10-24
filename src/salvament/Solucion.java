/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupo;
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

    public Solucion(Solucion sol) {
        helicopteros = new ArrayList();
        for(Helicoptero heli:sol.helicopteros ){
            Helicoptero helico = new Helicoptero(heli);
            helicopteros.add(helico);
        }
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
        double max;
        max = 0;
        for(Helicoptero heli: helicopteros){
           max += heli.getTiempoTotal();
        }
        return max;
    }

    boolean intercambiarGrupos(int heli, int viajes, Grupo grupo, int heli2, int viajes2, int grupos2) {
        Grupo grupo2 = helicopteros.get(heli2).viajes.get(viajes2).grupos.get(grupos2);
        if(((helicopteros.get(heli).viajes.get(viajes).npersonas + grupo2.getNPersonas()) <= 15) &&
            ((helicopteros.get(heli2).viajes.get(viajes2).npersonas + grupo.getNPersonas()) <= 15)) {
            helicopteros.get(heli2).borrarGrupo(viajes2, grupos2);
            helicopteros.get(heli2).introducirGrupo(grupo, viajes2);
            helicopteros.get(heli).introducirGrupo(grupo2, viajes);
            return true;
        }
        return false;
    }
    
}
