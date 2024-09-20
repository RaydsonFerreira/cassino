package br.com.projeto.cassino.service;

import br.com.projeto.cassino.model.Apostador;
import br.com.projeto.cassino.model.Cassino;
import br.com.projeto.cassino.model.EntradaJogo;
import br.com.projeto.cassino.util.CassinoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoService {

    private List<EntradaJogo> entradasJogo;
    private List<String> resultados;

    public JogoService() {

        entradasJogo = new ArrayList<>();
        resultados = new ArrayList<>();

    }

    public void recolherEntradas() {

        Scanner scanner = new Scanner(System.in);

        EntradaJogo entradaJogo;

        try {

            int quantidadeApostadores = scanner.nextInt();
            int contagemHorario = scanner.nextInt();
            int contagemAntihorario = scanner.nextInt();

            while (CassinoUtil.verificaEntradas(quantidadeApostadores, contagemHorario, contagemAntihorario)) {

                entradaJogo = new EntradaJogo(quantidadeApostadores, contagemHorario, contagemAntihorario);

                entradasJogo.add(entradaJogo);

                quantidadeApostadores = scanner.nextInt();
                contagemHorario = scanner.nextInt();
                contagemAntihorario = scanner.nextInt();

            }

        } catch (Exception e) {

            String mensagem = e.getMessage() != null ? e.getMessage() : "Valores fora do padrão";
            System.out.println("ERRO NAS ENTRADAS: " +  mensagem);

        }

    }

    public void iniciarJogo() {

        Cassino cassino;
        Apostador apostadorRemovidoHorario;
        Apostador apostadorRemovidoAntihorario;

        for(EntradaJogo entradaJogo : entradasJogo) {

            cassino = new Cassino(entradaJogo.getQuantidadeApostadores(), entradaJogo.getContagemHorario(), entradaJogo.getContagemAntihorario());

            while(cassino.aindaTemapostadores()){

                apostadorRemovidoHorario = cassino.contarHorario();
                apostadorRemovidoAntihorario = cassino.contarAntihorario();

                if (apostadorRemovidoHorario.getIdentificacao() == apostadorRemovidoAntihorario.getIdentificacao()) {
                    resultados.add(String.valueOf(apostadorRemovidoHorario.getIdentificacao()));
                } else {
                    resultados.add(" " + apostadorRemovidoHorario.getIdentificacao() + "  " + apostadorRemovidoAntihorario.getIdentificacao());
                }

                cassino.removerApostadores();

            }

            System.out.println(String.join(", ", resultados));
            resultados.clear();

        }

    }

}
