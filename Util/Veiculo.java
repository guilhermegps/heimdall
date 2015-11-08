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
public class Veiculo {
    
    private int id;
    private Modelo modelo;
    private Cor cor;
    private String nome;
    private String rfid;
    private String placa;
    private float km;
    private String observacao;
    private String dataHora;

    public Veiculo() {
        this.id = 0;
        this.modelo = null;
        this.cor = null;
        this.nome = "";
        this.rfid = "";
        this.placa = "";
        this.km = 0;
        this.observacao = "";
        this.dataHora = "";
    }
    
    public Veiculo(int id, Modelo modelo, Cor cor, String nome, String rfid, String placa, float km, String observacao, String dataHora) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
        this.nome = nome;
        this.rfid = rfid;
        this.placa = placa;
        this.km = km;
        this.observacao = observacao;
        this.dataHora = dataHora;
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", modelo=" + modelo + ", cor=" + cor + ", nome=" + nome + ", rfid=" + rfid + ", placa=" + placa + ", km=" + km + ", observacao=" + observacao + ", dataHora=" + dataHora + '}';
    }
}
