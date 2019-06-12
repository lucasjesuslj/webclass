package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Aula;
import entity.Curso;
import exception.AulaDAOException;

public class AulaDAOImpl implements AulaDAO {

	@Override
	public void insertAula(Aula aula) {

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_aula (descricao, cod_curso) values (?, ?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, aula.getDescricao());
			st.setInt(3, aula.getCurso().getCodCurso());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public Aula getById(int id) {
		
		Connection con = null;

		Aula aula = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select descricao, dataCriacao from wc_aula where cod_aula = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				String descricao = rs.getString("descricao");
				java.sql.Date dataCriacao = rs.getDate("dataCriacao");

				aula = new Aula();

				aula.setDescricao(descricao);
				aula.setDataCriaco(dataCriacao);

			}

			st.close();

		} catch (SQLException e) {
			throw new AulaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return aula;
	}

	@Override
	public List<Aula> getByCurso(Curso curso) {

		Connection con = null;
		List<Aula> aulas = new ArrayList<Aula>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_aula, descricao from wc_aula where cod_curso = ? order by dataCriacao";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, curso.getCodCurso());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codAula = rs.getInt("cod_aula");
				String descricao = rs.getString("descricao");

				Aula aula = new Aula();

				aula.setCodAula(codAula);
				aula.setDescricao(descricao);

				aulas.add(aula);

			}

			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return aulas;
	}

	public int getCountByCurso(Curso curso) {

		Connection con = null;
		int quantidade = 0;

		try {

			con = JDBCUtil.getConnection();

			String sql = "select count(cod_aula) from wc_aula where cod_curso = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, curso.getCodCurso());

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				quantidade = rs.getInt("count(cod_aula)");

			}

			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return quantidade;

	}

}
