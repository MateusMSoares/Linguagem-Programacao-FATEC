package com.example.dadosmeteorologicos.Services;

import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVService {
    private String arquivoEmKelvin = "src/main/resources/com/example/dadosmeteorologicos/A728_TBT.csv";

    private boolean automatico = true;
    private boolean cabecalhosValidos = false;
    private boolean nomeValido = false;
    private boolean isCSVFile = false;
    String codigoEstacao = "";
    String codigoCidade = "";
    private Map<String, Integer> camposAutomatico = new HashMap<>();
    private Map<String, Integer> camposManual = new HashMap<>();
    private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HHmm");
    private Map<String, String> caracteresEspeciais = new HashMap<>();

    private  Map<String, Integer> definirCamposEsperados(){
        return automatico ? camposAutomatico : camposManual;
    }
    private void inicializarHashMap(){
        camposAutomatico.put("Data", 0);
        camposAutomatico.put("Hora (UTC)", 1);
        camposAutomatico.put("Temp. Max. (C)", 3);
        camposAutomatico.put("Temp. Min. (C)",4);
        camposAutomatico.put("Umi. Max. (%)", 6);
        camposAutomatico.put("Umi. Min. (%)", 7);
        camposAutomatico.put("Vel. Vento (m/s)", 14);
        camposAutomatico.put("Dir. Vento (m/s)", 15);
        camposAutomatico.put("Chuva (mm)", 18);
        camposManual.put("Data", 0);
        camposManual.put("Hora (UTC)", 1);
        camposManual.put("Temp. [Hora] (K)", 2);
        camposManual.put("Umi. (%)", 3);
        camposManual.put("Vel. Vento (m/s)", 5);
        camposManual.put("Dir. Vento (m/s)", 6);
        camposManual.put("Chuva [Diaria] (mm)", 11);
        caracteresEspeciais.put("ï»¿", "");
        caracteresEspeciais.put("á", "a");
        caracteresEspeciais.put("é", "e");
        caracteresEspeciais.put("í", "i");
        caracteresEspeciais.put("ó", "o");
        caracteresEspeciais.put("ú", "u");
        caracteresEspeciais.put("ç", "c");
        caracteresEspeciais.put(",", ".");
    }

    private boolean isCSVFile(){
        String extensao = arquivoEmKelvin.substring(arquivoEmKelvin.lastIndexOf('.') + 1);
        return isCSVFile = extensao.equalsIgnoreCase("csv");

    }

    private String obterNomeArquivo() {
        String nomeArquivo = arquivoEmKelvin.substring(arquivoEmKelvin.lastIndexOf('\\') + 1);
        return nomeArquivo;
    }

    private boolean lerNomeCSV(){
        String nomeArquivo = obterNomeArquivo();
        String nomeSemExtensao = nomeArquivo.substring(0, nomeArquivo.lastIndexOf('.'));
        System.out.println(nomeSemExtensao);

        // Definir padrão para extrair informações do nome do arquivo
        Pattern pattern = Pattern.compile("^(A|)(\\d+)_([A-Z]{2,})$");

        // Extrair informações do primeiro nome de arquivo
        Matcher matcher = pattern.matcher(nomeSemExtensao);
        if (matcher.matches()) {
            nomeValido = true;
            String modoColeta = matcher.group(1); // Modo de coleta (A ou vazio)
            codigoEstacao = matcher.group(2); // Código da estação
            codigoCidade = matcher.group(3); // Código da cidade

            if ("A".equals(modoColeta)) {
                modoColeta = "Automatico";
            }else{
                modoColeta = "Manual";
                automatico = false;
            }

            System.out.println("Modo de Coleta: " + modoColeta);
            System.out.println("Código da Estação: " + codigoEstacao);
            System.out.println("Código da Cidade: " + codigoCidade);
            return true;
        } else{
            return false;
        }
    }


    public boolean validarCSV(){
        inicializarHashMap();
        isCSVFile();
        lerNomeCSV();
        List<String[]> arquivoPadronizado = lerCSV();

        return true;

    }

    public List<String[]> lerCSV() {
        List<String[]> arquivoPadronizado = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(arquivoEmKelvin))) {
            List<String[]> linhas = reader.readAll();

            for (String[] linha : linhas) {
                for (String celula : linha) {
                    System.out.print(celula + ", ");
                }
                System.out.println();
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
