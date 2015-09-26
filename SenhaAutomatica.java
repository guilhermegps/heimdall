/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author guilherme
 */
public class SenhaAutomatica {
    
    private int tamanho;
    private String senhaSimples = new String();
    private String senhaEncriptada = new String();

    public SenhaAutomatica(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public String senhaSemiAutomatica(String valor){//Senha criptografada criada a partir de uma senha automática e um valor especificado 
        String senha = gerarSenha(tamanho);
        senha = encripta(valor+senha);
        
        return senha;
    }
    
    public String encripta (String senha) {     
        try {       
            for(int i=0; i<2; i++){
                BASE64Encoder b64 = new BASE64Encoder();
                senha = b64.encode(senha.getBytes());//criptografa pelo Base64
                
                MessageDigest md = MessageDigest.getInstance("MD5");
                BigInteger hash = hash = new BigInteger(1, md.digest(senha.getBytes("UTF-8")));//Cria hash MD5 da senha criptografada 
                senha = String.format("%32x", hash);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(SenhaAutomatica.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return senha;         
     }  
    
    public String gerarSenha(int digitos){
        String senha = new String();
        //int digitos = Integer.parseInt(JOptionPane.showInputDialog("Quantos digitos a senha deve ter?"));
        for(int i=0;i<digitos;i++){
            int x = (49+(int)(Math.random()*42)); 
            if((x>=58&&x<=64)){
                i--;
            } else if(silabas(senha)>1){
                String aux="";
                for(int j=0;j<(senha.length()-1);j++){
                    aux+=senha.charAt(j);
                }
                senha=aux;
                senha+= (char) x;
                i--;
            } else{
                    senha+= (char) x;
            }
        }
        senhaSimples = senha;
        return senha;
    } 
    
    public static int silabas(String senha){
        int silabas = 0;
        String consoantes = "BCDFGHJKLMNPQRSTVWXYZ";
        String vogais = "AEIOU";
        
        for(int i=0;i<(senha.length()-1);i++){ 
            for(int j=0;j<consoantes.length();j++){ //Percorre todas as consoantes 
                if(senha.charAt(i) == consoantes.charAt(j)){ 
                    for(int k=0;k<vogais.length();k++){ //Percorre todas as vogais
                        if(senha.charAt(i+1)==vogais.charAt(k)){ 
                            silabas++;
                        }
                    }
                }
            }
        }
        return silabas;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getSenhaSimples() {
        return senhaSimples;
    }

    public String getSenhaEncriptada() {
        return senhaEncriptada;
    }
}
