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
public class Veiculo {
    
    private int id;
    private Modelo modelo;
    private Cor cor;
    private int codigo;
    private String nome;
    private String rfid;
    private String placa;
    private float km;
    private String observacao;
    private Timestamp registro;

    public Veiculo() {
        this.id = 0;
        this.modelo = new Modelo();
        this.cor = new Cor();
        this.codigo = 0;
        this.nome = new String();
        this.rfid = new String();
        this.placa = new String();
        this.km = 0;
        this.observacao = new String();
        this.registro = new Timestamp(0);
    }

    public Veiculo(int id, Modelo modelo, Cor cor, int codigo, String nome, String rfid, String placa, float km, String observacao, Timestamp registro) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
        this.codigo = codigo;
        this.nome = nome;
        this.rfid = rfid;
        this.placa = placa;
        this.km = km;
        this.observacao = observacao;
        this.registro = registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Timestamp getRegistro() {
        return registro;
    }

    public void setRegistro(Timestamp registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
}
