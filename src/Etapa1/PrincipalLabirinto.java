package Etapa1;

public class PrincipalLabirinto {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();

        labirinto.criaLabirinto("C:\\Users\\andre\\IdeaProjects\\DesafioLabII\\src\\Etapa1\\labirinto.txt");
        boolean encontrou = labirinto.percorreLabirinto();

        if (encontrou) {
            System.out.println("Solução encontrada");
        } else {
            System.out.println("Não existe saída");
        }

        labirinto.imprimeLabirinto();
    }
}
