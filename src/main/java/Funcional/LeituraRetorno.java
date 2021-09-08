package Funcional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetorno {
    protected static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected static DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static List<Boleto> lerBancoBrasil(String arquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(arquivo));
            String line = null;
            List<Boleto> boletos = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));

                boletos.add(boleto);
            }
            return boletos;
        } catch (IOException e) {
            //e.printStackTrace();
            throw new UncheckedIOException(e);
        }
    }

    public static List<Boleto> lerBancoBradesco(String arquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(arquivo));
            String line = null;
            List<Boleto> boletos = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(23, 59, 59));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));

                boletos.add(boleto);
            }
            return boletos;
        } catch (IOException e) {
            //e.printStackTrace();
            throw new UncheckedIOException(e);
        }
    }
}
