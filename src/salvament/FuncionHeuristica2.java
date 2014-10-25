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
public class FuncionHeuristica2 implements aima.search.framework.HeuristicFunction{
    //Esta heurística solo valorará el tiempo en salvar a todos los grupos, no los grupos de prioridad 1
    @Override
    public double getHeuristicValue(Object o) {
        Solucion solucion = (Solucion) o;
        double tp1 = solucion.getTiempoSalvamentoP1();
        return solucion.getTiempoTotalSalvamento() + tp1*tp1;
    }
}
