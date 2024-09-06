package edu.gustavo.projeto.contexto;

import edu.gustavo.projeto.estrategia.Comportamento;

public class Robo {
    /*
     * A classe robo implementa Comportamento (estratégia de negócio):
     */
    private Comportamento estragiaDoContextoRobo;

    /*
     * eventualmente o robo poderá mudar seu comportamento (defininfo metodo set):
     */

    private void setComportamentoRobo(Comportamento comp){
        this.estragiaDoContextoRobo = comp;
    }

}
