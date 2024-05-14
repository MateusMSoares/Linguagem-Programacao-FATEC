public class Exercicio3 {
    private int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int posicao;
    private boolean encontrado;

    public Exercicio3() {
    }

    public String procurarItem(int item) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == item) {
                posicao = i;
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            return "posicao: " + posicao + " item: " + item ;
        } else {
            return "Não encontrado";
        }
    }
}
