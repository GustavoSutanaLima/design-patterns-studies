package edu.gustavo.projeto;

/**
 * Singleton "apressado"
 * @author Gustavo
 */

public class SingletonEager {
    
    //O singleton já é instanciado no momento de sua inicilização:
    private static SingletonEager singletonEagerInstância = new SingletonEager();

    private SingletonEager () {
        super();
    }

    public static SingletonEager getSingletonEager() {
        return singletonEagerInstância;
    }

}
