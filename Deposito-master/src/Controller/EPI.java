package Controller;

import java.util.Date;

public class EPI {
    private int idEPI;
    private String Nome;
    private Date Data_Retirado = null;
    private Date Data_Devolvido = null;

    public EPI(int idEPI, String Nome) {
        this.Nome = Nome;
        this.idEPI = idEPI;
    }

    public int getIdEPI() {
        return idEPI;
    }

    public void setIdEPI(int idEPI) {
        this.idEPI = idEPI;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Date getData_Retirado() {
        return Data_Retirado;
    }

    public void setData_Retirado(Date Data_Retirado) {
        this.Data_Retirado = Data_Retirado;
    }

    public Date getData_Devolvido() {
        return Data_Devolvido;
    }

    public void setData_Devolvido(Date Data_Devolvido) {
        this.Data_Devolvido = Data_Devolvido;
    }
}
