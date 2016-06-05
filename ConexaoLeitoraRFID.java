/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall;

import heimdall.Forms.JErro;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author guilherme
 */
public class ConexaoLeitoraRFID extends Thread{
    private boolean killThread;
    private DataOutputStream esc;
    private DataInputStream ler;
    private Socket socket;
    private boolean erroConexao;
    private String rfid;

    public ConexaoLeitoraRFID() {
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
            socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.100.8", 2020), 1000); //Timeout de conexão. Retorna uma exception caso não consiga conexao dentro do tempo determinado
            socket.setSoTimeout(2000); //Lança um SocketTimeoutException caso não haja comunicação dentro do prazo estipulado após abrir comunicação no socket
            erroConexao = false;
        } catch (SocketTimeoutException ex) {
            ex = new SocketTimeoutException("Houve um problema na conexão com a leitora RFID: "+ex.getMessage());
            new JErro(false, ex, true, true, false);
            erroConexao = true;
        } catch (Exception ex) {
            new JErro(false, ex, true, true, false);
            erroConexao = true;
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
