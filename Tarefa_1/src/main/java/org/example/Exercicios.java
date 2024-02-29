package org.example;

public class Exercicios {

    // Calcular gasto total do trimestre e a media de gasto
    // Janeiro = 15k
    // Fevereiro = 23k
    // Março = 17k
    int gastoTotal(int janeiro, int fevereiro, int marco){

        int total = janeiro + fevereiro + marco;
        return total;
    }

    double gastoMedio(int janeiro, int fevereiro, int marco){
        double media = (janeiro + fevereiro + marco) / 3;
        return media;
    }

    //2. Programa que leia as notas e calcule a média de LP1 deste
    //semestre, referente a um determinado aluno.
    //(P1*0.6+((E1+E2)/2)*0.4)*0.5+(max(((P1*0.6+((E1+E2)/2)*0.4)-5.9),0)/((P1*0.6+((E1+E2)/2)*0.4)-5.9))*(API*0.5)+X+(SUB*0.2)

    //SUB	Prova substitutiva

    //X	Atividades extras

    //API	Aprendizagem por Projeto Integrado (API) ou prova2

    //P1	Prova1

    //E1	Exercícios

    //E2	Exercícios

    // a sub nao deve aumentar a nota caso a media >=6
    // x sao pontos extras no maximo até 2 pontos
    void calculaMedia(double sub, double x, double api, double p1, double e1, double e2, String nome){

        double media = (p1*0.6 + ((e1+e2)/2)*0.4)*0.5 + (Math.max(((p1*0.6 + ((e1+e2)/2)*0.4) - 5.9), 0) / ((p1*0.6 + ((e1+e2)/2)*0.4) - 5.9)) * (api*0.5) + x;
        double mediaFinal = 0;

        if (media < 6 ){
            // Aluno com nota inferior a media é adicionado a nota da substitutiva
            System.out.println("aluno "+ nome + " com media: "+ media);
            mediaFinal = media + (sub*0.2);
        }else{
           mediaFinal = media;

        }
        System.out.println("Média semestral do aluno " + nome + " em LP1: "+ mediaFinal);
    }

}
