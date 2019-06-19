package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import entity.Aluno;
import exception.AlunoDAOException;

public class AlunoDAOImpl implements AlunoDAO {

	@Override
	public void insertAluno(Aluno aluno) throws AlunoDAOException{

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "insert into wc_aluno (nome, email, senha) values (?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getEmail());
			st.setString(3, aluno.getSenha());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new AlunoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public Aluno getByEmailAndSenha(String email, String senha) throws AlunoDAOException {

		Aluno aluno = null;
		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select cod_aluno, nome from wc_aluno where email = ? and senha = ?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				int codAluno = rs.getInt("cod_aluno");
				String nome = rs.getString("nome");

				aluno = new Aluno();

				aluno.setCodAluno(codAluno);
				aluno.setNome(nome);

			}

			st.close();

		} catch (SQLException e) {
			throw new AlunoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return aluno;
	}

	@Override
	public Aluno getById(int id) throws AlunoDAOException {

		Connection con = null;

		Aluno aluno = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "select nome, email, senha from wc_aluno where cod_aluno = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.first()) {

				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");

				aluno = new Aluno();

				aluno.setNome(nome);
				aluno.setEmail(email);
				aluno.setSenha(senha);

			}

			st.close();

		} catch (SQLException e) {
			throw new AlunoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return aluno;
	}

	@Override
	public void updateEmail(Aluno aluno, String email) throws AlunoDAOException{

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "update wc_aluno set email = ? where cod_aluno = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, email);
			st.setInt(2, aluno.getCodAluno());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new AlunoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public void updateSenha(Aluno aluno, String senha) throws AlunoDAOException{

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();

			String sql = "update wc_aluno set senha = ? where cod_aluno = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, senha);
			st.setInt(2, aluno.getCodAluno());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new AlunoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

	}

	@Override
	public List<Aluno> getAll() throws AlunoDAOException{

		Connection con = null;

		List<Aluno> alunos = new ArrayList<Aluno>();

		try {
			con = JDBCUtil.getConnection();

			String sql = "select nome, email from wc_aluno";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("nome");
				String email = rs.getString("email");

				Aluno aluno = new Aluno();

				aluno.setNome(nome);
				aluno.setEmail(email);

				alunos.add(aluno);

			}

			st.close();

		} catch (SQLException e) {
			throw new AlunoDAOException();
		} finally {
			JDBCUtil.close(con);
		}

		return alunos;
	}

}
