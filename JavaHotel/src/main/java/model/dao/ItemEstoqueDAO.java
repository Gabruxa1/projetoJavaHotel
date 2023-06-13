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
import model.bean.ItemEstoque;


public class ItemEstoqueDAO {
    public void create(ItemEstoque i) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String sql = "INSERT INTO produto (nome, preco_unitario, quantidade_estoque, id_tipo) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setDouble(2, i.getPrecoUnitario());
            stmt.setInt(3, i.getQtdEstoque());
            stmt.setInt(4, i.getTipoProduto().getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao inserir Produto");
            Logger.getLogger(ItemEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<ItemEstoque> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ItemEstoque> produtos = new ArrayList();
        
        try {
            String sql = "SELECT * FROM itemestoque";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ItemEstoque i = new ItemEstoque();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setPrecoUnitario(rs.getDouble("preco_unitario"));
                i.setQtdEstoque(rs.getInt("quantidade_estoque"));
                i.setTipoProduto(new TipoProdutoDAO().find(rs.getInt("id_tipo")));
                
                produtos.add(i);
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Produtos");
            Logger.getLogger(ItemEstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return produtos;
    }
    
        public ItemEstoque find(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ItemEstoque i = null;
        
        try {
            String sql = "SELECT * FROM itemestoque WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                i = new ItemEstoque();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setPrecoUnitario(rs.getDouble("preco_unitario"));
                i.setQtdEstoque(rs.getInt("quantidade_estoque"));
                i.setTipoProduto(new TipoProdutoDAO().find(rs.getInt("id_tipo")));
             
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Produtos");
            Logger.getLogger(ItemEstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return i;
    }
    
    public void update(ItemEstoque i) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String sql = "UPDATE itemestoque SET nome = ?, preco_unitario = ?, quantidade_estoque = ?, id_tipo = ? WHERE id_tipo = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setDouble(2, i.getPrecoUnitario());
            stmt.setInt(3, i.getQtdEstoque());
            stmt.setInt(4, i.getTipoProduto().getId());
            stmt.setInt(5, i.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar produto. Erro: " + ex);
        }
    }
    
    public void delete(ItemEstoque i) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String sql = "DELETE FROM itemestoque WHERE id_tipo = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, i.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir produto. Erro: " + ex);
        }
    }
}

