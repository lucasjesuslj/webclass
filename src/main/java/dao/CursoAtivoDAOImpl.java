package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.Aluno;
import entity.Curso;
import entity.CursoAtivo;

public class CursoAtivoDAOImpl implements CursoAtivoDAO {

	@Override
	public void insertCursoAtivo(CursoAtivo cursoAtivo) {

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_curso_ativo (cod_curso, cod_aluno) values (?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, cursoAtivo.getCurso().getCodCurso());
			st.setInt(2, cursoAtivo.getAluno().getCodAluno());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public List<CursoAtivo> getAllByAluno(Aluno aluno) {

		Connection con = null;

		List<CursoAtivo> cursosAtivos = new ArrayList<CursoAtivo>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select c.cod_curso, c.nome_curso, c.data_alteracao from wc_curso c "
					+ "INNER JOIN wc_curso_ativo ca on c.cod_curso = ca.cod_curso " + "where cod_aluno = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, aluno.getCodAluno());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codCurso = rs.getInt("c.cod_curso");
				String nomeCurso = rs.getString("c.nome_curso");
				Date dataAlteracao = rs.getDate("c.data_alteracao");

				CursoAtivo cursoAtivo = new CursoAtivo();
				Curso curso = new Curso();

				curso.setCodCurso(codCurso);
				curso.setNomeCurso(nomeCurso);
				curso.setDataAlteracao(dataAlteracao);
				cursoAtivo.setCurso(curso);

				cursosAtivos.add(cursoAtivo);

			}

			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return cursosAtivos;
	}

	@Override
	public CursoAtivo getByAlunoAndCurso(Curso curso, Aluno aluno) {

		Connection con = null;
		CursoAtivo cursoAtivo = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select estatus from wc_curso_ativo where cod_curso = ? and cod_aluno = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, curso.getCodCurso());
			st.setInt(2, aluno.getCodAluno());
			
			ResultSet rs = st.executeQuery();
			
			if (rs.first()) {
				
				cursoAtivo = new CursoAtivo();
				
				cursoAtivo.setEstatus(rs.getString("estatus"));
				
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return cursoAtivo;
	}

}
