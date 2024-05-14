import java.util.Scanner;

public class DiaSemana {
    private final int DOMINGO = 1;
    private final int SEGUNDA = 2;
    private final int TERÇA = 3;
    private final int QUARTA = 4;
    private final int QUINTA = 5;
    private final int SEXTA = 6;
    private final int SABADO = 7;

    public DiaSemana() {
    }

    public void lerDia() {
        Scanner scanner = new Scanner(System.in);

        int diaEscolhido = scanner.nextInt();
        diaDaSemana(diaEscolhido);
        scanner.close();
    }

    public void diaDaSemana(int diaEscolhido) {
        switch (diaEscolhido) {
            case DOMINGO:
                System.out.println("Domingo");
                break;
            case SEGUNDA:
                System.out.println("Segunda");
                break;
            case TERÇA:
                System.out.println("Terça");
                break;
            case QUARTA:
                System.out.println("Quarta");
                break;
            case QUINTA:
                System.out.println("Quinta");
                break;
            case SEXTA:
                System.out.println("Sexta");
                break;
            case SABADO:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Dia inválido");
                break;
        }
    }

}