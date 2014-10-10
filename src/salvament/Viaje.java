/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import java.util.Stack;

/**
 *
 * @author Samitier
 */
public class Viaje {
    Stack<Grup> grups;
    int tempsTotal;
    int npersones;
    
    final int MAX_PERSONES_VIATGE = 15;
    final int MAX_GRUPS = 3;


    public Viaje() {
        grups = new Stack();
    }
    
    public void treureGrup() {
        Grup grup = grups.pop();
        npersones-= grup.npersones;
        tempsTotal = calcularTempsMinim();
    }
    
    public boolean afegirGrup(Grup grup) {
        if(grups.size()==MAX_GRUPS) return false;
        if ((npersones+grup.npersones)>MAX_PERSONES_VIATGE) return false;
        npersones += grup.npersones;
        grups.add(grup);
        tempsTotal = calcularTempsMinim();
        return true;
    }
    
    //funcio que calcula el temps minim que pot tardar l'helicopter en salvar tots els grups asignats
    private int calcularTempsMinim() {
        //TODO
        return 0;
    }
}
