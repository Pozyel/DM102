/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Ferramenta;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author antun
 */
public class FerramentaDAO {

    Dao d = new Dao();

    public boolean inserirFerramenta(Ferramenta novoFerramenta) {
        d.connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO Ferramenta (Numero_Serie,Nome,Quantidade) "
                + "values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, novoFerramenta.getNumero_Serie());
            d.pst.setString(2, novoFerramenta.getNome());
            d.pst.setInt(3, novoFerramenta.getQuantidade());

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

    public boolean atualizarDadosFerramenta(String novoNome, int novoQuantidade, int Numero_Serie) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE Ferramenta SET nome=?, Quantidade=? WHERE Numero_Serie=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setString(1, novoNome);
            d.pst.setInt(2, novoQuantidade);
            d.pst.setInt(3, Numero_Serie);
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

    public boolean deletarFerramenta(int Numero_Serie) {
        d.connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM Ferramenta WHERE Numero_Serie=?";
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, Numero_Serie);
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

    public ArrayList<Ferramenta> buscarFerramentaSemFiltro() {
        ArrayList<Ferramenta> listaDeFerramenta = new ArrayList<>();
        d.connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM Ferramenta";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            d.st = d.con.createStatement();
            d.rs = d.st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de Ferramenta: ");
            while (d.rs.next()) {
                //System.out.println(rs.getString("nome"));
                Ferramenta ferramentaTemp = new Ferramenta(d.rs.getInt("Numero_Serie"),
                        d.rs.getString("Nome"), d.rs.getInt("Quantidade"));
                System.out.println("Numero_Serie = " + ferramentaTemp.getNumero_Serie());
                System.out.println("Nome = " + ferramentaTemp.getNome());
                System.out.println("Registro = " + ferramentaTemp.getQuantidade());
                System.out.println("---------------------------------");
                listaDeFerramenta.add(ferramentaTemp);
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
        return listaDeFerramenta;
    }

        public boolean atualizarDadosFerramentaComUsuario(int Numero_Serie, int novoQuantidade, int Funcionario_Registro) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE Ferramenta SET Funcionario_Registro=?, Quantidade=? WHERE Numero_Serie=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, Funcionario_Registro);
            d.pst.setInt(2, novoQuantidade);
            d.pst.setInt(3, Numero_Serie);
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
