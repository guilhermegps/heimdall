/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

//import java.beans.Statement;  Essa não é a biblioteca q queremos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class Conexao {
    private Connection conexao;

    public Conexao(){
            try{
                    //Arquivo de Driver / Carrega o JDBC
                    Class.forName("org.postgresql.Driver");

                    //Conexão com Banco de Dados
                    String url = "jdbc:postgresql://localhost:5432/heimdall";/*jdbc:NOMEDOSGBD://ENDEREÇODAMAQUINAONDEESTAOBD:PORTA/BD*/
                    conexao = DriverManager.getConnection(url,"postgres","123456");
                    System.out.println("Conectou ao banco");

                    /*/Comandos SQL no Banco de Dados
                    comando = conexao.prepareStatement("INSERT INTO ");*/


            }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"ERRO DE CONEXÃO COM O BD: "+ex.getMessage());
            }
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
}
