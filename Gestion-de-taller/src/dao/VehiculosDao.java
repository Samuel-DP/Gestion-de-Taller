package dao;

import model.Vehiculo;

public class VehiculosDao {
    public void insertar(Vehiculo vehiculo){
        String sql = "INSERT INTO vehiculos (matricula, marca, modelo, año, km, nBastidor) VALUES (?, ?, ?, ?, ?, ?)";
        try (var connection = ConexionDB.conectar(); var statement = connection.prepareStatement(sql)) {
            statement.setString(1, vehiculo.getMatricula());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getModelo());
            statement.setInt(4, vehiculo.getAño());
            statement.setInt(5, vehiculo.getKm());
            statement.setString(6, vehiculo.getnBastidor());
            statement.executeUpdate();
            
            System.out.println("Vehículo insertado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
