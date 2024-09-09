package subsistema2.cep;

public class CepApi {
    
    //O singleton já é instanciado no momento de sua inicilização:
    private static CepApi cepApi = new CepApi();

    private CepApi () {
        super();
    }

    public static CepApi getCepApi() {
        return cepApi;
    }

    public String recuperarCidade(String cep) {
        return "Astolfo Dutra"; //Dado mockado;
    }

    public String recuperarEstado(String cep) {
        return "MG"; //Outro dado mockado;
    }

    /*
     * DADO MOCKADO em Java refere-se a objetos customizados que simulam dados vindos de uma API ou fonte externa. 
     * Esses objetos são criados com a intenção de simular dados reais e são frequentemente utilizados para testes 
     * automatizados ou para desenvolver interfaces enquanto aguardamos a disponibilidade dos dados reais.  
    */
}
