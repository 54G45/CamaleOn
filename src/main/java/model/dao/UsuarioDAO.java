package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Banco;
import model.vo.Usuario;

public class UsuarioDAO {

	public int cadastrar(Usuario u) {
		String sql = "insert into usuario values(null, ?, ?, ?, ?)";
		int chaveRetornada = -1;
		Connection con = Banco.getConnection();
		PreparedStatement pStmt = Banco.getPreparedStmtPK(con, sql);
		ResultSet rs = null;
		try {
			pStmt.setString(1, u.getUsuario());
			pStmt.setString(2, u.getEmail());
			pStmt.setString(3, u.getTelefone());
			pStmt.setString(4, u.getSenha());

			pStmt.executeUpdate();

			rs = pStmt.getGeneratedKeys();

			if (rs.next()) {
				chaveRetornada = rs.getInt(1);
				u.setId(chaveRetornada);
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

	public Usuario login(Usuario u) {
		Usuario retorno = null;
		String sql = "select * from usuario where e_mail = ? and senha = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pStmt = Banco.getPreparedStmt(conn, sql);
		ResultSet rs = null;
		try {
			pStmt.setString(1, u.getEmail());
			pStmt.setString(2, u.getSenha());
			rs = pStmt.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setUsuario(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setTelefone(rs.getString(4));
				u.setSenha(rs.getString(5));
				retorno = u;
			}
		} catch (SQLException e) {
			System.out.println("Erro no método emailDisponivel da classe UsuarioDAO");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeStatement(pStmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public Usuario pesquisarVendedorPorId(Usuario vendedor) {

		String sql = "select * from usuario where id = ?";
		Usuario usuario = null;
		Connection conn = Banco.getConnection();
		PreparedStatement pStmt = Banco.getPreparedStmt(conn, sql);
		ResultSet rs = null;
		try {
			pStmt.setInt(1, vendedor.getId());
			rs = pStmt.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setEmail(rs.getString("e_mail"));
				usuario.setTelefone(rs.getString("telefone"));

			}
		} catch (SQLException e) {
			usuario = null;
			System.out.println("Erro no método buscarPorId da classe UsuarioDAO");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closeStatement(pStmt);
			Banco.closeConnection(conn);
		}

		return usuario;

	}

}
