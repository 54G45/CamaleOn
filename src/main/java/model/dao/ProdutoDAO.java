package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.vo.Pesquisa;
import model.vo.Produto;
import model.vo.Usuario;

public class ProdutoDAO {

	public Produto cadastrar(Produto produto) {

		String sql = "insert into produto (nome, descricao, categoria, preco, idusuario) values(?, ?, ?, ?, ?)";
		int chaveRetornada = -1;
		Connection con = Banco.getConnection();
		PreparedStatement pStmt = Banco.getPreparedStmtPK(con, sql);
		ResultSet rs = null;
		try {
			pStmt.setString(1, produto.getNome());
			pStmt.setString(2, produto.getDescricao());
			pStmt.setString(3, produto.getCategoria());
			pStmt.setString(4, produto.getPreco());
			pStmt.setInt(5, produto.getVendedor().getId());

			pStmt.executeUpdate();

			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				chaveRetornada = rs.getInt(1);
				produto.setId(chaveRetornada);
			}
		} catch (SQLException e) {
			System.out.println("Erro no método inserir da classe UsuarioDAO");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closeStatement(pStmt);
			Banco.closeConnection(con);
		}

		return produto;
	}

	public ArrayList<Produto> pesquisar(Pesquisa pesquisa) {
		
		
		String sql ="select * from produto where ";
		
		String filtro = "";
		if(pesquisa.getNomeProduto() != null) {
			filtro += "nome like '%" + pesquisa.getNomeProduto() + "%' ";
		}
		if(!filtro.isEmpty()) {
			filtro += "and ";
		}
		if(pesquisa.getCategoria() != null) {
			filtro += "categoria = '" + pesquisa.getCategoria() + "'";
		}
		sql += filtro;
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		Connection conn = Banco.getConnection();
		Statement pstmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		try {
			resultado = pstmt.executeQuery(sql);
			while(resultado.next()){
				
				Produto produto = montaProduto(resultado);
				
				produtos.add(produto);
			}
		}
		catch(SQLException e){
			System.out.println("Erro no método busca da classe PerguntaDAO");
			System.out.println(e.getMessage());
		}
		finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
	
		return produtos;

	}

	public Produto montaProduto(ResultSet rs) throws SQLException{
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("idusuario"));

		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setNome(rs.getString("nome"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setCategoria(rs.getString("categoria"));
		produto.setPreco(rs.getString("preco"));
		produto.setVendedor(usuario);
		
		
		
		return produto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
