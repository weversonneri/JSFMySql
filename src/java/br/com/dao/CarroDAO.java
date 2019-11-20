/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.ConectaBD;
import br.com.modelo.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Family
 */
public class CarroDAO {
    private String sql;
    private Connection con;
    private PreparedStatement ps;
    
    
     public boolean salvar(Carro car){
        try{
            con = ConectaBD.abrirConexao();
            sql = "INSERT INTO tbcarros (placa, modelo, marca, preco) VALUES (?, ?, ?, ?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, car.getPlaca());
            ps.setString(2, car.getModelo());
            ps.setString(3, car.getMarca());
            ps.setDouble(4, car.getPreco());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
       public boolean alterar(Carro car){
        try{
            con = ConectaBD.abrirConexao();
            sql = "UPDATE tbcarros SET placa=?, modelo=?, marca=?, preco=?, where id=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, car.getPlaca());
            ps.setString(2, car.getModelo());
            ps.setString(3, car.getMarca());
            ps.setDouble(4, car.getPreco());
            ps.setInt(5, car.getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

       
       public boolean remover(Carro car){
        try{
            con = ConectaBD.abrirConexao();
            sql = "DELETE FROM tbcarros WHERE id=? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, car.getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    public List<Carro> getListaCarros() {
        ArrayList<Carro> listaCar = new ArrayList<>();
        con = ConectaBD.abrirConexao();
        sql = "SELECT id, placa, modelo, marca, preco FROM tbcarros";
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Carro car = new Carro();
                car.setId(rs.getInt("id"));
                car.setPlaca(rs.getString("placa"));
                car.setModelo(rs.getString("modelo"));
                car.setMarca(rs.getString("marca"));
                car.setPreco(rs.getDouble("preco"));
                listaCar.add(car);
            }
            return listaCar;
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
}
}