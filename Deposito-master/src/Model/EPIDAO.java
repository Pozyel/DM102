/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EPI;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author antun
 */
public class EPIDAO {

    Dao d = new Dao();

    public boolean inserirEPI(EPI novoEPI) {
        d.connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO EPI(idEPI,Nome) "
                + "values (?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, novoEPI.getIdEPI());
            d.pst.setString(2, novoEPI.getNome());
            d.pst.execute();
            d.sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            d.sucesso = false;
        } finally {
            try {   //Encerra a conexão
                d.con.close();
                d.pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return d.sucesso;
    }

    public boolean atualizarDadosEPI(int idEPI, String novoNome) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE EPI SET nome=? WHERE idEPI=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setString(1, novoNome);
            d.pst.setInt(2, idEPI);
            d.pst.execute();
            d.sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            d.sucesso = false;
        } finally {
            try {
                d.con.close();
                d.pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }

        }
        return d.sucesso;
    }

    public boolean deletarEPI(int idEPI) {
        d.connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM EPI WHERE idEPI=?";
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, idEPI);
            d.pst.execute();
            d.sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            d.sucesso = false;
        } finally {
            try {
                d.con.close();
                d.pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return d.sucesso;
    }

    public ArrayList<EPI> buscarEPISemFiltro() {
        ArrayList<EPI> listaDeEPI = new ArrayList<>();
        d.connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM EPI";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            d.st = d.con.createStatement();
            d.rs = d.st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de EPI: ");
            while (d.rs.next()) {
                //System.out.println(rs.getString("nome"));
                EPI EPITemp = new EPI(d.rs.getInt("idEPI"),
                        d.rs.getString("Nome"));
                listaDeEPI.add(EPITemp);
            }
            d.sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            d.sucesso = false;
        } finally {
            try {
                d.con.close();
                d.st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeEPI;
    }
    
    public boolean atualizarDataRetirada(int idEPI, Date Data_Retirado ) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE EPI SET Data_Retirado=? WHERE idEPI=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setDate(1, Data_Retirado);
            d.pst.setInt(2, idEPI);
            d.pst.execute();
            d.sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            d.sucesso = false;
        } finally {
            try {
                d.con.close();
                d.pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }

        }
        return d.sucesso;
    }
    
    public boolean atualizarDataDevolvido(int idEPI, Date Data_Devolvido ) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE EPI SET Data_Devolvido=? WHERE idEPI=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setDate(1, Data_Devolvido);
            d.pst.setInt(2, idEPI);
            d.pst.execute();
            d.sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            d.sucesso = false;
        } finally {
            try {
                d.con.close();
                d.pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }

        }
        return d.sucesso;
    }
}
