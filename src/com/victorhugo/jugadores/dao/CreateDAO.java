package com.victorhugo.jugadores.dao;

import com.victorhugo.jugadores.db.DBConnection;

import java.sql.*;

public interface CreateDAO extends DBConnection {

    default void setField(String nombre, String aPaterno, String aMaterno, Date fNacimiento, int juegosGanados, int codigoJuegoGanado){
        try (Connection connection = connectToDB()){
            String query = "INSERT INTO RecordJugador ([nombre], [apellidopaterno], [apellidomaterno]" +
                    ",[fechanacimiento], [juegosganados], [codigojuegoganado]) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,aPaterno);
            preparedStatement.setString(3,aMaterno);
            preparedStatement.setDate(4,fNacimiento);
            preparedStatement.setInt(5,juegosGanados);
            preparedStatement.setInt(6,codigoJuegoGanado);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
