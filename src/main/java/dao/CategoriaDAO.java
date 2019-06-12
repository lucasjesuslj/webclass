package dao;

import java.util.List;
import entity.Categoria;
import exception.CategoriaDAOException;

public interface CategoriaDAO {

	void insertCategoria(Categoria categoria) throws CategoriaDAOException;
	
	Categoria getById(int id);

	List<Categoria> getAll();

}
