/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.util;

import java.sql.Timestamp;

/**
 *
 * @author guilherme
 */
public class Revisao {
    private int id;
    private Usuario usuarioRevisao;
    private Veiculo veiculo;
    private int numero;
    private Timestamp registro;
    private String descricao;
    private Usuario usuarioAutorizador;
    private boolean executada;

    public Revisao(int id, Usuario usuarioRevisao, Veiculo veiculo, int numero, Timestamp registro, String descricao, Usuario usuarioAutorizador, boolean executada) {
        this.id = id;
        this.usuarioRevisao = usuarioRevisao;
        this.veiculo = veiculo;
        this.numero = numero;
        this.registro = registro;
        this.descricao = descricao;
        this.usuarioAutorizador = usuarioAutorizador;
        this.executada = executada;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public Usuario getUsuarioRevisao() {
        return usuarioRevisao;
    }

    public void setUsuarioRevisao(Usuario usuarioRevisao) {
        this.usuarioRevisao = usuarioRevisao;
    }

    public Usuario getUsuarioAutorizador() {
        return usuarioAutorizador;
    }

    public void setUsuarioAutorizador(Usuario usuarioAutorizador) {
        this.usuarioAutorizador = usuarioAutorizador;
    }

    public boolean isExecutada() {
        return executada;
    }

    public void setExecutada(boolean executada) {
        this.executada = executada;
    }
}
