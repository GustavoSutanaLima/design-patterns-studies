package edu.gustavo.teste;

import edu.gustavo.projeto.estrategia.ComportamentoDefensivo;
import edu.gustavo.projeto.estrategia.ComportamentoOfensivo;
import edu.gustavo.projeto.contexto.Robo;
import edu.gustavo.projeto.estrategia.Comportamento;
import edu.gustavo.projeto.estrategia.ComportamentoNormal;

public class RoboTeste {
    public static void main(String[] args) {
        Robo robo = new Robo();

        Comportamento compNormal = new ComportamentoNormal();

        Comportamento compDefensivo = new ComportamentoDefensivo();

        Comportamento compOfensivo = new ComportamentoOfensivo();   

        robo.setComportamento(compNormal);

        robo.mover();
    }
}
