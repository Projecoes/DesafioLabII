package Etapa2;

import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Array de tamanho aleatório entre 1 e 20
        int tamanho = random.nextInt(20) + 1;
        Candidato[] candidatos = new Candidato[tamanho];

        // Listas de nomes e partidos para gerar aleatoriamente
        String[] nomes = {"Mariana", "Paulo", "Rafael", "Alexandre", "Amanda", "Beatriz", "Eduardo", "Lucas", "Gabriela", "Jorge"};
        String[] partidos = {"PSB", "PL", "PMDB", "PT", "PSD"};

        // Preenchendo com dados aleatórios
        for (int i = 0; i < tamanho; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            String partido = partidos[random.nextInt(partidos.length)];
            int votos = random.nextInt(1000); // votos entre 0 e 999
            candidatos[i] = new Candidato(nome, partido, votos);
        }

        // Ordena por nome e exibe
        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        System.out.println("\n=== Candidatos Ordenados por Nome ===");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        //ordena por voto e exibe
        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        System.out.println("\n=== Candidatos Ordenados por Voto ===");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }


        //ordena por partido e exibe
        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        System.out.println("\n=== Candidatos Ordenados por Partido ===");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }


        // Pesquisa binária
        System.out.print("\nDigite o nome do candidato para buscar: ");
        String nomeBusca = sc.nextLine();

        int posicao = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomeBusca);
        System.out.println("\n=== Primeiro Candidato ===\n" + candidatos[0]);
        System.out.println("\n=== Ultimo Candidato ===\n" + candidatos[candidatos.length - 1]);
        if (posicao != -1) {
            System.out.println("\n=== Candidato Pesquisado ===\n" + candidatos[posicao]);

        } else {
            System.out.println("\nCandidato não encontrado.");
        }

        sc.close();

    }
}
