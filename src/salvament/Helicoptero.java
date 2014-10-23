/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.Grupo;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Samitier
 */
public class Helicoptero {
    
    int posx, posy;
    ArrayList<Viaje> viajes;

    public Helicoptero(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        viajes = new ArrayList();
    }
    
    public void introducirGrupo(Grupo grupo) {
        if(viajes.isEmpty()) {
            Viaje vi = new Viaje(posx,posy);
            vi.introducirGrupo(grupo);
        }
        else {
            boolean found = false;
            for(int i=0; i< viajes.size()&&!found; ++i) {
                if(viajes.get(i).introducirGrupo(grupo) != false) {
                    found = true;
                }
            }
            if(!found) {
                Viaje vi = new Viaje(posx,posy);
                vi.introducirGrupo(grupo);
            }
        }
    }
    double Consultar_tiempo_prior1(){
        double sum = 0;
        Viaje via;
        for(int i = 0; i< viajes.size();++i){
            via = viajes.get(i);
            if(via.consultar_prio1()){
                sum += via.getsumpri1();
            }
        }
        return sum;    
    }
    
    public double getTiempoTotal() {
        int total =0;
        for(Viaje viaje:viajes) {
           total += viaje.tiempoTotal; 
        }
        return total;
    }
    
    public void borrarGrupo() {
        
    }
    
    public void cambiaOrdenViajes() {
        
    }
}
