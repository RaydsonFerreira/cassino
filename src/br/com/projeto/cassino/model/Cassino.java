package br.com.projeto.cassino.model;

import java.util.ArrayList;
import java.util.List;

public class Cassino {

    private List<Apostador> apostadores;
    private Funcionario funcionarioHorario;
    private Funcionario funcionarioAntihorario;

    private int marcadorContagemHorario;
    private int marcadorContagemAntihorario;

    public Cassino(int quantidadeApostadores , int contagemHorario, int contagemAntihorario) {

        this.apostadores = new ArrayList<>();
        for (int i = 1; i <= quantidadeApostadores; i++) {
            this.apostadores.add(new Apostador(i));
        }
        this.funcionarioHorario = new Funcionario(contagemHorario);
        this.funcionarioAntihorario = new Funcionario(contagemAntihorario);
        this.marcadorContagemHorario = 0;
        this.marcadorContagemAntihorario = quantidadeApostadores;

    }

    public boolean aindaTemapostadores() {
        return !apostadores.isEmpty();
    }

    public Apostador contarHorario() {

        marcadorContagemHorario = (marcadorContagemHorario + funcionarioHorario.getContagem() -1) % apostadores.size();
        return apostadores.get(marcadorContagemHorario);

    }

    public Apostador contarAntihorario() {

        marcadorContagemAntihorario = (marcadorContagemAntihorario - (funcionarioAntihorario.getContagem() % apostadores.size()) + apostadores.size()) % apostadores.size();
        return apostadores.get(marcadorContagemAntihorario);

    }

    public void removerApostadores() {

        if (marcadorContagemHorario < marcadorContagemAntihorario) {

            apostadores.remove(marcadorContagemAntihorario);
            apostadores.remove(marcadorContagemHorario);
            marcadorContagemAntihorario = marcadorContagemAntihorario - 1;

        } else if (marcadorContagemHorario > marcadorContagemAntihorario) {

            apostadores.remove(marcadorContagemHorario);
            apostadores.remove(marcadorContagemAntihorario);
            marcadorContagemHorario = marcadorContagemHorario - 1;

        } else {

            apostadores.remove(marcadorContagemHorario);

            // Ajusta os marcadores para a próxima contagem
            if (marcadorContagemHorario >= apostadores.size()) {
                marcadorContagemHorario = 0;
            }
            if (marcadorContagemAntihorario >= apostadores.size()) {
                marcadorContagemAntihorario = apostadores.size();
            }

        }

    }

}
