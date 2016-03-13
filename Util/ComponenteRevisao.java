/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Util;

import java.io.Serializable;

/**
 *
 * @author guilherme
 */
public class ComponenteRevisao implements Serializable {
    private String RFID;
    private String idVeiculo; 
    private boolean verificado;

    public ComponenteRevisao() {
        this.RFID = "";
        this.idVeiculo = "";
        this.verificado = false;
    }

    public ComponenteRevisao(String RFID, String idVeiculo, boolean verificado) {
        this.RFID = RFID;
        this.idVeiculo = idVeiculo;
        this.verificado = verificado;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
}
