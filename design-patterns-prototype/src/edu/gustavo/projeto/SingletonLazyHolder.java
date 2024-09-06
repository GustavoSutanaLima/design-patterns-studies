package edu.gustavo.projeto;

/**
 * Singleton "preguiçoso" com inner-class holder;
 * @author Gustavo
 */

public class SingletonLazyHolder {
    
    public static class LazyHolder {
        private static SingletonLazyHolder singletonEagerInstância = new SingletonLazyHolder();
    }
    

    private SingletonLazyHolder () {
        super();
    }

    public static SingletonLazyHolder getSingletonLazyHolder() {
        return LazyHolder.singletonEagerInstância;
    }

}
