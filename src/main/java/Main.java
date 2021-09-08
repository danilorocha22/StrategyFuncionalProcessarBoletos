import Funcional.LeituraRetorno;
import Funcional.ProcessarBoleto;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        /**
         * Processar boleto do Banco Brasil
         */
        ProcessarBoleto processarBancoBrasil = new ProcessarBoleto(LeituraRetorno::lerBancoBrasil);
        String boletoBrasil = Main.class.getResource("banco-brasil-1.csv").getPath();
        System.out.println("\nLendo arquivo: "+boletoBrasil);
        processarBancoBrasil.processar(boletoBrasil);

        /**
         * Processar boleto do Banco Bradesco
         */
        ProcessarBoleto processarBancoBradesco = new ProcessarBoleto(LeituraRetorno::lerBancoBradesco);
        String boletoBradesco = Main.class.getResource("bradesco-1.csv").getPath();
        System.out.println("\nLendo arquivo: "+boletoBradesco);
        processarBancoBradesco.processar(boletoBradesco);

    }
}
