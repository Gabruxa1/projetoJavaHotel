package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Funcionario;

public class FuncionarioDAO {

    public void create(Funcionario f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO funcionario(usuario, senha) VALUES (?, MD5(?))";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getUsuario());
            stmt.setString(2, f.getSenha());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }

    }

    public ArrayList<Funcionario> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM funcionario";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));

                funcionarios.add(f);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar");

        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }

        return funcionarios;
    }

    public void update(Funcionario f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE funcionario "
                    + "SET usuario = ?, senha = MD5(?) "
                    + "WHERE id = ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getUsuario());
            stmt.setString(2, f.getSenha());
            stmt.setInt(3, f.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar funcionário. Erro: " + ex);
        }
    }

    public void delete(Funcionario f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM funcionario WHERE id = ?";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao remover funcionário. Erro: " + ex);
        }
    }
}
