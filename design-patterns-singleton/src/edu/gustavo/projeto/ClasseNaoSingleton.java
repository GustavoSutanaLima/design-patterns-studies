package edu.gustavo.projeto;

public class ClasseNaoSingleton {

    public ClasseNaoSingleton() {
        super();
    }

    public static ClasseNaoSingleton criarObjeto() {
        return new ClasseNaoSingleton();
    }

}
