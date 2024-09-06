package edu.gustavo.projeto;

/**
 * Singleton "preguiçoso"
 * @author Gustavo
 */

public class SingletonLazy {
    
    //Um singleton cria uma instância dele mesmo (note que o atributo do singleton é da própria classe):
    private static SingletonLazy singletonLazyInstância;
    
    /*
     * Para garantir que ninguém de fora desta classe insntância um objeto singleton,
     * defini-se um construtor privato para esta classe 
     * (só será possível criar um new SingletonLazy() dentro do corpo do singleton):
     */

    private SingletonLazy () {
        super(); //super() chama o construtor da classe pai (neste caso, a classe Object).
        /*
         * Em Java, todas as classes personalizadas (ou seja, aquelas que você cria) herdam implicitamente da classe 
         * Object. A classe Object é a base de todas as outras classes e fornece alguns métodos fundamentais que 
         * estão disponíveis para todas as instâncias de objetos.
         */
    }

    //Mas como garantir que uma instância dessa classe seja diposinibiliza?

    //R: Através de um método público e estático que retorma o singleton:

    /*
     * O método abaixo retorna um objeto do tipo SingletonLazy (ou seja, o Singleton de estudo)
     * Se ele estiver vazio (ou melhor dizendo for nula - objeto não inicilizado), ele será instanciado:
     */
    public static SingletonLazy getSingletonLazy() {
        if (singletonLazyInstância == null) {
            singletonLazyInstância = new SingletonLazy();
        }
        return singletonLazyInstância;
    }


}
