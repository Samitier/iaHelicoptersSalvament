/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;


/**
 *
 * @author Samitier
 */
public class Experimento {
    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        Estado estado = new Estado();
        estado.generarProblema();
        estado.generarSolucion();
        Solucion sol = estado.solucion;
        Problem problem = new Problem(sol,new FuncionSuccesora(), new TestSolucionFinal(), new FuncionHeuristica());
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent(problem,search);
        Solucion soluFinal = (Solucion) search.getGoalState();
        System.out.println(soluFinal.getTiempoTotalSalvamento());
        System.out.println(System.currentTimeMillis()-time);
    
    }
}

