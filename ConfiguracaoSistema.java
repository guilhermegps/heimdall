/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall;

import heimdall.forms.JErro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author guilherme
 */
public class ConfiguracaoSistema {
    private static final Logger logger = LogManager.getLogger(ConfiguracaoSistema.class.getName());
    
    private File f;
    private final String setorBD = "[ConexaoBancoDados]", 
            campo1 = "EnderecoHostBD", 
            campo2 = "PortaConexaoBD", 
            campo3 = "NomeBD", 
            campo4 = "SenhaBD", 
            setorLeitoraRFID = "[ConexaoLeitoraRFID]",
            campo5 = "EnderecoTCP", 
            campo6 = "PortaTCP", 
            campo7 = "Timeout";
    private String enderecoBD, 
            portaBD, 
            nomeBD, 
            senhaBD,
            enderecoTCPLeitora,
            portaTCPLeitora,
            timeoutLeitora;
    private final int qtdConfig = 7;
    private EncriptaDecriptaAES AES;
    private SenhaAutomatica crypt;

    public ConfiguracaoSistema(){
        AES = new EncriptaDecriptaAES();
        crypt = new SenhaAutomatica(0);
        f = new File("heimdall.conf");
        if(f.exists()){
            carregarConfiguracao();
        } else{
            gerarConfiguracao();
        }
    }
    
    private void gerarConfiguracao(){
        logger.info("Gerando arquivo de configuração default...");
        
        enderecoBD = "localhost";
        portaBD = "5432";
        nomeBD = "heimdall";
        senhaBD = encripta("postgres");
        enderecoTCPLeitora = "192.168.100.8";
        portaTCPLeitora = "2020";
        timeoutLeitora = "1000";
        
        try {
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);//construtor que recebe também como argumento se o conteúdo será acrescentado ao invés de ser substituído (append)
            BufferedWriter bw = new BufferedWriter(fw);//construtor recebe como argumento o objeto do tipo FileWriter
            
            bw.write(setorBD);
            bw.newLine();//Quebra de linha. Tbm pode ser feito com '\n'
            bw.newLine();
            bw.write(campo1+" = "+enderecoBD);
            bw.newLine();
            bw.write(campo2+" = "+portaBD);
            bw.newLine();
            bw.write(campo3+" = "+nomeBD);
            bw.newLine();
            bw.write(campo4+" = "+senhaBD);
            bw.newLine();
            bw.newLine();
            bw.write(setorLeitoraRFID);
            bw.newLine();
            bw.newLine();
            bw.write(campo5+" = "+enderecoTCPLeitora);
            bw.newLine();
            bw.write(campo6+" = "+portaTCPLeitora);
            bw.newLine();
            bw.write(campo7+" = "+timeoutLeitora);
            
            bw.close();
            fw.close();
        
            enderecoBD = portaBD = nomeBD = senhaBD = null;
            enderecoTCPLeitora = portaTCPLeitora = timeoutLeitora = null;
            
            logger.info("Arquivo de configuração default gerado...");
            
            carregarConfiguracao();
        } catch (IOException ex) {
            new JErro(true, ex, true, true, true);
        }
    }
    
    private void carregarConfiguracao(){
        logger.debug("Carregando configurações...");
        
        int setorLido = 0;//Demarca qual o setor que está sendo lido
        try {
            FileReader fr = new FileReader(f);//construtor que recebe o objeto do tipo arquivo
            BufferedReader br = new BufferedReader(fr);//construtor que recebe o objeto do tipo FileReader
            String config[] = new String[qtdConfig];
            
            while(br.ready()){
                String linha = br.readLine().replaceAll(" ", "");
                if(!linha.equals("") && !linha.equals("\n")){
                    if(linha.equals(setorBD) || setorLido == 1){
                        setorLido = 1;
                        if(linha.length()>campo1.length()+1 && enderecoBD==null){
                            enderecoBD = (linha.substring(0, campo1.length()).equals(campo1)) ? linha.substring(campo1.length()+1) : null;
                        } else if(linha.length()>campo2.length()+1 && portaBD==null){
                            portaBD = (linha.substring(0, campo2.length()).equals(campo2)) ? linha.substring(campo2.length()+1) : null;
                        } else if(linha.length()>campo3.length()+1 && nomeBD==null){
                            nomeBD = (linha.substring(0, campo3.length()).equals(campo3)) ? linha.substring(campo3.length()+1) : null;
                        } else if(linha.length()>campo4.length()+1 && senhaBD==null){
                            senhaBD = (linha.substring(0, campo4.length()).equals(campo4)) ? decripta(linha.substring(campo4.length()+1)) : null;
                            setorLido = 0;
                        }
                    } else if(linha.equals(setorLeitoraRFID) || setorLido == 2){
                        setorLido = 2;
                        if(linha.length()>campo5.length()+1 && enderecoTCPLeitora==null){
                            enderecoTCPLeitora = (linha.substring(0, campo5.length()).equals(campo5)) ? linha.substring(campo5.length()+1) : null;
                        } else if(linha.length()>campo6.length()+1 && portaTCPLeitora==null){
                            portaTCPLeitora = (linha.substring(0, campo6.length()).equals(campo6)) ? linha.substring(campo6.length()+1) : null;
                        } else if(linha.length()>campo7.length()+1 && timeoutLeitora==null){
                            timeoutLeitora = (linha.substring(0, campo7.length()).equals(campo7)) ? linha.substring(campo7.length()+1) : null;
                            setorLido = 0;
                        }
                    }
                }
            }
            br.close();
            fr.close();
            
            logger.debug("Configurações carregadas...");
        } catch (Exception ex) {
            new JErro(true, ex, true, true, true);
        }
    }
    
    private String encripta(String valor){
        try {
            valor = crypt.base64Encoder(AES.encriptaAES(valor.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException ex) {
            new JErro(true, ex, true, true, false);
        }
        return valor;
    }
    
    private String decripta(String valor){
        try {
            valor = new String(AES.decriptaAES(crypt.base64Decoder(valor)), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            new JErro(true, ex, true, true, false);
        }
        return valor;
    }

    public String getSenhaBD() {
        return senhaBD;
    }

    public void setSenhaBD(String senhaBD) {
        this.senhaBD = senhaBD;
    }

    public String getEnderecoBD() {
        return enderecoBD;
    }

    public void setEnderecoBD(String enderecoBD) {
        this.enderecoBD = enderecoBD;
    }

    public String getPortaBD() {
        return portaBD;
    }

    public void setPortaBD(String portaBD) {
        this.portaBD = portaBD;
    }

    public String getNomeBD() {
        return nomeBD;
    }

    public void setNomeBD(String nomeBD) {
        this.nomeBD = nomeBD;
    }

    public String getEnderecoTCPLeitora() {
        return enderecoTCPLeitora;
    }

    public void setEnderecoTCPLeitora(String enderecoTCPLeitora) {
        this.enderecoTCPLeitora = enderecoTCPLeitora;
    }

    public String getPortaTCPLeitora() {
        return portaTCPLeitora;
    }

    public void setPortaTCPLeitora(String portaTCPLeitora) {
        this.portaTCPLeitora = portaTCPLeitora;
    }

    public String getTimeoutLeitora() {
        return timeoutLeitora;
    }

    public void setTimeoutLeitora(String timeoutLeitora) {
        this.timeoutLeitora = timeoutLeitora;
    }
    
}
