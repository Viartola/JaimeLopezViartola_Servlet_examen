package servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
public class Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pais = req.getParameter("pais");
		String idioma = req.getParameter("Idioma");
		String nIdioma = req.getParameter("nuevoIdioma");
		
		Sql.crearTablaPaises();
		Sql.crearTablaIdiomas();
		Sql.insertarTablaIdiomas(nIdioma);
		Sql.insertarTablaPaises(pais, nIdioma);

		redirect(resp);
		//super.doPost(req, resp);
	}
	
	private void redirect(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("Paises.jsp");
	}
}
