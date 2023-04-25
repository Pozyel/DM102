package Controller;

public class Funcionario {

    private int Registro;
    private String Nome;
    private String CPF;

    public Funcionario(int Registro, String Nome, String CPF) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Registro = Registro;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getRegistro() {
        return Registro;
    }

    public void setRegistro(int Registro) {
        this.Registro = Registro;
    }

}
