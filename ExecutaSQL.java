/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class ExecutaSQL {
    private PreparedStatement comando;
    private Conexao conexao;

    public ExecutaSQL() {
        conexao = new Conexao();
    }    
    
    
    public Usuario SELECT_USUARIO(String camp, String val){
        Usuario user = null;
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM tb_usuario WHERE "+camp+" = "+val);
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                user.setNome(rs.getString("no_usuario"));
                user.setSenha(rs.getString("ps_usuario"));
                user.setNivel(rs.getInt("nu_nivel_usuario"));
                user.setLogin(rs.getString("de_login_usuario"));
            }
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }
        
        return user;
    }
    
    public void DELETE_USUARIO(String cnd){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }
        
    }
    
    public void UPDATE_USUARIO(String cond, Usuario user){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
    }
    
    public boolean INSERT_USUARIO(Usuario user){
        boolean retorno = true;
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO tb_usuario VALUES (DEFAULT, ?, ?, ?, ?);");
            
            comando.setString(1, user.getSenha());
            comando.setString(2, user.getNome());
            comando.setInt(3,user.getNivel());
            comando.setString(4, user.getLogin());
            
            retorno = comando.execute();
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
        return retorno;
    }
    
    public ArrayList SELECT_CLASSE(boolean busca){
        ArrayList<Classe> c = new ArrayList<Classe>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM tb_classe WHERE bo_tipo_classe = "+busca+" ORDER BY no_classe;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Classe aux = new Classe();
                aux.setId(rs.getInt("id_classe"));
                aux.setNome(rs.getString("no_classe"));
                aux.setTipo(rs.getBoolean("bo_tipo_classe"));
                c.add(aux);
            }
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
        
        return c;
    }
    
    public ArrayList<Modelo> SELECT_ALL_MODELO_VEICULO(){
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT c.*, m.* FROM tb_modelo AS m\n" +
"INNER JOIN tb_classe c ON c.id_classe = m.tb_classe_id_classe\n" +
"WHERE c.bo_tipo_classe = TRUE\n" +
"ORDER BY m.de_modelo");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo aux = new Modelo();
                Classe aux2 = new Classe();
                aux2.setId(rs.getInt("id_classe"));
                aux2.setNome(rs.getString("no_classe"));
                aux2.setTipo(rs.getBoolean("bo_tipo_classe"));
                
                aux.setClasse(aux2);
                aux.setId(rs.getInt("id_modelo"));
                aux.setModelo(rs.getString("de_modelo"));
                aux.setMarca(rs.getString("de_marca_modelo"));
                aux.setLayout(rs.getString("de_layout_modelo"));
                
                m.add(aux);
            }
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }    
        return m;
    }    
    
    public boolean INSERT_MODELO(Modelo model){
        boolean retorno = true;
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO tb_modelo VALUES (DEFAULT, ?, ?, ?, ?);");
            
            comando.setInt(1, model.getClasse().getId());
            comando.setString(2, model.getModelo());
            comando.setString(3,model.getMarca());
            comando.setString(4, model.getLayout());
            
            retorno = comando.execute();
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
            retorno =false;
        }       
        return retorno;
    }
    
    public ArrayList<Cor> SELECT_ALL_COR(){
            ArrayList<Cor> cor = new ArrayList<Cor>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM tb_cor ORDER BY de_cor;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Cor aux = new Cor();
                
                aux.setId(rs.getInt("id_cor"));
                aux.setCor(rs.getString("de_cor"));
                
                cor.add(aux);
            }
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }     
        return cor;
    }
    
    
    
    /*public void SELECT_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
    }
    
    public void DELETE_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
    }
    
    public void UPDATE_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
    }
    
    public void INSERT_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
    }*/
    
}
