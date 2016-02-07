/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

//import java.beans.Statement;  Essa não é a biblioteca q queremos
import heimdall.Forms.JErro;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author guilherme
 */
public class ConexaoDB {
    private Connection conexao;
    private ConfiguracaoSistema configuracaoSistema;

    public ConexaoDB(){
        configuracaoSistema = new ConfiguracaoSistema();
        try{
            //Arquivo de Driver / Carrega o JDBC
            Class.forName("org.postgresql.Driver");

            //Conexão com Banco de Dados
            String url = "jdbc:postgresql://"+configuracaoSistema.getEnderecoBD()+":"+configuracaoSistema.getPortaBD()+"/"+configuracaoSistema.getNomeBD()+"";/*jdbc:NOMEDOSGBD://ENDEREÇODAMAQUINAONDEESTAOBD:PORTA/BD*/
            conexao = DriverManager.getConnection(url,"postgres",configuracaoSistema.getSenhaBD());
            System.out.println("Conectou ao banco");
        }catch(Exception ex){
            new JErro(true, ex, false, true, true);
        }
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
}
