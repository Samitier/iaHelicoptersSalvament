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
public class FuncionSuccesora implements aima.search.framework.SuccessorFunction{

    public FuncionSuccesora() {
    }
    @Override
    public List getSuccessors(Object o) {
        Solucion solucion = (Solucion) o;
        return solucion.generarSuccesores();
    }
}
