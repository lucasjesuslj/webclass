package dao;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.ArrayList;import java.util.List;import java.sql.Connection;import entity.Coordenador;import exception.CoordenadorDAOException;public class CoordenadorDAOImpl implements CoordenadorDAO {	@Override	public void insertCoordenador(Coordenador coordenador) {		Connection con = null;		try {			con = JDBCUtil.getConnection();			String sql = "insert into wc_coordenador (nome, email, senha) values (?, ?, ?)";			PreparedStatement st = con.prepareStatement(sql);			st.setString(1, coordenador.getNome());			st.setString(2, coordenador.getEmail());			st.setString(3, coordenador.getSenha());			st.executeUpdate();			st.close();		} catch (SQLException e) {			throw new CoordenadorDAOException();		} finally {			JDBCUtil.close(con);		}	}	@Override	public Coordenador getByEmailAndSenha(String email, String senha) {		Coordenador coordenador = null;		Connection con = null;		try {			con = JDBCUtil.getConnection();			String sql = "select cod_coordenador, nome from wc_coordenador where email like ? and senha like ?";			PreparedStatement st = con.prepareStatement(sql);			st.setString(1, email);			st.setString(2, senha);			ResultSet rs = st.executeQuery();			if (rs.first()) {				int codCoordenador = rs.getInt("cod_coordenador");				String nome = rs.getString("nome");				coordenador = new Coordenador();				coordenador.setCodCoordenador(codCoordenador);				coordenador.setNome(nome);			}						st.close();					} catch (SQLException e) {			throw new CoordenadorDAOException();		} finally {			JDBCUtil.close(con);		}		return coordenador;	}	@Override	public Coordenador getById(int id) {		Connection con = null;		Coordenador coordenador = null;		try {			con = JDBCUtil.getConnection();			String sql = "select nome, email, senha from wc_coordenador where cod_coordenador = ?";			PreparedStatement st = con.prepareStatement(sql);			st.setInt(1, id);			ResultSet rs = st.executeQuery();			if (rs.first()) {				String nome = rs.getString("nome");				String email = rs.getString("email");				String senha = rs.getString("senha");				coordenador = new Coordenador();				coordenador.setNome(nome);				coordenador.setNome(email);				coordenador.setSenha(senha);			}			st.close();		} catch (SQLException e) {			e.printStackTrace();		} finally {			JDBCUtil.close(con);		}		return coordenador;	}	@Override	public List<Coordenador> getAll() {		Connection con = null;		List<Coordenador> coordenadores = new ArrayList<Coordenador>();		try {			con = JDBCUtil.getConnection();			String sql = "select nome, email from wc_coordenador";			PreparedStatement st = con.prepareStatement(sql);			ResultSet rs = st.executeQuery();			while (rs.next()) {				String nome = rs.getString("nome");				String email = rs.getString("email");				Coordenador coordenador = new Coordenador();				coordenador.setNome(nome);				coordenador.setEmail(email);				coordenadores.add(coordenador);			}			st.close();		} catch (SQLException e) {			e.printStackTrace();		} finally {			JDBCUtil.close(con);		}		return coordenadores;	}}