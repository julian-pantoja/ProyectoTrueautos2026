

import modelo.VehiculoDAO;

public class Main {
    public static void main(String[] args) {
        VehiculoDAO dao = new VehiculoDAO();

        // 1. Probar la inserción de un vehículo en el taller
        dao.registrarVehiculo("XYZ789H", "BYD Seagull", "Eléctrico", "Diana Marcela", "En Diagnóstico de Batería");

        // 2. Probar la consulta para listar los vehículos registrados
        dao.listarVehiculos();
    }
}