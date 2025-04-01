package dao;

import java.util.ArrayList;
import model.Vehiculo;

public class VehiculosDao {

    public void insertar(Vehiculo vehiculo){
        String sql = "INSERT INTO vehiculos (matricula, marca, modelo, año, km, nBastidor) VALUES (?, ?, ?, ?, ?, ?)";

        try (var connection = ConexionDB.conectar(); 
        var statement = connection.prepareStatement(sql)) {
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

    public void eliminar(String matricula){
        String sql = "DELETE FROM vehiculos WHERE matricula = ?";

        try (var connection = ConexionDB.conectar(); 
        var statement = connection.prepareStatement(sql)){
            statement.setString(1, matricula);
            statement.executeUpdate();
            System.out.println("vehiculo eliminado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarMatricula(String matriculaVieja, String matriculaNueva){
        String sql = "UPDATE vehiculos SET matricula = ? WHERE matricula = ?";

        try (var connection = ConexionDB.conectar();
        var statement = connection.prepareStatement(sql)) {
            statement.setString(1, matriculaNueva);
            statement.setString(2, matriculaVieja);
            statement.executeUpdate();
            System.out.println("Matricula actualizada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarMarca(String matricula, String marcaNueva){
        String sql = "UPDATE vehiculos SET marca = ? WHERE matricula = ?";

        try (var connection = ConexionDB.conectar();
        var statement = connection.prepareStatement(sql)) {
            statement.setString(1, marcaNueva);
            statement.setString(2, matricula);
            statement.executeUpdate();
            System.out.println("Marca actualizada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarModelo(String matricula, String modeloNuevo){
        String sql = "UPDATE vehiculos SET modelo = ? WHERE matricula = ?";

        try (var connection = ConexionDB.conectar();
        var statement = connection.prepareStatement(sql)) {
            statement.setString(1, modeloNuevo);
            statement.setString(2, matricula);
            statement.executeUpdate();
            System.out.println("Modelo actualizado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarAño(String matricula, int añoNuevo){
        String sql = "UPDATE vehiculos SET año = ? WHERE matricula = ?";

        try (var connection = ConexionDB.conectar();
        var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, añoNuevo);
            statement.setString(2, matricula);
            statement.executeUpdate();
            System.out.println("Año actualizado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarKm(String matricula, int kmNuevo){
        String sql = "UPDATE vehiculos SET km = ? WHERE matricula = ?";

        try (var connection = ConexionDB.conectar();
        var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, kmNuevo);
            statement.setString(2, matricula);
            statement.executeUpdate();
            System.out.println("Kilometros actualizados");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarNºBastidor(String matricula, String nBastidorNuevo){
        String sql = "UPDATE vehiculos SET nBastidor = ? WHERE matricula = ?";

        try (var connection = ConexionDB.conectar();
        var statement = connection.prepareStatement(sql)) {
            statement.setString(1, nBastidorNuevo);
            statement.setString(2, matricula);
            statement.executeUpdate();
            System.out.println("Nº de bastidor actualizado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Vehiculo> obtenerTodos(){
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculos";

        try (var connection = ConexionDB.conectar(); 
        var statement = connection.prepareStatement(sql); 
        var resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String matricula = resultSet.getString("matricula");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int año = resultSet.getInt("año");
                int km = resultSet.getInt("km");
                String nBastidor = resultSet.getString("nBastidor");

                Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, año, km, nBastidor);
                listaVehiculos.add(vehiculo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVehiculos;
    }

    public void mostrarVehiculo(String matricula){
        String sql = "SELECT * FROM vehiculos WHERE matricula = ?";

        try (var connection = ConexionDB.conectar(); 
        var statement = connection.prepareStatement(sql)) {
            statement.setString(1, matricula);
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int año = resultSet.getInt("año");
                int km = resultSet.getInt("km");
                String nBastidor = resultSet.getString("nBastidor");

                System.out.println("Vehículo encontrado: ");
                System.out.println("Matricula: " + matricula);
                System.out.println("Marca: " + marca);
                System.out.println("Modelo: " + modelo);
                System.out.println("Año: " + año);
                System.out.println("Kilometros: " + km);
                System.out.println("Nº de bastidor: " + nBastidor);
            } else {
                System.out.println("Vehículo no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
