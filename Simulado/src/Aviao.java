public class Aviao {
    // Atributos
    private String modelo;
    private String companhia;
    private int capacidade;

    public Aviao(String modelo, String companhia, int capacidade) {
        this.modelo = modelo;
        this.companhia = companhia;
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void decolar() {
        System.out.println("O avião modelo " + modelo + " da companhia " + companhia + " está decolando.");
    }

    public void pousar() {
        System.out.println("O avião modelo " + modelo + " da companhia " + companhia + " está pousando.");
    }

    public void exibirInformacoes() {
        System.out.println("Modelo: " + modelo + ", Companhia: " + companhia + ", Capacidade: " + capacidade);
    }
}
