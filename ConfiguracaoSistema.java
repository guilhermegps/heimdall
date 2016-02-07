/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall;

import heimdall.Forms.JErro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class ConfiguracaoSistema {
    private File f;
    private final String campo1 = "EnderecoHostBD = ", campo2 = "PortaConexaoBD = ", campo3 = "NomeBD = ", campo4 = "SenhaBD = ";
    private String enderecoBD, portaBD, nomeBD, senhaBD;
    private final int qtdConfig = 4;

    public ConfiguracaoSistema(){
        f = new File("heimdall.conf");
        if(f.exists()){
            carregarConfiguracao();
        } else{
            gerarConfiguracao();
        }
    }
    
    private void gerarConfiguracao(){
        enderecoBD = "localhost";
        portaBD = "5432";
        nomeBD = "heimdall";
        senhaBD = "postgres";
        
        try {
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);//construtor que recebe também como argumento se o conteúdo será acrescentado ao invés de ser substituído (append)
            BufferedWriter bw = new BufferedWriter(fw);//construtor recebe como argumento o objeto do tipo FileWriter
            
            bw.write("DADOS DE CONEXÃO COM O BANCO DE DADOS:");
            bw.newLine();
            bw.write(campo1+enderecoBD);
            bw.newLine();//Quebra de linha. Tbm pode ser feito com '\n'
            bw.newLine();
            bw.write(campo2+portaBD);
            bw.newLine();
            bw.newLine();
            bw.write(campo3+nomeBD);
            bw.newLine();
            bw.newLine();
            bw.write(campo4+senhaBD);
            
            bw.close();
            fw.close();
        
            enderecoBD = portaBD = nomeBD = senhaBD = null;
            carregarConfiguracao();
        } catch (IOException ex) {
            new JErro(true, ex, true, false, true);
        }
    }
    
    private void carregarConfiguracao(){
        try {
            FileReader fr = new FileReader(f);//construtor que recebe o objeto do tipo arquivo
            BufferedReader br = new BufferedReader(fr);//construtor que recebe o objeto do tipo FileReader
            String config[] = new String[qtdConfig];
            
            while(br.ready()){//equanto houver mais linhas
                String linha = br.readLine().trim();
                if(linha.compareTo("")!=0 && linha.compareTo("\n")!=0){
                    if(linha.length()>17 && enderecoBD==null){
                        enderecoBD = (linha.substring(0, 17).compareTo(campo1)==0) ? linha.substring(17).trim() : enderecoBD;
                    } else if(linha.length()>17 && portaBD==null){
                        portaBD = (linha.substring(0, 17).compareTo(campo2)==0) ? linha.substring(17).trim() : portaBD;
                    } else if(linha.length()>9 && nomeBD==null){
                        nomeBD = (linha.substring(0, 9).compareTo(campo3)==0) ? linha.substring(9).trim() : nomeBD;
                    } else if(linha.length()>10 && senhaBD==null){
                        senhaBD = (linha.substring(0, 10).compareTo(campo4)==0) ? linha.substring(10).trim() : senhaBD;
                    }
                }
            }
            br.close();
            fr.close();
        } catch (Exception ex) {
            new JErro(true, ex, true, false, true);
        }
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
    
}
