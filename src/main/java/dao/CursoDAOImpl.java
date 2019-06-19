package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.Curso;
import entity.Professor;
import exception.CursoDAOException;

public class CursoDAOImpl implements CursoDAO {

	@Override
	public void insertCurso(Curso curso) throws CursoDAOException{

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_curso (nome_curso, descricao, duracao, estatus, "
					+ "cod_coordenador, cod_professor, cod_categoria) values (?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, curso.getNomeCurso());
			st.setString(2, curso.getDescricao());
			st.setInt(3, curso.getDuracao());
			st.setString(4, curso.getEstatus());

			st.setInt(5, curso.getCoordenador().getCodCoordenador());
			st.setInt(6, curso.getProfessor().getCodProfessor());
			st.setInt(7, curso.getCategoria().getCodCategoria());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new CursoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public Curso getById(int id) throws CursoDAOException{

		Connection con = null;

		Curso curso = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select nome_curso, descricao, duracao, estatus, data_criacao, data_alteracao, cod_professor "
					   + "from wc_curso where "
					   + "cod_curso = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				String nome = rs.getString("nome_curso");
				String descricao = rs.getString("descricao");
				int duracao = rs.getInt("duracao");
				String estatus = rs.getString("estatus");
				java.sql.Date dataCriacao = rs.getDate("data_criacao");
				java.sql.Date dataAlteracao = rs.getDate("data_alteracao");
				int codProfessor = rs.getInt("cod_professor");

				curso = new Curso();
				Professor professor = new Professor();
				
				professor.setCodProfessor(codProfessor);
				curso.setNomeCurso(nome);
				curso.setDescricao(descricao);
				curso.setDuracao(duracao);
				curso.setEstatus(estatus);
				curso.setDataCriacao(dataCriacao);
				curso.setDataAlteracao(dataAlteracao);
				curso.setProfessor(professor);

			}

			st.close();

		} catch (SQLException e) {
			throw new CursoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return curso;
	}

	@Override
	public List<Curso> getAll() throws CursoDAOException{

		Connection con = null;

		List<Curso> cursos = new ArrayList<Curso>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_curso, nome_curso, descricao, duracao, estatus, data_criacao, "
					   + "data_alteracao from wc_curso where estatus = 'H' ";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codCurso = rs.getInt("cod_curso");
				String nome = rs.getString("nome_curso");
				String descricao = rs.getString("descricao");
				int duracao = rs.getInt("duracao");
				String estatus = rs.getString("estatus");
				Date dataCriacao = rs.getDate("data_criacao");
				Date dataAlteracao = rs.getDate("data_alteracao");

				Curso curso = new Curso();

				curso.setCodCurso(codCurso);
				curso.setNomeCurso(nome);
				curso.setDescricao(descricao);
				curso.setDuracao(duracao);
				curso.setEstatus(estatus);
				curso.setDataCriacao(dataCriacao);
				curso.setDataAlteracao(dataAlteracao);

				cursos.add(curso);

			}
			
			st.close();

		} catch (SQLException e) {
			throw new CursoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return cursos;
	}

	@Override
	public List<Curso> getAllHD() throws CursoDAOException{
		
		Connection con = null;

		List<Curso> cursos = new ArrayList<Curso>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_curso, nome_curso, descricao, duracao, case "+
		                 "when estatus = 'D' THEN 'Desabilitado' "+
		                 "when estatus = 'H' THEN 'Habilitado' "+
		                 "end estatus, data_criacao, data_alteracao from wc_curso";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codCurso = rs.getInt("cod_curso");
				String nome = rs.getString("nome_curso");
				String descricao = rs.getString("descricao");
				int duracao = rs.getInt("duracao");
				String estatus = rs.getString("estatus");
				Date dataCriacao = rs.getDate("data_criacao");
				Date dataAlteracao = rs.getDate("data_alteracao");

				Curso curso = new Curso();

				curso.setCodCurso(codCurso);
				curso.setNomeCurso(nome);
				curso.setDescricao(descricao);
				curso.setDuracao(duracao);
				curso.setEstatus(estatus);
				curso.setDataCriacao(dataCriacao);
				curso.setDataAlteracao(dataAlteracao);

				cursos.add(curso);

			}
			
			st.close();

		} catch (SQLException e) {
			throw new CursoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return cursos;
	}

	@Override
	public void updateEstatus(Curso curso, String estatus) throws CursoDAOException{
	
		Connection con = null;
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "update wc_curso set estatus = ? where cod_curso = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, estatus);
			st.setInt(2, curso.getCodCurso());
			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			throw new CursoDAOException();
		} finally {
			JDBCUtil.close(con);
		}
		
	}

	@Override
	public List<Curso> getAllByProfessor(Professor professor) throws CursoDAOException {
		
		Connection con = null;

		List<Curso> cursos = new ArrayList<Curso>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_curso, nome_curso, descricao, duracao, estatus, data_criacao, "
					   + "data_alteracao from wc_curso where cod_professor = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, professor.getCodProfessor());
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codCurso = rs.getInt("cod_curso");
				String nome = rs.getString("nome_curso");
				String descricao = rs.getString("descricao");
				int duracao = rs.getInt("duracao");
				String estatus = rs.getString("estatus");
				Date dataCriacao = rs.getDate("data_criacao");
				Date dataAlteracao = rs.getDate("data_alteracao");

				Curso curso = new Curso();

				curso.setCodCurso(codCurso);
				curso.setNomeCurso(nome);
				curso.setDescricao(descricao);
				curso.setDuracao(duracao);
				curso.setEstatus(estatus);
				curso.setDataCriacao(dataCriacao);
				curso.setDataAlteracao(dataAlteracao);

				cursos.add(curso);

			}
			
			st.close();

		} catch (SQLException e) {
			throw new CursoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return cursos;
		
	}

}
