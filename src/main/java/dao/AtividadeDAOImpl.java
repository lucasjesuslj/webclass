package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Atividade;
import entity.Aula;
import exception.AtividadeDAOException;
import exception.AulaDAOException;

public class AtividadeDAOImpl implements AtividadeDAO {

	@Override
	public void insertAtividade(Atividade atividade) {

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_atividade (nome, descricao, tipo, resposta, cod_aula) values (?, ?, ?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, atividade.getNome());
			st.setString(2, atividade.getDescricao());
			st.setInt(3, atividade.getTipo());
			st.setString(4, atividade.getResposta());
			st.setInt(5, atividade.getAula().getCodAula());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new AtividadeDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public List<Atividade> getByAula(Aula aula) {
		Connection con = null;
		List<Atividade> atividades = new ArrayList<Atividade>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_atividade, nome, descricao, tipo, resposta from wc_atividade where cod_aula = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, aula.getCodAula());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codAtividade = rs.getInt("cod_atividade");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				int tipo = rs.getInt("tipo");
				String resposta = rs.getString("resposta");

				Atividade atividade = new Atividade();

				atividade.setCodAtividade(codAtividade);
				atividade.setNome(nome);
				atividade.setDescricao(descricao);
				atividade.setTipo(tipo);
				atividade.setResposta(resposta);

				atividades.add(atividade);

			}
			
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return atividades;
	}

	@Override
	public Atividade getById(int id) {
		
		Connection con = null;

		Atividade atividade = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select nome, descricao, tipo, resposta from wc_atividade where cod_atividade = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				String nome = rs.getString("nome"); 
				String descricao = rs.getString("descricao");
				int tipo = rs.getInt("tipo");
				String resposta = rs.getString("resposta");

				atividade = new Atividade();

				atividade.setNome(nome);
				atividade.setDescricao(descricao);
				atividade.setTipo(tipo);
				atividade.setResposta(resposta);

			}

			st.close();

		} catch (SQLException e) {
			throw new AulaDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return atividade;
		
	}

}
