/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall;
import heimdall.Forms.JErro;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
 
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import static javax.management.Query.lt;
import javax.swing.JOptionPane;
 
/**
 *
 * @author DESENVOLVIMENTO05
 */
public class EncriptaDecriptaAES {
     
    /*
        Adaptação do código original do site http://www.devmedia.com.br/utilizando-criptografia-simetrica-em-java/31170 
    */
 
    private String IV = "AAAAAAAAAAAAAAAA";
    private final String chavePadrao = "165A78F494EE4285821D40990AA8D106";
    
    public byte[] encriptaAES(byte[] valorpuro){
        return encriptaAES(valorpuro, chavePadrao);
    }
    
    public byte[] decriptaAES(byte[] valorencriptado){
        return decriptaAES(valorencriptado, chavePadrao);
    }
 
    public byte[] encriptaAES(byte[] valorpuro, String chave){
        chave = meiaHash(chave);
        Cipher encripta;
        try {
            encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
            SecretKeySpec key = new SecretKeySpec(chave.getBytes("UTF-8"), "AES");
            encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
            return encripta.doFinal(valorpuro);
        } catch (Exception ex) {
            new JErro(true, ex, true, false, false);
        }
        return null;
    }
 
    public byte[] decriptaAES(byte[] valorencriptado, String chave){   
        try {
            chave = meiaHash(chave);
            Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
            SecretKeySpec key = new SecretKeySpec(chave.getBytes("UTF-8"), "AES");
            decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
            return decripta.doFinal(valorencriptado);
        } catch (Exception ex) {
            new JErro(true, ex, true, false, false);
            return null;
        }
    }
     
    private String meiaHash(String chave){
            String meiaHash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = hash = new BigInteger(1, md.digest(chave.getBytes("UTF-8")));//Cria hash MD5 da senha criptografada
            chave = String.format("%32x", hash);
            for(int i=0; i<chave.length();i++){
                if(i%2==0){
                    meiaHash += chave.charAt(i);
                }
            }
        } catch (Exception ex) {
            new JErro(true, ex, true, false, false);
        }
        return meiaHash;
    }
}