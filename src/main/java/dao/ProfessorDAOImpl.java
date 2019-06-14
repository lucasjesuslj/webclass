package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import entity.Professor;
import exception.ProfessorDAOException;

public class ProfessorDAOImpl implements ProfessorDAO {

	@Override
	public void insertProfessor(Professor professor) throws ProfessorDAOException{

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "Insert into wc_professor (nome, email, senha) values (?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, professor.getNome());
			st.setString(2, professor.getEmail());
			st.setString(3, professor.getSenha());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new ProfessorDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public Professor getByEmailAndSenha(String email, String senha) {

		Professor professor = null;
		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_professor, nome from wc_professor where email = ? and senha = ?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				int codProfessor = rs.getInt("cod_professor");
				String nome = rs.getString("nome");

				professor = new Professor();

				professor.setCodProfessor(codProfessor);
				professor.setNome(nome);

			}
			
			st.close();
			
		} catch (SQLException e) {
			throw new ProfessorDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return professor;
	}

	@Override
	public Professor getById(int id) {

		Connection con = null;

		Professor professor = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select nome, email, senha from wc_professor where cod_professor = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");

				professor = new Professor();

				professor.setNome(nome);
				professor.setEmail(email);
				professor.setSenha(senha);

			}

			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return professor;
	}

	@Override
	public List<Professor> getAll() {

		Connection con = null;

		List<Professor> professores = new ArrayList<Professor>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_professor, nome, email from wc_professor";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int codProfessor = rs.getInt("cod_professor");
				String nome = rs.getString("nome");
				String email = rs.getString("email");

				Professor professor = new Professor();

				professor.setCodProfessor(codProfessor);
				professor.setNome(nome);
				professor.setEmail(email);

				professores.add(professor);

			}

			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
		}

		return professores;
	}

}
