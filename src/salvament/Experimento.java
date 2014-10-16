/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package salvament;
import IA.Desastres.Centro;
import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.TreeSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.uninformed.BreadthFirstSearch;


/**
 *
 * @author Samitier
 */
public class Experimento {
    public static void main(String[] args) throws Exception {
        Estado estado = new Estado();
        estado.generarProblema();
        estado.generarSolucion();
        Problem problem = new Problem(estado,new FuncionSuccesora(), new TestSolucionFinal(), new FuncionHeuristica());
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent(problem,search);
    }
}

