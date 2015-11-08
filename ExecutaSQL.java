/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

import heimdall.Util.Classe;
import heimdall.Util.Usuario;
import heimdall.Util.Cor;
import heimdall.Util.Veiculo;
import heimdall.Util.Modelo;
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
    
    // Operações tb_usuario
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
    
    public void UPDATE_USUARIO(String cond, Usuario user){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");    
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }        
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
    
    // Operações tb_classe
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
    
    // Operações tb_modelo
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
    
    // Operações tb_veiculo
    public ArrayList<Veiculo> SELECT_ALL_VEICULO(){
        ArrayList<Veiculo> v = new ArrayList<Veiculo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT v.*, m.*, c.*" +
                    "FROM tb_veiculo AS v\n" +
                    "INNER JOIN tb_modelo AS m ON (m.id_modelo = v.tb_modelo_id_modelo)\n" +
                    "INNER JOIN tb_cor AS c ON (c.id_cor = v.tb_cor_id_cor)\n" +
                    "ORDER BY v.dh_veiculo;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                Modelo modelo = new Modelo();
                Cor cor = new Cor();
                
                cor.setId(rs.getInt("id_cor"));
                cor.setCor(rs.getString("de_cor"));
                
                modelo.setId(rs.getInt("id_modelo"));
                modelo.setModelo(rs.getString("de_modelo"));
                modelo.setMarca(rs.getString("de_marca_modelo"));
                modelo.setLayout(rs.getString("de_layout_modelo"));
                
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setId(rs.getInt("id_veiculo"));
                veiculo.setNome(rs.getString("no_veiculo"));
                veiculo.setRfid(rs.getString("vc_rfid_veiculo"));
                veiculo.setPlaca(rs.getString("vc_placa_veiculo"));
                veiculo.setKm(rs.getFloat("nu_km_veiculo"));
                veiculo.setObservacao(rs.getString("ds_obs_veiculo"));
                veiculo.setDataHora(rs.getString("dh_veiculo"));
                
                v.add(veiculo);
            }
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex.getMessage());
        }    
        return v;
    }    
    
    // Operações tb_cor
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
