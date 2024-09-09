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
    public void setComportamento(Comportamento estragiaDoContextoRobo) {
        this.estragiaDoContextoRobo = estragiaDoContextoRobo;
    }

    /*
     * delegando a capacidade do robo se mover, dependendo do seu comprotamento (estratária de negócio):
     */

    public void mover() {
        estragiaDoContextoRobo.mover();
    }
    

}
