package Etapa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    private final char PAREDE = 'X';
    private final char CAMINHO_ABERTO = ' ';
    private final char SAIDA = 'D';
    private final char CAMINHO_SOLUCAO = '#';

    private char[][] labirinto;



    /**
     * Lê um arquivo de texto contendo a representação de um labirinto.
     * Conta o número de linhas e determina o maior número de colunas,
     * para alocar corretamente a matriz que representará o labirinto.
     *
     * @param fileName o nome do arquivo que contém o labirinto
     */
    public void criaLabirinto(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            // LINHA NO SINGULAR é string
            String linha;
            //LINHAS no plural é int
            int linhas = 0;
            int colunas = 0;

            // Conta as linhas e colunas
            while ((linha = bufferedReader.readLine()) != null) {
                linhas++;
                // Atualiza o número de colunas com base na linha mais longa encontrada até agora
                colunas = Math.max(colunas, linha.length());
            }

            labirinto = new char[linhas][colunas];

            bufferedReader.close();

            // Abrindo um novo BufferedReader para ler o arquivo novamente
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName));
            int i = 0;

            // Lê cada linha do arquivo até o fim
            while ((linha = bufferedReader2.readLine()) != null) {
                // Para cada caractere da linha atual...
                for (int j = 0; j < linha.length(); j++) {
                    // Copia o caractere da string para a matriz labirinto na posição [i][j]
                    labirinto[i][j] = linha.charAt(j);
                }
                i++;
            }

            bufferedReader2.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }



    public boolean percorreLabirinto(){
        return resolverLabirinto(0,0);
    }




    public void imprimeLabirinto(){
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }

    //todo: implementar o método
    public boolean  resolverLabirinto(int i, int j) {
        return false;
    }
}
