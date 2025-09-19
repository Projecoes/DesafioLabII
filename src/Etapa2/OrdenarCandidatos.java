package Etapa2;

/**
 * Classe utilitária responsável por ordenar e pesquisar candidatos.
 *
 * <p>Esta classe implementa métodos de ordenação estáveis usando
 * o algoritmo de Insertion Sort, permitindo ordenar candidatos
 * por nome, número de votos ou partido.</p>
 *
 * <p>Também fornece um metodo de pesquisa binária para encontrar
 * um candidato pelo nome em um array previamente ordenado por nome.</p>
 */
public class OrdenarCandidatos {

    /**
     * Ordena o array de candidatos pelo nome em ordem alfabética (A-Z).
     * Utiliza o algoritmo Insertion Sort, que é estável.
     *
     * @param candidatos Array de candidatos a ser ordenado
     */
    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato candidato = candidatos[i]; // elemento atual a ser inserido
            int j = i - 1;
            // Move os elementos maiores que "candidato" uma posição à frente
            while (j >= 0 && candidatos[j].getNome().compareToIgnoreCase(candidato.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            // Insere o elemento na posição correta
            candidatos[j + 1] = candidato;
        }
    }

    /**
     * Ordena o array de candidatos pelo número de intenções de votos
     * em ordem decrescente (mais votado primeiro).
     * Utiliza o algoritmo Insertion Sort, que é estável.
     *
     * @param candidatos Array de candidatos a ser ordenado
     */
    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {

        for (int i = 1; i < candidatos.length; i++) {
            Candidato candidato = candidatos[i]; // elemento atual a ser inserido
            int j = i - 1;

            //candidatos com mais votos primeiro
            while (j >= 0 && candidatos[j].getIntencoesVotos() < candidato.getIntencoesVotos()) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            // Insere o elemento na posição correta
            candidatos[j + 1] = candidato;
        }
    }

    /**
     * Ordena o array de candidatos pelo partido em ordem alfabética (A-Z).
     * Utiliza o algoritmo Insertion Sort, que é estável.
     *
     * @param candidatos Array de candidatos a ser ordenado
     */
    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {

        for (int i = 1; i < candidatos.length; i++) {
            Candidato candidato = candidatos[i]; //elemento atual a ser inserido
            int j = i - 1;

            // Garante que o candidato fique na frente dos partidos que vêm depois no alfabeto
            while (j >= 0 && candidatos[j].getPartido().compareToIgnoreCase(candidato.getPartido()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            // Insere o elemento na posição correta
            candidatos[j + 1] = candidato;
        }
    }

    /**
     * Pesquisa binária para encontrar um candidato pelo nome.
     *
     * <p>IMPORTANTE: O array de candidatos deve estar ordenado previamente
     * pelo atributo "nome" em ordem alfabética.</p>
     *
     * @param candidatos Array de candidatos (ordenado por nome)
     * @param nome       Nome do candidato a ser buscado
     * @return Posição do candidato no array, ou -1 se não encontrado
     */
    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int inicio = 0;                     //indice inicial
        int fim = candidatos.length - 1;    //indice final
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;  //indice do meio
            int comparacao = nome.compareToIgnoreCase(candidatos[meio].getNome());

            if (comparacao == 0) {
                return meio;    // candidato encontrado
            } else if (comparacao < 0) {
                fim = meio - 1; // busca na metade esquerda
            } else {
                inicio = meio + 1;  // busca na metade direita
            }
        }
        return -1;  // candidato não encontrado
    }
}