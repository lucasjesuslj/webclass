package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Atividade;
import entity.AtividadeAtiva;
import entity.AulaAtiva;
import exception.AtividadeAtivaDAOException;

public class AtividadeAtivaDAOImpl implements AtividadeAtivaDAO {

	@Override
	public void insertAtividadeAtiva(AtividadeAtiva atividadeAtiva) throws AtividadeAtivaDAOException {

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_atividade_ativa (cod_curso, cod_aluno, cod_aula, cod_atividade) "
					   + "values (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, atividadeAtiva.getAulaAtiva().getCursoAtivo().getCurso().getCodCurso());
			st.setInt(2, atividadeAtiva.getAulaAtiva().getCursoAtivo().getAluno().getCodAluno());
			st.setInt(3, atividadeAtiva.getAulaAtiva().getAula().getCodAula());
			st.setInt(4, atividadeAtiva.getAtividade().getCodAtividade());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new AtividadeAtivaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public List<AtividadeAtiva> getByAula(AulaAtiva aulaAtiva) throws AtividadeAtivaDAOException{
		
		Connection con = null;
		
		List<AtividadeAtiva> atividadesAtivas = new ArrayList<AtividadeAtiva>();
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select cod_atividade, estatus, comentario from wc_atividade_ativa "
					   + "where cod_aluno = ? and cod_curso = ? and cod_aula = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, aulaAtiva.getCursoAtivo().getAluno().getCodAluno());
			st.setInt(2, aulaAtiva.getCursoAtivo().getCurso().getCodCurso());
			st.setInt(3, aulaAtiva.getAula().getCodAula());
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				int codAtividade = rs.getInt("cod_atividade");
				String estatus = rs.getString("estatus");
				String comentario = rs.getString("comentario");
								
				AtividadeAtiva atividadeAtiva = new AtividadeAtiva();
				Atividade atividade = new Atividade();
				
				atividade.setCodAtividade(codAtividade);
				atividadeAtiva.setAulaAtiva(aulaAtiva);
				atividadeAtiva.setAtividade(atividade);
				atividadeAtiva.setEstatus(estatus);
				atividadeAtiva.setComentario(comentario);

				atividadesAtivas.add(atividadeAtiva);
				
			}
			
			st.close();
			
		} catch (SQLException e) {
			throw new AtividadeAtivaDAOException();
		} finally {
			JDBCUtil.close(con);
		}
		
		return atividadesAtivas;
	}
	
	@Override
	public void updateStatus(AtividadeAtiva atividadeAtiva, String status) throws AtividadeAtivaDAOException{

		Connection con = null;
		
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "update wc_atividade_ativa set estatus = ? "
					   + "where cod_curso = ? and cod_aluno = ? and cod_aula = ? and cod_atividade = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, status);
			st.setInt(2, atividadeAtiva.getAulaAtiva().getCursoAtivo().getCurso().getCodCurso());
			st.setInt(3, atividadeAtiva.getAulaAtiva().getCursoAtivo().getAluno().getCodAluno());
			st.setInt(4, atividadeAtiva.getAulaAtiva().getAula().getCodAula());
			st.setInt(5, atividadeAtiva.getAtividade().getCodAtividade());
			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			throw new AtividadeAtivaDAOException();
		} finally {
			JDBCUtil.close(con);
		}
	}

	@Override
	public AtividadeAtiva getByAulaAtivaAndAtividade(AulaAtiva aulaAtiva, Atividade atividade) throws AtividadeAtivaDAOException {
		
		Connection con = null;
		
		AtividadeAtiva atividadeAtiva = new AtividadeAtiva();
				
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select case estatus " 
					   + "when 'P' then 'Em Progresso' "
					   + "when 'C' then 'Conclu�da' "
					   + "end estatus from wc_atividade_ativa "
					   + "where cod_curso = ? and cod_aluno = ? and cod_aula = ? and cod_atividade = ?"; 
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, aulaAtiva.getCursoAtivo().getCurso().getCodCurso());
			st.setInt(2, aulaAtiva.getCursoAtivo().getAluno().getCodAluno());
			st.setInt(3, aulaAtiva.getAula().getCodAula());
			st.setInt(4, atividade.getCodAtividade());
			
			ResultSet rs = st.executeQuery();
			
			if (rs.first()) {
				
				String estatus = rs.getString("estatus");
				
				atividadeAtiva.setEstatus(estatus);
				
			}
			
			st.close();
			
		} catch (SQLException e) {
			throw new AtividadeAtivaDAOException();
		} finally {
			JDBCUtil.close(con);
		}
		
		return atividadeAtiva;
	}
	
}
