package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import entity.Categoria;
import exception.CategoriaDAOException;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public void insertCategoria(Categoria categoria) throws CategoriaDAOException{

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "Insert into wc_categoria (nome) values (?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, categoria.getNome());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new CategoriaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public Categoria getById(int id) {

		Connection con = null;

		Categoria categoria = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select nome from wc_categoria where cod_categoria = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				String nome = rs.getString("nome");

				categoria = new Categoria();

				categoria.setNome(nome);

			}

			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return categoria;
	}

	@Override
	public List<Categoria> getAll() {

		Connection con = null;

		List<Categoria> categorias = new ArrayList<Categoria>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_categoria, nome from wc_categoria";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codCategoria = rs.getInt("cod_categoria");
				String nome = rs.getString("nome");

				Categoria categoria = new Categoria();

				categoria.setCodCategoria(codCategoria);
				categoria.setNome(nome);

				categorias.add(categoria);

			}
			
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return categorias;
	}

}
