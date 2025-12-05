package servelts;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import serviciesImp.AlumnosServiceImp;
import servicios.IAlumnosService;

import java.io.IOException;
import java.util.ArrayList;

import DTO.DesplegableDTO;
import dao.IDesplegableDAO;
import daoImplement.DesplegableDAOImp;

/**
 * Servlet implementation class InsertarAlumnosController
 */
@WebServlet("/alumnos/insertarAlumno")
public class InsertarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarAlumnosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		recuperarDesplegableMunicipios(request);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/insertarAlumno.jsp");
		d.forward(request, response);
	}

	private void recuperarDesplegableMunicipios(HttpServletRequest request) {
		IDesplegableDAO desplegableMunicipios = new DesplegableDAOImp();
		ArrayList<DesplegableDTO> listaMunicipios = desplegableMunicipios.desplegableMunicipios();
		request.setAttribute("desplegableMunicipios", listaMunicipios);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String idMunicipio = request.getParameter("municipios");
		;
		String familiaNumerosa = request.getParameter("famNumerosa");
		String activo = request.getParameter("activo");
		IAlumnosService a = new AlumnosServiceImp();
		Integer resultado = a.insertarAlumno(id, nombre, apellido, idMunicipio, Integer.parseInt(familiaNumerosa),
				Integer.parseInt(activo));
		request.setAttribute("resultado", resultado);
		recuperarDesplegableMunicipios(request);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/insertarAlumno.jsp");
		d.forward(request, response);
	}

}
