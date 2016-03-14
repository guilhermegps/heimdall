/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Util;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author guilherme
 */
public class ComponenteRevisao implements Serializable {
    private String RFID;
    private String idVeiculo; 
    private boolean identificado;
    private String motivoNaoIdentificado;
    private Timestamp identificao;

    public ComponenteRevisao() {
        this.RFID = "";
        this.idVeiculo = "";
        this.identificado = false;
        this.motivoNaoIdentificado = "";
        this.identificao = null;
    }

    public ComponenteRevisao(String RFID, String idVeiculo, boolean identificado, String motivoNaoIdentificado, Timestamp identificao) {
        this.RFID = RFID;
        this.idVeiculo = idVeiculo;
        this.identificado = identificado;
        this.motivoNaoIdentificado = motivoNaoIdentificado;
        this.identificao = identificao;
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
        return identificado;
    }

    public void setIdentificado(boolean identificado) {
        this.identificado = identificado;
    }

    public String getMotivoNaoIdentificado() {
        return motivoNaoIdentificado;
    }

    public void setMotivoNaoIdentificado(String motivoNaoIdentificado) {
        this.motivoNaoIdentificado = motivoNaoIdentificado;
    }

    public Timestamp getIdentificao() {
        return identificao;
    }

    public void setIdentificao(Timestamp identificao) {
        this.identificao = identificao;
    }
}
