package servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.*;
import service.*;

/**
 * Servlet implementation class servlet
 */
public class ServletInsertar extends HttpServlet {
	private Service servicio = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pais = req.getParameter("pais");
		String idioma = req.getParameter("Idioma");
		String nIdioma = req.getParameter("nuevoIdioma");
		
		servicio.crearTablas();
		
		if(nIdioma == ""){
			servicio.insertarPais(idioma, pais);
		}
		else{
			servicio.insertarNuevoIdioma(nIdioma, pais);
		}

		redirect(resp);
	}
	
	private void redirect(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("index.jsp");
	}
}
