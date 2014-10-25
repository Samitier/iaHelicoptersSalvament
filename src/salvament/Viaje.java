/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.*;
import java.util.*;



/**
 *
 * @author Samitier
 */
public class Viaje implements Cloneable{
    final int MAX_PERSONAS_VIAJE = 15;
    final int MAX_GRUPOS = 3;

    int posx, posy;
    ArrayList<Grupo> grupos;
    double tiempoTotal;
    int npersonas;
    

    public Viaje(int posx, int posy) {
        this.posx = posx; this.posy = posy;
        grupos = new ArrayList();
    }
    
    public Viaje(Viaje vi) {
        this.posx = vi.posx;
        this.tiempoTotal = vi.tiempoTotal;
        this.npersonas = vi.npersonas;
        grupos = new ArrayList();
        for(Grupo gr : vi.grupos){
            grupos.add(gr);
        }
    }
    
    public boolean quitarGrupo(int i) {
        Grupo grupo = grupos.get(i);
        if(grupos.size()==0) return true;
        npersonas-= grupo.getNPersonas();
        tiempoTotal = calcularTiempoMinimo();
        grupos.remove(i);
        return false;
    }
    
    public boolean introducirGrupo(Grupo grupo) {
        if(grupos.size()==MAX_GRUPOS) return false;
        if ((npersonas+grupo.getNPersonas())>MAX_PERSONAS_VIAJE) return false;
        npersonas += grupo.getNPersonas();
        grupos.add(grupo);
        tiempoTotal = calcularTiempoMinimo();
        return true;
    }
    

    
    //funcio que calcula el temps minim que pot tardar l'helicopter en salvar tots els grups asignats
    private double calcularTiempoMinimo() {
        //100/kmh
        //raiz((x2-x1)^2 + (y2-y1)^2)
        double xaux,yaux;
        Grupo gr;
        
        xaux= posx;
        yaux=posy;
        double taux = 0;
        double dist = 0;
        for(int i = 0; i<grupos.size();i++){
            gr = grupos.get(i);            
            dist += Math.sqrt(Math.pow((double)gr.getCoordX() - xaux ,2 ) + Math.pow((double)gr.getCoordY() - yaux ,2));
            if(gr.getPrioridad() == 1){
            taux += 2*gr.getNPersonas();
            }
            else{
                taux += gr.getNPersonas();
            }
            xaux = gr.getCoordX();
            yaux = gr.getCoordY();
        }
        dist += Math.sqrt(Math.pow( (double)posx - xaux ,2 ) + Math.pow((double)posy - yaux ,2));       
        //v=d/t -> t = d/v
        double t = (dist / 100)*60;
        t=t+taux+10;//10 min per descarregar
        //TODO
        return t;
    }

    boolean consultar_prio1() {
        Grupo gr;
        for (int i=0;i<grupos.size();++i){
            gr = grupos.get(i);
            if(gr.getPrioridad()==1)return true;
        }
        return false;       
    }
    double getsumpri1(){
        Grupo gr;
        double Sum = 0;
        int npers = 0;
        for (int i=0;i<grupos.size();++i){
            gr = grupos.get(i);
            if(gr.getPrioridad()==1){
                npers = gr.getNPersonas();
                Sum += npers * 2;
            }
        }
        return Sum;
        
    }

    boolean existe_grupo(Grupo gr) {
        for(int i=0;i<grupos.size();++i){
            if(gr == grupos.get(i))return true;
        }
        return false;
    }
}
