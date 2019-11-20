/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;

import br.com.dao.CarroDAO;
import br.com.modelo.Carro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Family
 */
@ManagedBean (name = "bean")
@SessionScoped
public class CarroBean {
    private Carro carro;
    private CarroDAO dao;
    private List<Carro> carros;
    
    public CarroBean() {
        carro = new Carro();
        dao = new CarroDAO();
        carros = dao.getListaCarros();
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
    
 public void salvar(){
        dao.salvar(carro);
        carro = new Carro();
        carros = dao.getListaCarros();
    }
    
    public void alterar(){
        dao.alterar(carro);
        carro = new Carro();
        carros = dao.getListaCarros();
    }
    
    public void alterar(Carro car){
        carro = car;
    }
     
    public void remover(Carro car) {
        dao.remover(car);
        carros.remove(car);
    }
    
    
}
