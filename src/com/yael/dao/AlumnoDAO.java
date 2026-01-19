package com.yael.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.yael.config.ConexionBD;
import com.yael.modelo.Alumno;

public class AlumnoDAO {

    // CREATE
    public void insertarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumnos (id, nombre, edad) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, alumno.getId());
            ps.setString(2, alumno.getNombre());
            ps.setInt(3, alumno.getEdad());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar alumno: " + e.getMessage());
        }
    }

    // READ - Buscar por ID
    public Alumno buscarPorId(int id) {

        String sql = "SELECT * FROM alumnos WHERE id = ?";
        Alumno alumno = null;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad")
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno: " + e.getMessage());
        }

        return alumno;
    }

    // READ - Listar todos
    public List<Alumno> listarAlumnos() {

        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad")
                ));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar alumnos: " + e.getMessage());
        }

        return lista;
    }

    // UPDATE
    public void actualizarAlumno(Alumno alumno) {

        String sql = "UPDATE alumnos SET nombre = ?, edad = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getEdad());
            ps.setInt(3, alumno.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar alumno: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminarAlumno(int id) {

        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + e.getMessage());
        }
    }
}

