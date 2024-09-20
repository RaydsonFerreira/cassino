package br.com.projeto.cassino.main;

import br.com.projeto.cassino.service.JogoService;

public class Main {
    public static void main(String[] args) {

        JogoService jogoService = new JogoService();

        jogoService.recolherEntradas();

        jogoService.iniciarJogo();

    }
}