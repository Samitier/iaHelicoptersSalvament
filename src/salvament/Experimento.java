/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;


/**
 *
 * @author Samitier
 */
public class Experimento {
    
    static boolean isHillClimbing = false;
    
    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        Estado estado = new Estado();
        estado.generarProblema();
        estado.generarSolucion();
        Solucion sol = estado.solucion;
        Problem problem;
        Search search;
        SearchAgent agent;
        if(isHillClimbing==true) {
            problem = new Problem(sol,new FuncionSuccesora(), new TestSolucionFinal(), new FuncionHeuristica2());
            search = new HillClimbingSearch();
            agent = new SearchAgent(problem,search);
        }
        else {
           problem  = new Problem(sol,new FuncionSuccesoraSA(), new TestSolucionFinal(), new FuncionHeuristica());
           search = new SimulatedAnnealingSearch(2000,100,5,0.001);
           agent = new SearchAgent(problem, search);
        }
        Solucion soluFinal = (Solucion) search.getGoalState();
        System.out.println(soluFinal.getTiempoTotalSalvamento());
        System.out.println("Execution time: " + (System.currentTimeMillis()-time) + " miliseconds");    
    }
}

