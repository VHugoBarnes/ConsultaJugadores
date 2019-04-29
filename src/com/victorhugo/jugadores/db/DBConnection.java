package com.victorhugo.jugadores.db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBConnection {

    default Connection connectToDB(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\hugov\\Documents\\Proyectos\\TAP Víctor Hugo Vázquez Gómez\\BDJugadores.accdb");
        } catch (SQLException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al conectar.."+e);
        }

        return connection;
    }



}
