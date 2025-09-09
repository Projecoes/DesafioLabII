package Etapa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    private static final char PAREDE = 'X';
    private static final char CAMINHO_ABERTO = ' ';
    private static final char SAIDA = 'D';
    private static final char CAMINHO_SOLUCAO = '#';

    private static char[][] labirinto;


    /**
     * Lê o arquivo de texto contendo o labirinto.
     * Conta o número de linhas e determina o maior número de colunas,
     * para posicionar corretamente a matriz que representa o labirinto.
     *
     * @param fileName o nome do arquivo que contém o labirinto
     */
    public void criaLabirinto(String fileName) throws IllegalArgumentException {
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
            throw new IllegalArgumentException("meu deus");
        }
    }


    //começa o labirinto da primeira posição de X e Y
    public boolean percorreLabirinto() {
        return resolverLabirinto(0, 0);
    }


    //imprime o labirinto completo
    public void imprimeLabirinto() {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }



    /**
     * Metodo recursivo que tenta encontrar uma saída no labirinto a partir da posição (x, y).
     * Marca o caminho percorrido com o caractere CAMINHO_SOLUCAO ('#') e volta
     * se encontrar um beco.

     * @param x A coordenada da linha atual no labirinto.
     * @param y A coordenada da coluna atual no labirinto.
     * @return true se a saída do labirinto (SAIDA, 'D') for encontrada a partir desta posição,
     *         false caso contrário.

     * O algoritmo segue os seguintes passos:
     * 1. Verifica se a posição atual está dentro dos limites do labirinto.
     * 2. Verifica se a posição atual é a saída; se sim, retorna true.
     * 3. Verifica se a posição é um caminho aberto; se não, retorna false.
     * 4. Marca a posição atual como parte da solução com CAMINHO_SOLUCAO('#').
     * 5. Tenta percorrer recursivamente para cima, baixo, esquerda e direita.
     * 6. Se nenhum caminho leva à saída, desfaz a marcação e retorna false.
     */
    private boolean resolverLabirinto(int x, int y) {
        // verificando se o X e o Y estão dentro dos limites do labirinto
        if (x < 0 || x >= labirinto.length || y < 0 || y >= labirinto[0].length) {
            return false;
        }

        // se chegou na saida retorna true
        if (labirinto[x][y] == SAIDA) {
            return true;
        }

        // Se não é caminho aberto, não pode passar
        if (labirinto[x][y] != CAMINHO_ABERTO) {
            return false;
        }

        // Marca o caminho atual como parte da solução
        labirinto[x][y] = CAMINHO_SOLUCAO;

        // Anda nas quatro direções
        if (resolverLabirinto(x - 1, y) || // cima
                resolverLabirinto(x + 1, y) || // baixo
                resolverLabirinto(x, y - 1) || // esquerda
                resolverLabirinto(x, y + 1)) { // direita
            return true;
        }

        // Se não deu certo, volta
        labirinto[x][y] = CAMINHO_ABERTO;
        return false;
    }
}
