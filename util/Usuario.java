/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall.util;

/**
 *
 * @author guilherme
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private int nivel;
    private String login;
    private String cpf;
    private boolean primeiroLogin;
    private boolean ativo;
    private boolean revisaSemAgendamento;

    public Usuario() {
        this.id = 0;
        this.nome = new String();
        this.senha =  new String();
        this.nivel = 0;
        this.login =  new String();
        this.cpf =  new String();
        this.primeiroLogin = true;
        this.ativo = false;
    }

    public Usuario(int id, String nome, String senha, int nivel, String login, String cpf, boolean primeiroLogin, boolean ativo, boolean revisaSemAgendamento) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.nivel = nivel;
        this.login = login;
        this.cpf = cpf;
        this.primeiroLogin = primeiroLogin;
        this.ativo = ativo;
        this.revisaSemAgendamento = revisaSemAgendamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isPrimeiroLogin() {
        return primeiroLogin;
    }

    public void setPrimeiroLogin(boolean primeiroLogin) {
        this.primeiroLogin = primeiroLogin;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isRevisaSemAgendamento() {
        return revisaSemAgendamento;
    }

    public void setRevisaSemAgendamento(boolean revisaSemAgendamento) {
        this.revisaSemAgendamento = revisaSemAgendamento;
    }

    @Override
    public String toString() {
        return login + " - " + nome+ " (" + cpf + ")";
    }
    
}