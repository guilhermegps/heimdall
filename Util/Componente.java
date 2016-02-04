/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Util;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author guilherme
 */
public class Componente {
    private int id;
    private String codigo;
    private Modelo modelo;
    private Veiculo veiculo;
    private String rfid;
    private String nome;
    private String descricao;
    private Date validade;
    private Timestamp registro;

    public Componente() {
    }

    public Componente(int id, String codigo, Modelo modelo, Veiculo veiculo, String rfid, String nome, String descricao, Date validade, Timestamp registro) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.veiculo = veiculo;
        this.rfid = rfid;
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.registro = registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Timestamp getRegistro() {
        return registro;
    }

    public void setRegistro(Timestamp registro) {
        this.registro = registro;
    }
    
}
