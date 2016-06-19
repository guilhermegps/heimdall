/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall;

import heimdall.forms.JErro;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author guilherme
 */
public class ConexaoLeitoraRFID extends Thread{
    private static final Logger logger = LogManager.getLogger(ConexaoLeitoraRFID.class.getName());
    
    private boolean killThread;
    private DataOutputStream esc;
    private DataInputStream ler;
    private Socket socket;
    private boolean erroConexao;
    private String rfid;
    private ConfiguracaoSistema configuracaoSistema;

    public ConexaoLeitoraRFID() {
        configuracaoSistema = new ConfiguracaoSistema();
        killThread = false;
        esc = new DataOutputStream(out);
        ler = new DataInputStream(in);
        erroConexao = true;
    }
        
    public void run(){   
        while(!killThread){
            while(erroConexao && !killThread)
                conectaTCP();
            
            try {
                if(socket!=null && !socket.isClosed() && !erroConexao){
                    esc = new DataOutputStream(socket.getOutputStream());
                    ler = new DataInputStream(socket.getInputStream());

                    esc.writeBytes("ping");
                    byte b[] = new byte[11]; //Vetor que limita o tamanho do recebimento da informação
                    ler.read(b, 0, 11); //Recebe em vetor de bytes
                    rfid = new String(b);
                } else{
                    erroConexao = true;
                }
            }
            catch(SocketTimeoutException ex){
                rfid = "";
            }
            catch(Exception ex){
                if(!socket.isClosed())
                    new JErro(true, ex, true, true, false);
            }
            closeConexao();
        }
        closeConexao();
    }
    
    private void conectaTCP(){
        try {
            String endereco = (configuracaoSistema.getEnderecoTCPLeitora()!=null) ? configuracaoSistema.getEnderecoTCPLeitora() : "0.0.0.0";
            int porta = (configuracaoSistema.getPortaTCPLeitora()!=null) ? Integer.parseInt(configuracaoSistema.getPortaTCPLeitora()) : 0;
            int timeout = (configuracaoSistema.getTimeoutLeitora()!=null) ? Integer.parseInt(configuracaoSistema.getTimeoutLeitora()) : 0;
            socket = new Socket();
            socket.connect(new InetSocketAddress(endereco, porta), timeout); //Timeout de conexão. Retorna uma exception caso não consiga conexao dentro do tempo determinado
            socket.setSoTimeout(2000); //Lança um SocketTimeoutException caso não haja comunicação dentro do prazo estipulado após abrir comunicação no socket
            erroConexao = false;
        } catch (SocketTimeoutException ex) {
            ex = new SocketTimeoutException("Houve um problema na conexão com a leitora RFID: "+ex.getMessage());
            new JErro(false, ex, true, true, false);
            erroConexao = true;
        } catch (SocketException ex) {
            ex = new SocketException("Houve um problema na conexão com a leitora RFID: "+ex.getMessage());
            new JErro(false, ex, true, true, false);
            erroConexao = true;
        } catch (Exception ex) {
            new JErro(true, ex, true, true, false);
        }
    }
    
    public void finalizar(){
        killThread = true;
        closeConexao();
    }
    
    private void closeConexao(){
        try {
            esc.close();
            ler.close();
            socket.close();
        } catch (IOException ex) {
            new JErro(true, ex, true, true, false);
        }
    }

    public String getRfid() {
        String codigo = rfid;
        rfid = "";
        return codigo;
    }

    public boolean isErroConexao() {
        return erroConexao;
    }    
}
