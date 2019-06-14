package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Aula;
import entity.AulaAtiva;
import entity.CursoAtivo;

public class AulaAtivaDAOImpl implements AulaAtivaDAO {

	//insere Atividade Ativa  
	@Override
	public void insertAulaAtiva(AulaAtiva aulaAtiva) {

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_aula_ativa (cod_curso, cod_aluno, cod_aula) " + "values (?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, aulaAtiva.getCursoAtivo().getCurso().getCodCurso());
			st.setInt(2, aulaAtiva.getCursoAtivo().getAluno().getCodAluno());
			st.setInt(3, aulaAtiva.getAula().getCodAula());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public AulaAtiva getByAlunoCursoAndAula(CursoAtivo cursoAtivo, Aula aula) {
		
		Connection con = null;
		
		AulaAtiva aulaAtiva = new AulaAtiva();
				
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select case estatus " 
					   + "when 'P' then 'Em Progresso' "
					   + "when 'C' then 'Concluída' "
					   + "end estatus from wc_aula_ativa where cod_curso = ? and cod_aluno = ? and cod_aula = ?"; 
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, cursoAtivo.getCurso().getCodCurso());
			st.setInt(2, cursoAtivo.getAluno().getCodAluno());
			st.setInt(3, aula.getCodAula());
			
			ResultSet rs = st.executeQuery();
			
			if (rs.first()) {
				
				String estatus = rs.getString("estatus");
				
				aulaAtiva.setCursoAtivo(cursoAtivo);
				aulaAtiva.setAula(aula);
				aulaAtiva.setEstatus(estatus);
				
			}
			
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}
		
		return aulaAtiva;
	}
	
	@Override
	public List<AulaAtiva> getByAlunoAndCurso(CursoAtivo cursoAtivo) {
		
		Connection con = null;
		
		List<AulaAtiva> aulasAtivas = new ArrayList<AulaAtiva>();
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select cod_aula, estatus from wc_aula_ativa where cod_aluno = ? and cod_curso = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, cursoAtivo.getAluno().getCodAluno());
			st.setInt(2, cursoAtivo.getCurso().getCodCurso());
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				int codAula = rs.getInt("cod_aula");
				String estatus = rs.getString("estatus");
				
				AulaAtiva aulaAtiva = new AulaAtiva();
				Aula aula = new Aula();
				
				aula.setCodAula(codAula);
				aulaAtiva.setCursoAtivo(cursoAtivo);
				aulaAtiva.setAula(aula);
				aulaAtiva.setEstatus(estatus);
				
				aulasAtivas.add(aulaAtiva);
				
			}
			
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}
		
		return aulasAtivas;
	}

	@Override
	public void updateStatus(AulaAtiva aulaAtiva, String status) {

		Connection con = null;
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "update wc_aula_ativa set estatus = ? where cod_curso = ? and cod_aluno = ? and cod_aula = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, status);
			st.setInt(2, aulaAtiva.getCursoAtivo().getCurso().getCodCurso());
			st.setInt(3, aulaAtiva.getCursoAtivo().getAluno().getCodAluno());
			st.setInt(4, aulaAtiva.getAula().getCodAula());
			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}
	}

	public int getCountByCursoAtivo(CursoAtivo cursoAtivo){

		Connection con = null;
		int quantidade = 0;

		try {
	
			con = JDBCUtil.getConnection();

			String sql = "select count(aa.cod_aula) from wc_aula_ativa aa, wc_aula aula where " 
			           + "aula.cod_aula = aa.cod_aula and aa.estatus = 'C' and aula.cod_curso = ? "
			           + "and aa.cod_aluno = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, cursoAtivo.getCurso().getCodCurso());
			st.setInt(2, cursoAtivo.getAluno().getCodAluno());

			ResultSet rs = st.executeQuery();

			if (rs.first()) {
			
				quantidade = rs.getInt("count(aa.cod_aula)"); 

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
