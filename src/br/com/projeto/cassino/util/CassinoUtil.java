package br.com.projeto.cassino.util;

public class CassinoUtil {

    public static boolean verificaEntradas(int quantidadeApostadores , int contagemHorario, int contagemAntihorario) throws RuntimeException {

        if(quantidadeApostadores == 0 && contagemHorario == 0 && contagemAntihorario  == 0) {
            return false;
        } else if (quantidadeApostadores <= 0 || contagemHorario <= 0 || contagemAntihorario  <= 0) {
            throw new RuntimeException("Uma das entradas não pode ser menor ou igual 0 quando outras não são.");
        } else if (quantidadeApostadores > 20) {
            throw new RuntimeException("A quantidade de apostadores não pode ser maior que 20.");
        }
        return true;

    }

}
