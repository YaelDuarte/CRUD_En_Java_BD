package com.yael.controlador;
import javax.swing.JOptionPane;

import com.yael.logica.*;


public class ControladorAlumnos {
	AlumnoService funciones = new AlumnoService();
	int seleccion;
	
	public void menu() {
	do {
		
		try {
			seleccion = Integer.parseInt(JOptionPane.showInputDialog("\tBienvenido al gestor, selecciona una opcion\n1.Crear Alumno"
					+ "\n2.Eliminar Alumno"
					+ "\n3.Mostrar Alumnos\n4.Modificar Alumno\n5.Buscar Alumno\n6.Salir"));
		} catch (NumberFormatException e) {
		    JOptionPane.showMessageDialog(null, "Entrada inválida");
		    continue;
		}
		
		
		
		switch(seleccion) {
		case 1:
			String nombre = JOptionPane.showInputDialog("Ingresa el nombre: ");
			int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad"));
			int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID"));
			funciones.crearAlumno(id, nombre, edad);
			break;
			
		case 2:
			int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del alumno a eliminar"));
			funciones.eliminarAlumno(idEliminar);
			break;
		case 3:
			funciones.mostrarAlumnos();
			break;
		case 4:
			int idModif = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del alumno a modificar"));
			funciones.modificarAlumno(idModif);
			break;
		case 5:
			int idMostrar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del alumno a mostrar"));
			funciones.buscarAlumno(idMostrar);
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Gracias, hasta luego!","ADIOS",JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opcion invalida","INVALIDO",JOptionPane.ERROR_MESSAGE);
			break;
				
		}
	}while(seleccion != 6);
	
	
	
	}
}
