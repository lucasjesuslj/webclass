package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Atividade;
import entity.Aula;

public class AtividadeDAOImpl implements AtividadeDAO {

	@Override
	public void insertAtividade(Atividade atividade) {

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_atividade (descricao, tipo, resposta, cod_aula) values (?, ?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, atividade.getDescricao());
			st.setInt(2, atividade.getTipo());
			st.setString(3, atividade.getResposta());
			st.setInt(4, atividade.getAula().getCodAula());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
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

			String sql = "select cod_atividade, descricao, tipo, resposta from wc_atividade where cod_aula = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, aula.getCodAula());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codAtividade = rs.getInt("cod_atividade");
				String descricao = rs.getString("descricao");
				int tipo = rs.getInt("tipo");
				String resposta = rs.getString("resposta");

				Atividade atividade = new Atividade();

				atividade.setCodAtividade(codAtividade);
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

}
