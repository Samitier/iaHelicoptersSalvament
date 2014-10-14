/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.Grupo;
import java.util.Stack;

/**
 *
 * @author Samitier
 */
public class Viaje {
    final int MAX_PERSONAS_VIAJE = 15;
    final int MAX_GRUPOS = 3;

    int posx, posy;
    Stack<Grupo> grupos;
    int tiempoTotal;
    int npersonas;
    

    public Viaje(int posx, int posy) {
        this.posx = posx; this.posy = posy;
        grupos = new Stack();
    }
    
    public void quitarGrupo() {
        Grupo grupo = grupos.pop();
        npersonas-= grupo.getNPersonas();
        tiempoTotal = calcularTiempoMinimo();
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
    private int calcularTiempoMinimo() {
        //TODO
        return 0;
    }
}
