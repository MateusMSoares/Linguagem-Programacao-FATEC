import java.util.List;

public class Dicionario {
    private String termo;
    private String origemTermo;
    private String[] sinonimos;
    private List<Dicionario> dicionario;

    // Construtor de adicionar
    public Dicionario(String termo, String origemTermo, String[] sinonimos) {
        this.termo = termo;
        this.origemTermo = origemTermo;
        this.sinonimos = sinonimos;
    }

    // Metodo de buscar
    public Dicionario buscarInformacoesPorTermo(String termo){
        for (Dicionario dicionario : dicionario) {
            if (dicionario.termo.equals(termo)) {
                return dicionario;
            }
        }
        return null;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public String getOrigemTermo() {
        return origemTermo;
    }

    public void setOrigemTermo(String origemTermo) {
        this.origemTermo = origemTermo;
    }

    public String[] getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(String[] sinonimos) {
        this.sinonimos = sinonimos;
    }

    public List<Dicionario> getDicionario() {
        return dicionario;
    }

    public void setDicionario(List<Dicionario> dicionario) {
        this.dicionario = dicionario;
    }
}
