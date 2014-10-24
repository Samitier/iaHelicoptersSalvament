/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import IA.Desastres.Grupo;
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
public class FuncionSuccesora implements aima.search.framework.SuccessorFunction{

    public FuncionSuccesora() {
    }
    @Override
    public List getSuccessors(Object o) {
        Solucion solucion = (Solucion) o;
        ArrayList succesores = new ArrayList();
        
        for(int heli =0; heli<solucion.helicopteros.size(); ++heli) {
            for(int viajes=0; viajes<solucion.helicopteros.get(heli).viajes.size();++viajes) {
                for(int grupos=0; grupos<solucion.helicopteros.get(heli).viajes.get(viajes).grupos.size();++grupos){
                    for(int heli2 =0;  heli2<solucion.helicopteros.size(); ++heli2) {
                        for(int viajes2=0; viajes2<solucion.helicopteros.get(heli2).viajes.size();++viajes2) {
                                Solucion sol = new Solucion(solucion);
                                Grupo gr = sol.helicopteros.get(heli).borrarGrupo(viajes, grupos);
                                if(sol.helicopteros.get(heli2).introducirGrupo(gr, viajes2)){
                                    succesores.add(new Successor(" ", sol));
                                }
                                else {
                                    for(int grupos2 = 0; grupos2 < solucion.helicopteros.get(heli2).viajes.get(viajes2).grupos.size();++grupos2) {
                                        if(sol.intercambiarGrupos(heli, viajes, gr, heli2,viajes2,grupos2)){
                                            succesores.add(new Successor(" ", sol));
                                        }
                                    }
                                }
                        }
                        Solucion sol = new Solucion(solucion);
                        Grupo gr = sol.helicopteros.get(heli).borrarGrupo(viajes, grupos);
                        sol.helicopteros.get(heli2).introducirGrupoNuevo(gr);
                        succesores.add(new Successor(" ", sol));
                    }
                }
            }   
        }
        return succesores;
    }
}


    
    /*
     *        int randHeli = random.nextInt(solucion.helicopteros.size());
        int randViaje = random.nextInt(solucion.helicopteros.get(randHeli).viajes.size());
        int randGrupo = random.nextInt(solucion.helicopteros.get(randHeli).viajes.get(randViaje).grupos.size());
        
        Solucion sol = new Solucion();
        sol = (Solucion) solucion.clone();
        Grupo gr = sol.helicopteros.get(randHeli).borrarGrupo(randViaje, randGrupo);
        for(int heli =0;  heli<solucion.helicopteros.size(); ++heli) {
            for(int viajes=0; viajes<solucion.helicopteros.get(heli).viajes.size();++viajes) {
                Solucion sol2 = new Solucion();
                sol2 = (Solucion) sol.clone();
                if(sol2.helicopteros.get(heli).introducirGrupo(gr, viajes)){
                    succesores.add(new Successor(" ", sol2));
                    System.out.println(sol2.getTiempoTotalSalvamento());
                }
            }
            Solucion sol2 = new Solucion();
            sol2 = (Solucion) sol.clone();
            sol2.helicopteros.get(heli).introducirGrupoNuevo(gr);
            succesores.add(new Successor(" ", sol2));
                                System.out.println(sol2.getTiempoTotalSalvamento());

        }
    return succesores;
    }
     */