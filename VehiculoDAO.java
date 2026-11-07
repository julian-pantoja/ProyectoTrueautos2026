package modelo;

import conexion.Conexion;
import java.sql.*;

public class VehiculoDAO {

    // 1. INSERTAR
    public void registrarVehiculo(String placa, String modelo, String tipoMotor, String cliente, String estado) {
        String sql = "INSERT INTO vehiculos (placa, modelo, tipo_motor, cliente, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, placa);
            pst.setString(2, modelo);
            pst.setString(3, tipoMotor);
            pst.setString(4, cliente);
            pst.setString(5, estado);
            pst.executeUpdate();
            System.out.println("Vehículo registrado exitosamente en TRUEAUTOS.");
        } catch (SQLException e) {
            System.err.println("Error al registrar vehículo: " + e.getMessage());
        }
    }

    // 2. CONSULTAR
    public void listarVehiculos() {
        String sql = "SELECT * FROM vehiculos";
        try (Connection con = Conexion.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            System.out.println("\n--- LISTADO DE VEHÍCULOS EN TALLER (TRUEAUTOS) ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   " | Placa: " + rs.getString("placa") + 
                                   " | Modelo: " + rs.getString("modelo") + 
                                   " | Motor: " + rs.getString("tipo_motor") + 
                                   " | Cliente: " + rs.getString("cliente") + 
                                   " | Estado: " + rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar vehículos: " + e.getMessage());
        }
    }

    // 3. ACTUALIZAR
    public void actualizarEstadoVehiculo(int id, String nuevoEstado) {
        String sql = "UPDATE vehiculos SET estado = ? WHERE id = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nuevoEstado);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Estado del vehículo actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // 4. ELIMINAR
    public void eliminarVehiculo(int id) {
        String sql = "DELETE FROM vehiculos WHERE id = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Vehículo eliminado del registro.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}
