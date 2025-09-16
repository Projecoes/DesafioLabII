package Etapa2;

public class Candidato {
    private String nome;
    private String partida;
    private int intencoesVotos;


    public Candidato() {
    }

    public Candidato(String nome, String partida, int intencoesVotos) {
        this.nome = nome;
        this.partida = partida;
        this.intencoesVotos = intencoesVotos;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public int getIntencoesVotos() {
        return intencoesVotos;
    }

    public void setIntencoesVotos(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome: " + nome + '\'' +
                ", partida: " + partida + '\'' +
                ", intencoesVotos: " + intencoesVotos +
                '}';
    }
}
