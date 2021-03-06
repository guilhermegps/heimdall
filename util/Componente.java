/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author guilherme
 */
public class Componente {
    private int id;
    private Modelo modelo;
    private Veiculo veiculo;
    private int codigo;
    private String rfid;
    private String nome;
    private String descricao;
    private Timestamp validade;
    private Timestamp registro;
    private boolean ativo;

    public Componente() {
        this.id = 0;
        this.modelo = null;
        this.veiculo = null;
        this.codigo = 0;
        this.rfid = new String();
        this.nome = new String();
        this.descricao = new String();
        this.validade = new Timestamp(0);
        this.registro = new Timestamp(0);
    }

    public Componente(int id, Modelo modelo, Veiculo veiculo, int codigo, String rfid, String nome, String descricao, Timestamp validade, Timestamp registro, boolean ativo) {
        this.id = id;
        this.modelo = modelo;
        this.veiculo = veiculo;
        this.codigo = codigo;
        this.rfid = rfid;
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.registro = registro;
        this.ativo = ativo;
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getValidade() {
        return validade;
    }

    public void setValidade(Timestamp validade) {
        this.validade = validade;
    }

    public Timestamp getRegistro() {
        return registro;
    }

    public void setRegistro(Timestamp registro) {
        this.registro = registro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome  + " (" + rfid + ")";
    }
    
}