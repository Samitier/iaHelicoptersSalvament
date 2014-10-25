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
    void generarSolucion1(Grupos grupos, Centros cs) {
        ArrayList listaux = new ArrayList();        
        Centro ct;
        Random rand = new Random();
        int nviaj = 0;
        int heli = helicopteros.size();
        boolean usado = false;
        int helimin =0;
        for(int i=0; i<grupos.size();++i) { 
           
            Grupo gr = grupos.get(i);
            if(!esta_assign(gr,helicopteros)){                
            listaux = Buscar_grupos_cerc(grupos, gr);
            ct = buscar_ctr_cerc(gr,cs);            
            for(int j = 0; j < heli;++j){
                 System.out.print(i);
                    System.out.print(" entra \n");
                nviaj = helicopteros.get(j).getNviajes();
                if(nviaj == 0){
                    for(int k = 0;k<listaux.size();++k){
                    helicopteros.get(j).introducirGrupo((Grupo) listaux.get(k));
                    }
                    usado = true;
                    //System.out.print(i);
                    //System.out.print(" entra \n");
                }   
                else {                    
                    heli = rand.nextInt(helicopteros.size());
                    for(int k = 0;k<listaux.size();++k){
                        helicopteros.get(j).introducirGrupo((Grupo) listaux.get(k));
                       }         
                     //System.out.print(i);
                    //System.out.print(" entra \n");
                    usado = true;                   
                }
            }
            usado = false;
            }
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

    private ArrayList Buscar_grupos_cerc(Grupos grupos, Grupo gr) {
        ArrayList<Grupo> listaux = new ArrayList();
        int n = 0;
        Grupo gr2;
        boolean full = false;
        for(int i =0; i< grupos.size() && n<= 15 && listaux.size()<3 && !full;++i){
            gr2 = grupos.get(i);            
                if(gr != gr2){
                    if(n + gr2.getNPersonas() <= 15){
                        listaux.add(gr2);
                        n += gr2.getNPersonas();
                    }
                }
            }
        Grupo gr3 = null;
        for(int i =0; i< grupos.size();++i){
            gr2 = grupos.get(i);
            if(gr != gr2){
                for(int j = 0;j < listaux.size();++j ){
                    if (dist(gr,gr2) < dist(gr, listaux.get(j))){
                            if(n - listaux.get(j).getNPersonas()+ gr2.getNPersonas() <= 15 && listaux.size()<3){
                            gr3 = listaux.get(j);
                            n = gr3.getNPersonas() - n;
                            n += gr2.getNPersonas();
                            listaux.set(j, gr2);      
                        }
                    }
                }
            }        
        }
        return listaux;        
    }
    
   
 
    private int dist(Grupo gr, Grupo gr2) {
        int sum = 0;
        int posx = gr.getCoordX();
        int posy = gr.getCoordY();
        int xaux = gr2.getCoordX();
        int yaux = gr2.getCoordX();
        sum = (int)Math.sqrt(Math.pow( (double)posx - xaux ,2 ) + Math.pow((double)posy - yaux ,2));
        return sum;
        
    }

    private Centro buscar_ctr_cerc(Grupo gr, Centros cs) {
       Centro ct = null;
       int distaux = 50;
       int dstr =0;
       Centro aux;
       for(int i = 0;i < cs.size(); ++i){
           aux = cs.get(i);
           dstr = dist(gr,aux);
            if(dstr < distaux){
                distaux = dstr;
                ct = aux;
            }
       }
       return ct;
        
    }

    private int dist(Grupo gr, Centro aux) {
         int sum = 0;
        int posx = gr.getCoordX();
        int posy = gr.getCoordY();
        int xaux = aux.getCoordX();
        int yaux = aux.getCoordX();
        sum = (int) Math.sqrt(Math.pow( (double)posx - xaux ,2 ) + Math.pow((double)posy - yaux ,2));
        return sum;
    }

    private boolean esta_assign(Grupo gr, ArrayList<Helicoptero> helicopteros) {
        boolean trobat = false;
        for(int i=0;i<helicopteros.size();++i){
            for(int j =0; j<helicopteros.get(i).getNviajes();++j){
                if(helicopteros.get(i).estagrupo(gr)) return true;
            }
        }
        return false;
    }

   

    
    
}
