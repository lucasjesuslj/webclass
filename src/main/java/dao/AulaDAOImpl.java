package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.Aula;
import entity.Curso;
import entity.Professor;
import exception.AulaDAOException;

public class AulaDAOImpl implements AulaDAO{

	@Override
	public void insertAula(Aula aula) throws AulaDAOException{

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_aula (nome_aula, descricao, cod_curso) values (?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, aula.getNome());
			st.setString(2, aula.getDescricao());
			st.setInt(3, aula.getCurso().getCodCurso());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new AulaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public Aula getById(int id) throws AulaDAOException{
		
		Connection con = null;

		Aula aula = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select nome_aula, descricao, data_criacao from wc_aula where cod_aula = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				String nomeAula = rs.getString("nome_aula");  
				String descricao = rs.getString("descricao");
				Date dataCriacao = rs.getDate("data_criacao");

				aula = new Aula();

				aula.setNome(nomeAula);
				aula.setDescricao(descricao);
				aula.setDataCriacao(dataCriacao);

			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			throw new AulaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return aula;
	}

	@Override
	public List<Aula> getByCurso(Curso curso) throws AulaDAOException{

		Connection con = null;
		List<Aula> aulas = new ArrayList<Aula>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_aula, nome_aula, descricao, data_criacao from wc_aula "
					   + "where cod_curso = ? order by data_criacao";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, curso.getCodCurso());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codAula = rs.getInt("cod_aula");
				String nomeAula = rs.getString("nome_aula");
				String descricao = rs.getString("descricao");
				Date dataCriacao = rs.getDate("data_criacao");
				
				Aula aula = new Aula();

				aula.setCodAula(codAula);
				aula.setNome(nomeAula);
				aula.setDescricao(descricao);
				aula.setDataCriacao(dataCriacao);

				aulas.add(aula);

			}

			st.close();

		} catch (SQLException e) {
			throw new AulaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return aulas;
	}

	public int getCountByCurso(Curso curso) throws AulaDAOException{

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
			throw new AulaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return quantidade;

	}

	@Override
	public List<Aula> getByProfessor(Professor professor) throws AulaDAOException{
		
		Connection con = null;
		List<Aula> aulas = new ArrayList<Aula>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_aula, a.descricao, c.cod_curso, c.nome_curso from wc_aula a inner join wc_curso c "
					   + "on c.cod_curso = a.cod_curso where c.cod_professor = ? order by a.descricao";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, professor.getCodProfessor());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codAula = rs.getInt("cod_aula");
				String descricao = rs.getString("a.descricao");
				int codCurso = rs.getInt("c.cod_curso");
				String nomeCurso = rs.getString("c.nome_curso");

				Aula aula = new Aula();
				Curso curso = new Curso();

				aula.setCodAula(codAula);
				aula.setDescricao(descricao);
				curso.setCodCurso(codCurso);
				curso.setNomeCurso(nomeCurso);
				aula.setCurso(curso);
				
				aulas.add(aula);

			}

			st.close();

		} catch (SQLException e) {
			throw new AulaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return aulas;
		
	}

}
