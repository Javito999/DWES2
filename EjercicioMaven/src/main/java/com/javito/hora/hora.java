package com.javito.hora;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;



/**
 * Servlet implementation class hora
 */
@WebServlet("/hora")
public class hora extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public hora() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		
		LocalTime horaLocal = LocalTime.now();

	    PrintWriter out = response.getWriter();

	    out.println("<html><body>");
	    out.println("<h2>La hora actual es: " + horaLocal + "</h2>");
	    out.println("</body></html>");
		
		
		
	    doGet(request, response);
	}
	
	public LocalTime dimeHoraActual() {

		LocalTime hora = LocalTime.now();

		return hora;

	}

}
