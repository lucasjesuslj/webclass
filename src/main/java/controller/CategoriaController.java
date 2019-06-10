package controller;

import java.util.List;
import entity.Categoria;
import dao.CategoriaDAO;
import dao.CategoriaDAOImpl;

public class CategoriaController {

	public CategoriaDAO dao = new CategoriaDAOImpl();

	// insere Categorias
	public void inserirCategoria(Categoria categoria) {

		try {
			dao.insertCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// select de Categorias por ID
	public Categoria getById(int id) {

		Categoria categoria = null;

		try {
			categoria = dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoria;
	}

	// lista todas as Categorias
	public List<Categoria> getAll() {

		List<Categoria> categorias = null;

		try {
			categorias = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categorias;

	}

}