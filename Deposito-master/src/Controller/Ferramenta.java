package Controller;

public class Ferramenta {
    private int Numero_Serie;
    private String Nome;
    private int Quantidade;

    public Ferramenta(int Numero_Serie, String Nome, int Quantidade) {
        this.Nome = Nome;
        this.Numero_Serie = Numero_Serie;
        this.Quantidade = Quantidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getNumero_Serie() {
        return Numero_Serie;
    }

    public void setNumero_Serie(int Numero_Serie) {
        this.Numero_Serie = Numero_Serie;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
    
}
