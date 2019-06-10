package dao;

import java.util.List;
import entity.Categoria;

public interface CategoriaDAO {

	void insertCategoria(Categoria categoria);
	
	Categoria getById(int id);

	List<Categoria> getAll();

}
