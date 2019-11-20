/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Family
 */
public class ConectaBD {

    private static final String URL = "jdbc:mysql://localhost:3306/dbCarros?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;

    public static Connection abrirConexao() {
        try {
            if (con == null) {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.print("Conectado");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("ERRO");
            ex.printStackTrace();
        }
        return con;
    }
}
