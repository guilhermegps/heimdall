/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall.Util;

/**
 *
 * @author guilherme
 */
public class Modelo {
    
    private int id;
    private int codigo;
    private Classe classe;
    private String modelo;
    private String marca;
    private String layout;

    public Modelo() {
        this.id = 0;
        this.classe = null;
        this.modelo = null;
        this.marca = null;
        this.layout = null;
    }

    public Modelo(int id, int codigo, Classe classe, String modelo, String marca, String layout) {
        this.id = id;
        this.codigo = codigo;
        this.classe = classe;
        this.modelo = modelo;
        this.marca = marca;
        this.layout = layout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public String toString() {
        return modelo;
    }   
}