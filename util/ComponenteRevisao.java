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
public class ComponenteRevisao {
    private Componente componente;
    private Revisao revisao;
    private boolean identificado;
    private Timestamp identificacao;
    private String motivo;

    public ComponenteRevisao(Componente componente, Revisao revisao, boolean identificado, Timestamp identificacao, String motivo) {
        this.componente = componente;
        this.revisao = revisao;
        this.identificado = identificado;
        this.identificacao = identificacao;
        this.motivo = motivo;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
    }

    public boolean isIdentificado() {
        return identificado;
    }

    public void setIdentificado(boolean identificado) {
        this.identificado = identificado;
    }

    public Timestamp getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Timestamp identificacao) {
        this.identificacao = identificacao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
