package br.com.projeto.cassino.model;

public class EntradaJogo {

    private int quantidadeApostadores;
    private int contagemHorario;
    private int contagemAntihorario;

    public EntradaJogo(int quantidadeApostadores, int contagemHorario, int contagemAntihorario) {

        this.quantidadeApostadores = quantidadeApostadores;
        this.contagemHorario = contagemHorario;
        this.contagemAntihorario = contagemAntihorario;

    }

    public int getQuantidadeApostadores() {
        return quantidadeApostadores;
    }

    public int getContagemHorario() {
        return contagemHorario;
    }

    public int getContagemAntihorario() {
        return contagemAntihorario;
    }

}
