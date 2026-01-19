package com.yael.modelo;

public class Alumno{
	
	
	private int id;
	private String nombre;
	private int edad;
	
	public Alumno(int id,String nombre,int edad) {
		this.id = id;
		this.nombre = nombre;
		setEdad(edad);
	}

	// Metodos gette para obtener los datos
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		if(edad <=0) {
			throw new IllegalArgumentException("Edad invalida");
		}else {
			this.edad = edad;
		}
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// El metodo toString es para mostrar al alumno
	@Override
	public String toString() {
		return id + "," + nombre + "," + edad;
	}
	
	
	
	
}
