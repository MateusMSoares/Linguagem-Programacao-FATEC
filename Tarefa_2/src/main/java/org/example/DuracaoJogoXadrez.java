package org.example;

public class DuracaoJogoXadrez {
    // Ler a hora de início e a hora de fim de um jogo de Xadrez (considere apenas horas inteiras,
    // sem os minutos) e calcule a duração do jogo em horas, sabendo-se que o tempo máximo de duração
    // do jogo é de 24 horas e que o jogo pode iniciar em um dia e terminar no dia seguinte.
    private int horaInicio;
    private int horaFim;

    public DuracaoJogoXadrez(int horaInicio, int horaFim) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    void imprimeResultado(){
        int duracao;
        if (horaInicio < horaFim) {
            duracao = horaFim - horaInicio;
        } else {
            duracao = 24 - horaInicio + horaFim;
        }
        System.out.println("Duração do jogo em horas: " + duracao);
    }

    public double calculaDuracao(){
        int duracao;
        if (horaInicio < horaFim) {
            duracao = horaFim - horaInicio;
        } else {
            duracao = 24 - horaInicio + horaFim;
        }
        return duracao;
    }

}
