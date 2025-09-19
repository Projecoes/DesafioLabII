package Etapa2;

public class Candidato {

    //atributos
    private String nome;
    private String partido;
    private int intencoesVotos;


    //construtor vazio
    public Candidato() {
    }

    //contrutor com todos os argumentos
    public Candidato(String nome, String partido, int intencoesVotos) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }


    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getIntencoesVotos() {
        return intencoesVotos;
    }

    public void setIntencoesVotos(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Partido: " + partido +
                " | Intenções de Votos: " + intencoesVotos;
    }
}
