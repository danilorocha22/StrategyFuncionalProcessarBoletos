package Funcional;

import java.util.List;
import java.util.function.Function;

public class ProcessarBoleto {
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoleto(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String arquivo) {
        List<Boleto> boletos = leituraRetorno.apply(arquivo);
        boletos.stream().forEach(System.out::println);
        //boletos.stream().forEach(b -> System.out.println(b));
    }
}
