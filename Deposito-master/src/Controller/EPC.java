package Controller;

import java.util.Date;

public class EPC {
    private int idEPC;
    private String Nome;    
    private Date Data_retirado;
    private Date Data_devolvido;

    public EPC(int idEPC, String Nome) {
        this.Nome = Nome;
        this.idEPC = idEPC;
    }

    public Date getData_retirado() {
        return Data_retirado;
    }

    public void setData_retirado(Date Data_retirado) {
        this.Data_retirado = Data_retirado;
    }

    public Date getData_devolvido() {
        return Data_devolvido;
    }

    public void setData_devolvido(Date Data_devolvido) {
        this.Data_devolvido = Data_devolvido;
    }

    public int getIdEPC() {
        return idEPC;
    }

    public void setIdEPC(int idEPC) {
        this.idEPC = idEPC;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}
