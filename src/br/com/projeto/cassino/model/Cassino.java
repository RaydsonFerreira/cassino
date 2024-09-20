package br.com.projeto.cassino.model;

import java.util.ArrayList;
import java.util.List;

public class Cassino {

    private List<Apostador> apostadores;
    private Funcionario funcionarioHorario;
    private Funcionario funcionarioAntihorario;

    public Cassino(int quantidadeApostadores , int contagemHorario, int contagemAntihorario) {

        this.apostadores = new ArrayList<>();
        for (int i = 1; i <= quantidadeApostadores; i++) {
            this.apostadores.add(new Apostador(i));
        }
        this.funcionarioHorario = new Funcionario(contagemHorario, 0);
        this.funcionarioAntihorario = new Funcionario(contagemAntihorario, quantidadeApostadores);

    }

    public boolean aindaTemapostadores() {
        return !apostadores.isEmpty();
    }

    public Apostador contarHorario() {
        
        int marcadorHorario = (funcionarioHorario.getMarcadorContagem() + funcionarioHorario.getContagem() -1) % apostadores.size();
        funcionarioHorario.setMarcadorContagem(marcadorHorario);
        return apostadores.get(marcadorHorario);

    }

    public Apostador contarAntihorario() {

        int marcadorAntihorario = (funcionarioAntihorario.getMarcadorContagem() - (funcionarioAntihorario.getContagem() % apostadores.size()) + apostadores.size()) % apostadores.size();
        funcionarioAntihorario.setMarcadorContagem(marcadorAntihorario);
        return apostadores.get(marcadorAntihorario);

    }

    public void removerApostadores() {

        if (funcionarioHorario.getMarcadorContagem() < funcionarioAntihorario.getMarcadorContagem()) {

            apostadores.remove(funcionarioAntihorario.getMarcadorContagem());
            apostadores.remove(funcionarioHorario.getMarcadorContagem());
            funcionarioAntihorario.setMarcadorContagem(funcionarioAntihorario.getMarcadorContagem() - 1);

        } else if (funcionarioHorario.getMarcadorContagem() > funcionarioAntihorario.getMarcadorContagem()) {

            apostadores.remove(funcionarioHorario.getMarcadorContagem());
            apostadores.remove(funcionarioAntihorario.getMarcadorContagem());
            funcionarioHorario.setMarcadorContagem(funcionarioHorario.getMarcadorContagem() - 1);

        } else {

            apostadores.remove(funcionarioHorario.getMarcadorContagem());

            // Ajusta os marcadores para a próxima contagem
            if (funcionarioHorario.getMarcadorContagem() >= apostadores.size()) {
                funcionarioHorario.setMarcadorContagem(0);
            }
            if (funcionarioAntihorario.getMarcadorContagem() >= apostadores.size()) {
                funcionarioAntihorario.setMarcadorContagem(apostadores.size());
            }

        }

    }

}
