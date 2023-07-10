package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Banco;

public class CarrinhoDAO {
	
	public int adicionarAoCarrinho(int idProduto, int idUsuario) {
		
		String sql = "insert into carrinho(idproduto, idusuario) values(?, ?)";
		int chaveRetornada = -1;
		Connection con = Banco.getConnection();
		PreparedStatement pStmt = Banco.getPreparedStmtPK(con, sql);
		ResultSet rs = null;
		try {
			pStmt.setInt(1, idProduto);
			pStmt.setInt(2, idUsuario);

			pStmt.executeUpdate();

			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				chaveRetornada = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro no método inserir da classe UsuarioDAO");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closeStatement(pStmt);
			Banco.closeConnection(con);
		}
		
		return chaveRetornada;
		
	}

	public int removerDoCarrinho(int id) {
		// TODO Auto-generated method stub
		
		String sql = "delete from carrinho where carrinho.idproduto = " + id;
		int linhasAfetadas = 0;
		Connection con = Banco.getConnection();
		PreparedStatement pStmt = Banco.getPreparedStmt(con, sql);
		try {
			
			linhasAfetadas = pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro no método excluirCarrinho");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeStatement(pStmt);
			Banco.closeConnection(con);
		}
		
		return linhasAfetadas;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
