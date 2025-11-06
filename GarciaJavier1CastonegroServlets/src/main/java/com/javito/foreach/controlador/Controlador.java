package com.javito.foreach.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.javito.foreach.beans.DesplegableDTO;

import Negocio.Rol;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/listaJugadores")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DesplegableDTO> jugadores = Rol.obtenerJugadores();
		request.setAttribute("opcionesDesplegable", jugadores);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listaJugadores.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idJugador"));
		String nombreJugador = Rol.obtenerNombreJugadorPorId(id);
		String rol = Rol.asignarRolAleatorio();

		request.setAttribute("opcionesDesplegable", Rol.obtenerJugadores());
		request.setAttribute("nombreJugador", nombreJugador);
		request.setAttribute("rol", rol);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listaJugadores.jsp");
		rd.forward(request, response);
	}

}
