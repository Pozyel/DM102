/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author antun
 */
public class FuncionarioDAO {

    Dao d = new Dao();

    public boolean inserirFuncionario(Funcionario novoFuncionario) {
        d.connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO Funcionario (Registro,Nome,CPF) "
                + "values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, novoFuncionario.getRegistro());
            d.pst.setString(2, novoFuncionario.getNome());
            d.pst.setString(3, novoFuncionario.getCPF());

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

    public boolean atualizarDadosFuncionario(int Registro, String novoNome, String novoCPF) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE Funcionario SET Nome=?, CPF=? WHERE Registro=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setString(1, novoNome);
            d.pst.setString(2, novoCPF);
            d.pst.setInt(3, Registro);
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

    public boolean deletarFuncionario(int Registro) {
        d.connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM Funcionario WHERE Registro=?";
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, Registro);
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

    public ArrayList<Funcionario> buscarFuncionarioSemFiltro() {
        ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();
        d.connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM Funcionario";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try {
            d.st = d.con.createStatement();
            d.rs = d.st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de Funcionarios: ");
            while (d.rs.next()) {
                //System.out.println(rs.getString("nome"));
                Funcionario usuarioTemp = new Funcionario(d.rs.getInt("Registro"),
                        d.rs.getString("nome"), d.rs.getString("cpf"));
                System.out.println("Registro = " + usuarioTemp.getRegistro());
                System.out.println("Nome = " + usuarioTemp.getNome());
                System.out.println("CPF = " + usuarioTemp.getCPF());
                System.out.println("---------------------------------");
                listaDeFuncionarios.add(usuarioTemp);
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
        return listaDeFuncionarios;
    }

    public boolean atualizarDadosFuncionarioComEPI(int Registro, int EPI_idEPI) {
        d.connectToDb();
        //Comando em SQL
        String sql = "UPDATE Funcionario SET EPI_idEPI=? WHERE Registro=?";

        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try {
            d.pst = d.con.prepareStatement(sql);
            d.pst.setInt(1, EPI_idEPI);
            d.pst.setInt(2, Registro);
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
