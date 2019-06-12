package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Categoria;
import exception.CategoriaDAOException;

@WebServlet("/view/cadastrarCategoria")
public class CadastrarCategoriaController extends HttpServlet{

	private static final long serialVersionUID = -2626939262190807250L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
	
		CategoriaController categoriaController = new CategoriaController();
		
		String nomeCategoria = req.getParameter("categoria");
		
		Categoria categoria = new Categoria();
		
		categoria.setNome(nomeCategoria);
		
		try {
			categoriaController.inserirCategoria(categoria);
			req.setAttribute("mensagem", "Categoria cadastrada com sucesso.");
			try {
				req.getRequestDispatcher("./CadastrarCategoria.jsp").forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} catch (CategoriaDAOException e) {
			try {
				req.setAttribute("erro", e.getMessage());
				req.getRequestDispatcher("./CadastrarCategoria.jsp").forward(req, res);
			} catch (ServletException | IOException ie) {
				ie.printStackTrace();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
	
		try {
			res.sendRedirect("./CadastrarCategoria.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
