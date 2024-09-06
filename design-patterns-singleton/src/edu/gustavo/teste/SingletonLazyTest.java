package edu.gustavo.teste;

import edu.gustavo.projeto.*;

public class SingletonLazyTest {
    public static void main(String[] args) {
        
        SingletonLazy stl;
        /*
         * Através do método estático getSingletonLazy é possível iniciar uma instância do 
         */

        stl = SingletonLazy.getSingletonLazy();

        System.out.println(stl);

        stl = SingletonLazy.getSingletonLazy();
        /*
         * Ao definir uma nova instância desse objeto, passá-la para minha variável "stl" e printar
         * o endereço de memória do objeto deve ser o mesmo;
         */

        System.out.println(stl);

        System.out.println("******************************************");

        //Instância dois objetos não singleton para mostrar a diferença no endeço de memória:

        ClasseNaoSingleton novaClasseNaoSingleton;

        novaClasseNaoSingleton = ClasseNaoSingleton.criarObjeto();

        System.out.println(novaClasseNaoSingleton);

        novaClasseNaoSingleton = ClasseNaoSingleton.criarObjeto();

        System.out.println(novaClasseNaoSingleton);


    

      
    }
}   
