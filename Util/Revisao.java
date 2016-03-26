/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Util;

import java.sql.Timestamp;

/**
 *
 * @author guilherme
 */
public class Revisao {
    private int id;
    private Usuario usuario;
    private Veiculo veiculo;
    private Timestamp registro;
    private String descricao;

    public Revisao(int id, Usuario usuario, Veiculo veiculo, Timestamp registro, String descricao) {
        this.id = id;
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.registro = registro;
        this.descricao = descricao;
    }

    public Revisao(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Timestamp getRegistro() {
        return registro;
    }

    public void setRegistro(Timestamp registro) {
        this.registro = registro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
