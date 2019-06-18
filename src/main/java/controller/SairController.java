package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view/sair")
public class SairController extends HttpServlet{

	private static final long serialVersionUID = 8285979842489792262L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession sessao = req.getSession();
		
		sessao.invalidate();
		
		try {
			res.sendRedirect("./Login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
