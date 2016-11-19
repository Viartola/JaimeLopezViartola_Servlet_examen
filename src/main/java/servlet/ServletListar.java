package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import service.*;

public class ServletListar extends HttpServlet {
	List<Paises> listAllPaises = new ArrayList<Paises>();
	private Service servicio = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		listAllPaises = servicio.listarPaises();
		req.setAttribute("listAllPaises", listAllPaises);
		redirect(req,resp);
	}

	private void redirect(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Mostrar.jsp");
		dispatcher.forward(req,resp);
	}
}
