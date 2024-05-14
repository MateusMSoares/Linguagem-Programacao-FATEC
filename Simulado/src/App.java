public class App {
    public static void main(String[] args) throws Exception {
        DiaSemana diaSemana = new DiaSemana();
        System.out.println("Digita o dia da semana de 1 a 7");
        diaSemana.lerDia();

        System.out.println("--------------");
        System.out.println("Exercicio 3:");
        Exercicio3 exercicio3 = new Exercicio3();
        System.out.println(exercicio3.procurarItem(10));
        
        System.out.println("--------------");
        System.out.println("Exercicio 4:");
        Aviao aviao1 = new Aviao("Boeing 737", "Gol", 180);
        Aviao aviao2 = new Aviao("Airbus A320", "Latam", 200);
        Aviao aviao3 = new Aviao("Embraer 190", "Azul", 100);
        System.out.println("Avião 1");
        aviao1.decolar();
        aviao1.exibirInformacoes();
        aviao1.pousar();
        System.out.println("Avião 2");
        aviao2.decolar();
        aviao2.exibirInformacoes();
        aviao2.pousar();
        System.out.println("Avião 3");
        aviao3.decolar();
        aviao3.exibirInformacoes();
        aviao3.pousar();

    }
}
