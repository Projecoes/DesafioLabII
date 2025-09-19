package Etapa2;

public class OrdenarCandidatos {

    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i-1;
            while (j >= 0 && candidatos[j].getNome().compareToIgnoreCase(chave.getNome())> 0) {
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

    public static void ordenaCandidatosPorPartido(Candidato[] candidato) {

    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidato, String arg) {
        int inf = 0;
        int sup = candidato.length - 1;
        return 0;
    }
}