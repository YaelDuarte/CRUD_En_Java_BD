package com.yael.logica;
//import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.yael.dao.AlumnoDAO;
import com.yael.modelo.Alumno;

public class AlumnoService {
	private AlumnoDAO alumnoDAO = new AlumnoDAO();

	public void crearAlumno(int id,String nombre,int edad) {
		alumnoDAO.insertarAlumno(new Alumno(id, nombre, edad));
	}
	
	public void eliminarAlumno(int id) {
		alumnoDAO.eliminarAlumno(id);
	}
	
	
	public void modificarAlumno(int id) {
		Alumno alumno = alumnoDAO.buscarPorId(id);

	    if (alumno == null) {
	        JOptionPane.showMessageDialog(null, "Alumno no encontrado");
	        return;
	    }

	    String nuevoNombre = JOptionPane.showInputDialog(
	            "Nuevo nombre:", alumno.getNombre());

	    int nuevaEdad = Integer.parseInt(
	            JOptionPane.showInputDialog(
	                    "Nueva edad:", alumno.getEdad()));

	    alumno.setNombre(nuevoNombre);
	    alumno.setEdad(nuevaEdad);

	    alumnoDAO.actualizarAlumno(alumno);

	    JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente");
	}
	
	
	// Buscamos mediane el ID del alumno
	public void buscarAlumno(int id) {
		Alumno alumno = alumnoDAO.buscarPorId(id);
		if(alumno == null) {
			JOptionPane.showMessageDialog(null, "Alumno no encontrado");
		}else {
			JOptionPane.showMessageDialog(null, alumno.toString());
		}
	}
	
	// Mostramos el listado de los alumnos
	public void mostrarAlumnos() {
		List <Alumno> alumnos = alumnoDAO.listarAlumnos();
		
		if(alumnos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay alumnos para mostrar");
			return;
		}
		
		StringBuilder sb = new StringBuilder("\tLista de Alumnos\n");
		
		for(Alumno alumno: alumnos) {
			sb.append(alumno.toString()).append("\n---------------\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString());
	}
	
}
