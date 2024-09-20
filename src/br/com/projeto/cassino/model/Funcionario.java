package br.com.projeto.cassino.model;

public class Funcionario {

    private int contagem;

    private int marcadorContagem;

    public Funcionario(int contagem, int marcadorContagem) {
        this.contagem = contagem;
        this.marcadorContagem = marcadorContagem;
    }

    public int getContagem() {
        return this.contagem;
    }

    public int getMarcadorContagem() {
        return this.marcadorContagem;
    }

    public void setMarcadorContagem(int marcadorContagem) {
        this.marcadorContagem = marcadorContagem;
    }
}
