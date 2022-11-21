package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//java.io é para manipular dados no java

public class Arquivo {
    //throws IOException é como faz tratamento de excessões
    //excessões funcionam em formato de cascata
    //se o arquivo tem algum método que pode causar uma excessão, se usa isso pra jogar a excessão pra próxima classe tratar
    //como não vai ser tratada aqui, vai se jogando a excessão pra classe acima até ser tratada
    //receita de bolo abaixo
    //IOException, erro que pode ocorrer nos métodos de escrever, excessão genérica de entrada e saída de dados
    public static List<String> ler(String caminho) throws IOException {
        File arquivo = new File(caminho); //instanciando novo arquivo
        BufferedReader buffRead;
        List<String> linhas = new ArrayList<>();
        String linha = "";

        // Verifica se o arquivo em caminho existe
        // Retorna o ArrayList vazio caso não exista
        if (!arquivo.exists() || arquivo.isDirectory()) {
            return linhas;
        }

        buffRead = new BufferedReader(new FileReader(caminho));
        while (true) {
            if (linha != null) {
                if (!linha.equals("")) {
                    linhas.add(linha);
                }
            } else {
                break;
            }

            linha = buffRead.readLine();
        }

        buffRead.close();
        return linhas;
    }

    public static void escrever(String caminho, List<String> linhas) throws IOException {
        //vai apagar o arquivo que já estiver lá
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));

        for (String linha : linhas) {
            buffWrite.append(linha + "\n");
        }

        buffWrite.close();
    }
}