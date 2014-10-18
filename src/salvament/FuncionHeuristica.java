/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;

import java.util.List;

/**
 *
 * @author Samitier
 */
public class FuncionHeuristica implements aima.search.framework.HeuristicFunction{
    //Esta heurística solo valorará el tiempo en salvar a todos los grupos, no los grupos de prioridad 1
    @Override
    public double getHeuristicValue(Object o) {
        Solucion solucion = (Solucion) o;
        return solucion.getTiempoTotalSalvamento();
    }
}
