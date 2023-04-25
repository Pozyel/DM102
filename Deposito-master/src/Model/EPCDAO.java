/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EPC;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author antun
 */
public class EPCDAO {

    Dao d = new Dao();

    public boolean inserirEPC(EPC novoEPC) {
        d.connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO EPC(idEPC,Nome) "
                + "values (?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, novoEPC.getIdEPC());
            d.pst.setString(2, novoEPC.getNome());
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

    public boolean atualizarDadosEPC(int idEPC, String novoNome) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE EPC SET nome=? WHERE idEPC=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setString(1, novoNome);
            d.pst.setInt(2, idEPC);
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

    public boolean deletarEPC(int idEPC) {
        d.connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM EPC WHERE idEPC=?";
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, idEPC);
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

    public ArrayList<EPC> buscarEPCSemFiltro() {
        ArrayList<EPC> listaDeEPC = new ArrayList<>();
        d.connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM EPC";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            d.st = d.con.createStatement();
            d.rs = d.st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de EPC: ");
            while (d.rs.next()) {
                //System.out.println(rs.getString("nome"));
                EPC EPCTemp = new EPC(d.rs.getInt("idEPC"),
                        d.rs.getString("Nome"));
                listaDeEPC.add(EPCTemp);
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
        return listaDeEPC;
    }

    public boolean atualizarDadosEPCRetirada(int EPC_idEPC, int Funcionario_Registro, Date Data_retirado) {
        d.connectToDb();
        //Comando em SQL
        String sql = "INSERT INTO Historico_EPC(Funcionario_Registro,EPC_idEPC,Data_retirado) "
                + "values (?,?,?)";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, Funcionario_Registro);
            d.pst.setInt(2, EPC_idEPC);
            d.pst.setDate(3, Data_retirado);
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
    
    public boolean atualizarDadosEPCDevolvido(int EPC_idEPC, Date Data_devolvido, int Funcionario_Registro) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE Historico_EPC SET Data_devolvido=? WHERE EPC_idEPC=? and Funcionario_Registro=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setDate(1, Data_devolvido);
            d.pst.setInt(2, EPC_idEPC);
            d.pst.setInt(3, Funcionario_Registro);
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
