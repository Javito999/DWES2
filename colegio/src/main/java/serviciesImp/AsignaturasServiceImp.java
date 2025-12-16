package serviciesImp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.IAsignaturasDAO;
import daoImplement.AsignaturasDAOImpl;
import DTO.AsignaturaDTO;
import servicios.IAsignaturasService;

public class AsignaturasServiceImp implements IAsignaturasService {

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException {
        IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();

        return asignaturas.obtenerTodasAsignaturas();
    }

    @Override
    public ArrayList<AsignaturaDTO> obtenerAsignaturasPorFiltros(String id, String nombre, String curso, String tasa,
            int activo) {
        IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
        return asignaturas.obtenerAsignaturasPorFiltros(id, nombre, curso, tasa, activo);
    }

    @Override
    public int insertarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
        IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
        return asignaturas.insertarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int actualizarAsignatura(String id, String nombre, String curso, String tasa, int activo) {
        IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
        return asignaturas.actualizarAsignatura(id, nombre, curso, tasa, activo);
    }

    @Override
    public int borrarAsignatura(String id) {
        IAsignaturasDAO asignaturas = new AsignaturasDAOImpl();
        return asignaturas.borrarAsignatura(id);
    }

}