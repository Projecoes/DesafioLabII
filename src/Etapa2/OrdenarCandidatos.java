package Etapa2;

public class OrdenarCandidatos {

    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;
            while (j >= 0 && candidatos[j].getNome().compareToIgnoreCase(chave.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {

        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;

            //candidatos com mais votos primeiro
            while (j >= 0 && candidatos[j].getIntencoesVotos() < chave.getIntencoesVotos()) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {

        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;

            while (j >= 0 && candidatos[j].getPartido().compareToIgnoreCase(chave.getPartido()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int inicio = 0;
        int fim = candidatos.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = nome.compareToIgnoreCase(candidatos[meio].getNome());

            if (comparacao == 0) {
                return  meio;
            } else if (comparacao < 0) {
                fim = meio -1;
            }else{
                inicio = meio + 1;
            }
        }
        return 1;
    }
}