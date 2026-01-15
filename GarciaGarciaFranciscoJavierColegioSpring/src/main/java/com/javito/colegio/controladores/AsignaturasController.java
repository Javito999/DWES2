package com.javito.colegio.controladores;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.javito.colegio.dao.interfaces.IDesplegableDAO;
import com.javito.colegio.dtos.AsignaturaDTO;
import com.javito.colegio.dtos.DesplegableDTO;
import com.javito.colegio.repositorios.AsignaturaRepository;
import com.javito.colegio.servicio.interfaces.IAsignaturasService;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturasController {

	@Autowired
	IAsignaturasService asignaturasService;
	@Autowired
	IDesplegableDAO desplegables;
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	//-----------------
		//INSERTAR ASIGNTURA
		//-----------------
		@GetMapping("/insertarAsignatura")
		public String formularioInsertarAsignatura(ModelMap model) {
			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();

			model.addAttribute("desplegableMunicipios", listaAsignaturas);

			return "alumnos/insertarAsignatura";
		}

		@PostMapping("/insertarAsignatura")
		public String insertarAlumno(@RequestParam("id") Integer id, @RequestParam("nombre") String nombre,
				@RequestParam("curso") String curso,
				@RequestParam("tasa") Integer tasa,
				@RequestParam(value = "activo", required = false) String activo, ModelMap model) {

			ArrayList<DesplegableDTO> listaAsignaturas = desplegables.desplegableAsignaturas();
			model.addAttribute("desplegableAsignaturas", listaAsignaturas);

			
			Integer act = activo != null ? 1 : 0;

			Integer resultado = asignaturasService.insertarAsignatura(id, nombre, curso, tasa, act);

			model.addAttribute("resultado", resultado);

			return "alumnos/insertarAlumno";
		}
		
		//-----------------
		//LISTADO ASIGNATURA
		//-----------------
		@GetMapping("/listadoAsignaturas")
		public String formularioListadoAsignaturas() {
			return "asignaturas/listadoAsignaturas";
		}

		@PostMapping("/listadoAsignaturas")
		public String listadoAsignaturas(@RequestParam(value = "id", required = false) Integer id,
				@RequestParam(value = "nombre", required = false) String nombre,
				@RequestParam(value = "curso", required = false) String curso,
				@RequestParam(value = "tasa", required = false) Integer tasa,
				@RequestParam(value = "activo", required = false) String activo, ModelMap model) throws SQLException {

			
			int act = (activo != null) ? 1 : 0;

			ArrayList<AsignaturaDTO> listaAsignaturas = asignaturasService.obtenerAsignaturas(id, nombre, curso, tasa, activo);

			model.addAttribute("lista", listaAsignaturas);

			return "asignaturas/listadoAsignaturas";
		}
		
		
		//-------------------------
		//MODIFICAR ASIGNATURA
		//-------------------------
		
		//Método que simplemente nos mostrará el formulario
		@GetMapping(value = "/formularioActualizarAlumnos")
		public String formularioModificarAlumnos(ModelMap model) {
		    return "alumnos/actualizarAlumnos";
		}

		//Método que se encarga de la búsqueda de alumnos para actualizar
		@PostMapping(value = "/formularioActualizarAlumnos")
		public String formularioModificarAlumnos(@RequestParam(value = "id", required = false) Integer id,
		                                         @RequestParam(value = "nombre", required = false) String nombre,
		                                         @RequestParam(value = "apellido", required = false) String apellido,
		                                         @RequestParam(value = "famNumerosa", required = false) String famNumerosa,
		                                         @RequestParam(value = "activo", required = false) String activo,
		                                         ModelMap model) {
		    
			ArrayList<DesplegableDTO> listaMunicipios = desplegables.desplegableMunicipios();
			model.addAttribute("desplegableMunicipios", listaMunicipios);
			
		    Integer familiaNumerosa = famNumerosa != null ? 1 : 0;
		    Integer act = activo != null ? 1 : 0;

		    ArrayList<AlumnoDTO> listaAlumnos = alumnosService.obtenerAlumnosPorIdNombreApellido(id, nombre, apellido, familiaNumerosa, act);

		    model.addAttribute("lista", listaAlumnos);
		    return "alumnos/actualizarAlumnos";
		}

		//Método que lleva a cabo la actualización
		@PostMapping(value = "/actualizarAlumno")
		public String modificarAlumnos(@RequestParam("id") Integer id, 
		                               @RequestParam("nombre") String nombre,
		                               @RequestParam("apellido") String apellido,
		                               @RequestParam(value = "famNumerosa", required = false) Integer famNumerosa,
		                               @RequestParam(value = "activo", required = false) Integer activo,
		                               @RequestParam("municipio") Integer idMunicipio, 
		                               ModelMap model) {
		    

			ArrayList<DesplegableDTO> listaMunicipios = desplegables.desplegableMunicipios();
			model.addAttribute("desplegableMunicipios", listaMunicipios);

		    Integer familiaNumerosa = famNumerosa != null ? 1 : 0;
		    Integer act = activo != null ? 1 : 0;

		    Integer resultado = alumnosService.actualizarAlumno(id, nombre, apellido, idMunicipio, familiaNumerosa, act);

		    model.addAttribute("resultado", resultado);
		    return "alumnos/actualizarAlumnos";
		}
		
		
		//-------------------------
		//BORRAR ASIGNATURA
		//-------------------------
		//Método que se usa simplemente para mostrar el formulario.
		@GetMapping(value = "/formularioBorrarAlumnos")
		public String getFormularioEliminarAlumnos() {
		    return "alumnos/borrarAlumnos";
		}

		//Método que se usa para buscar los registros a borrar
		@PostMapping(value = "/formularioBorrarAlumnos")
		public String formularioEliminarAlumnos(@RequestParam(value= "id", required = false) Integer id, 
		                                        @RequestParam("nombre") String nombre,
		                                        @RequestParam("apellido") String apellido,
		                                        @RequestParam(value = "famNumerosa", required = false) Integer famNumerosa,
		                                        @RequestParam(value = "activo", required = false) Integer activo, 
		                                        ModelMap model) {
		    
		    Integer familiaNumerosa = famNumerosa != null ? 1 : 0;
		    Integer act = activo != null ? 1 : 0;

		    ArrayList<AlumnoDTO> listaAlumnos = alumnosService.obtenerAlumnosPorIdNombreApellido(id, nombre, apellido, familiaNumerosa, act);

		    model.addAttribute("lista", listaAlumnos);
		    return "alumnos/borrarAlumnos";
		}

		@PostMapping(value = "/borrarAlumno")
		public String eliminarAlumnos(@RequestParam("id") Integer id, ModelMap model) {
		    Integer resultado = alumnosService.borrarAlumno(id);

		    model.addAttribute("resultado", resultado);
		    return "alumnos/borrarAlumnos";
		}
			
		

	
}
