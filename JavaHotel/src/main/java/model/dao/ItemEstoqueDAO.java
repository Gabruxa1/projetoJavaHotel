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
            String sql = "INSERT INTO itemestoque (nome, descricao, preco_unitario, quantidade_estoque) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getDescricao());
            stmt.setDouble(3, i.getPrecoUnitario());
            stmt.setInt(4, i.getQtdEstoque());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao inserir Produto");
            Logger.getLogger(ItemEstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<ItemEstoque> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ItemEstoque> itens = new ArrayList();
        
        try {
            String sql = "SELECT * FROM itemestoque";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ItemEstoque i = new ItemEstoque();
                i.setId(rs.getInt("id_produto"));
                i.setNome(rs.getString("nome"));
                i.setDescricao(rs.getString("descricao"));
                i.setPrecoUnitario(rs.getDouble("preco_unitario"));
                i.setQtdEstoque (rs.getInt("quantidade_estoque"));
                
                itens.add(i);
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Produtos");
            Logger.getLogger(ItemEstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return itens;
    }
    
    
    public void update(ItemEstoque i) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String sql = "UPDATE itemestoque SET nome = ?, descricao = ?, preco_unitario = ?, quantidade_estoque = ? WHERE id_produto = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getDescricao());
            stmt.setDouble(3, i.getPrecoUnitario());
            stmt.setInt(4, i.getQtdEstoque());

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
            String sql = "DELETE FROM itemestoque WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, i.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir produto. Erro: " + ex);
        }
    }
}
