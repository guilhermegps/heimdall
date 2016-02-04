/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

import heimdall.Forms.JErro;
import heimdall.Util.Classe;
import heimdall.Util.Usuario;
import heimdall.Util.Cor;
import heimdall.Util.Componente;
import heimdall.Util.Veiculo;
import heimdall.Util.Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author guilherme
 */
public class ExecutaSQL {
    private PreparedStatement comando;
    private ConexaoDB conexao;
    private TratarEntrada trata;

    public ExecutaSQL() {
        conexao = new ConexaoDB();
    }    
    
    // Operações tb_usuario
    public Usuario SELECT_USUARIO_ATIVOS(String camp, String val){
        Usuario user = null;
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM usuario WHERE "+camp+" = "+val+" AND bo_registro_ativo_usuario = TRUE");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                user.setNome(rs.getString("vc_nome_usuario"));
                user.setSenha(rs.getString("vc_senha_usuario"));
                user.setNivel(rs.getInt("in_nivel_usuario"));
                user.setLogin(rs.getString("vc_login_usuario"));
                user.setCpf(rs.getString("vc_cpf_usuario"));
                user.setAtivo(rs.getBoolean("bo_registro_ativo_usuario"));
            }       
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }
        
        return user;
    }
    
    public boolean INSERT_USUARIO(Usuario user){
        boolean retorno = true;
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO usuario VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), ?, ?, ?, ?, ?, ?);");
            
            comando.setString(1, user.getSenha());
            comando.setString(2, user.getNome());
            comando.setInt(3,user.getNivel());
            comando.setString(4, user.getLogin());
            comando.setString(5, user.getCpf());
            comando.setBoolean(6, user.isAtivo());
            
            retorno = comando.execute();  
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
        return retorno;
    }
    
    public void UPDATE_USUARIO(String cond, Usuario user){
        try{
               
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
    }
    
    public void DELETE_USUARIO(String cnd){
        try{
             
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }
        
    }
    
    // Operações da classe
    public ArrayList SELECT_CLASSE_TIPO(boolean busca){
        ArrayList<Classe> c = new ArrayList<Classe>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM classe WHERE bo_tipo_classe = "+busca+" ORDER BY vc_nome_classe;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Classe aux = new Classe();
                aux.setId(rs.getInt("id_classe"));
                aux.setNome(rs.getString("vc_nome_classe"));
                aux.setTipo(rs.getBoolean("bo_tipo_classe"));
                c.add(aux);
            }
             
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
        
        return c;
    }
    
    public ArrayList SELECT_CLASSE(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Classe> c = new ArrayList<Classe>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM classe WHERE "+camp+" = "+val+" ORDER BY vc_nome_classe;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Classe aux = new Classe();
                aux.setId(rs.getInt("id_classe"));
                aux.setNome(rs.getString("vc_nome_classe"));
                aux.setTipo(rs.getBoolean("bo_tipo_classe"));
                c.add(aux);
            }
             
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
        
        return c;
    }
    
    // Operações tb_modelo
    public ArrayList<Modelo> SELECT_ALL_MODELO_VEICULO(){
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT c.*, m.* FROM modelo AS m\n" +
"INNER JOIN classe c ON (c.id_classe = m.classe_id_classe)\n" +
"WHERE c.bo_tipo_classe = TRUE\n" +
"ORDER BY m.vc_descricao_modelo");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo aux = new Modelo();
                Classe aux2 = new Classe();
                aux2.setId(rs.getInt("id_classe"));
                aux2.setNome(rs.getString("vc_nome_classe"));
                aux2.setTipo(rs.getBoolean("bo_tipo_classe"));
                
                aux.setClasse(aux2);
                aux.setId(rs.getInt("id_modelo"));
                aux.setModelo(rs.getString("vc_descricao_modelo"));
                aux.setMarca(rs.getString("vc_marca_modelo"));
                aux.setLayout(rs.getString("vc_layout_modelo"));
                
                m.add(aux);
            } 
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }    
        return m;
    }    
    
    public ArrayList<Modelo> SELECT_ALL_MODELO_COMPONENTE(){
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT c.*, m.* FROM modelo AS m\n" +
"INNER JOIN classe c ON (c.id_classe = m.classe_id_classe)\n" +
"WHERE c.bo_tipo_classe = FALSE\n" +
"ORDER BY m.vc_descricao_modelo");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo aux = new Modelo();
                Classe aux2 = new Classe();
                aux2.setId(rs.getInt("id_classe"));
                aux2.setNome(rs.getString("vc_nome_classe"));
                aux2.setTipo(rs.getBoolean("bo_tipo_classe"));
                
                aux.setClasse(aux2);
                aux.setId(rs.getInt("id_modelo"));
                aux.setModelo(rs.getString("vc_descricao_modelo"));
                aux.setMarca(rs.getString("vc_marca_modelo"));
                aux.setLayout(rs.getString("vc_layout_modelo"));
                
                m.add(aux);
            } 
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }    
        return m;
    }    
    
    public ArrayList<Modelo> SELECT_MODELO(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM modelo WHERE "+camp+" = "+val+";");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo model = new Modelo();
                Classe classe = (Classe) SELECT_CLASSE("id_classe", ""+rs.getInt("classe_id_classe")).get(0);
                
                model.setClasse(classe);
                model.setId(rs.getInt("id_modelo"));
                model.setModelo(rs.getString("vc_descricao_modelo"));
                model.setMarca(rs.getString("vc_marca_modelo"));
                model.setLayout(rs.getString("vc_layout_modelo"));
                
                m.add(model);
            } 
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }    
        return m;
    }    
    
    public boolean INSERT_MODELO(Modelo model){
        boolean retorno = true;
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO modelo VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), ?, ?, ?, ?);");
            
            comando.setInt(1, model.getClasse().getId());
            comando.setString(2, model.getModelo());
            comando.setString(3,model.getMarca());
            comando.setString(4, model.getLayout());
            
            retorno = comando.execute();
            
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
            retorno =false;
        }       
        return retorno;
    }
    
    // Operações tb_veiculo
    public ArrayList<Veiculo> SELECT_ALL_VEICULO(){
        ArrayList<Veiculo> v = new ArrayList<Veiculo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT v.*, m.*, c.*" +
                    "FROM veiculo AS v\n" +
                    "INNER JOIN modelo AS m ON (m.id_modelo = v.modelo_id_modelo)\n" +
                    "INNER JOIN cor AS c ON (c.id_cor = v.cor_id_cor)\n" +
                    "ORDER BY v.dh_registro_veiculo;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                Modelo modelo = new Modelo();
                Cor cor = new Cor();
                
                cor.setId(rs.getInt("id_cor"));
                cor.setCor(rs.getString("vc_nome_cor"));
                
                modelo.setId(rs.getInt("id_modelo"));
                modelo.setModelo(rs.getString("vc_descricao_modelo"));
                modelo.setMarca(rs.getString("vc_marca_modelo"));
                modelo.setLayout(rs.getString("vc_layout_modelo"));
                
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setId(rs.getInt("id_veiculo"));
                veiculo.setNome(rs.getString("vc_nome_veiculo"));
                veiculo.setRfid(rs.getString("vc_rfid_veiculo"));
                veiculo.setPlaca(rs.getString("vc_placa_veiculo"));
                veiculo.setKm(rs.getFloat("nu_km_veiculo"));
                veiculo.setObservacao(rs.getString("tx_observacao_veiculo"));
                veiculo.setDataHora(rs.getString("dh_registro_veiculo"));
                
                v.add(veiculo);
            }
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }    
        return v;
    }    
    
    public ArrayList<Veiculo> SELECT_VEICULO(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Veiculo> v = new ArrayList<Veiculo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM veiculo WHERE "+camp+" = "+val+" ORDER BY dh_registro_veiculo;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("modelo_id_modelo")).get(0);
                Cor cor = (Cor) SELECT_COR("id_cor", ""+rs.getInt("cor_id_cor")).get(0);
                Veiculo veiculo = new Veiculo();
                
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setId(rs.getInt("id_veiculo"));
                veiculo.setNome(rs.getString("vc_nome_veiculo"));
                veiculo.setRfid(rs.getString("vc_rfid_veiculo"));
                veiculo.setPlaca(rs.getString("vc_placa_veiculo"));
                veiculo.setKm(rs.getFloat("nu_km_veiculo"));
                veiculo.setObservacao(rs.getString("tx_observacao_veiculo"));
                veiculo.setDataHora(rs.getString("dh_registro_veiculo"));
                
                v.add(veiculo);
            }
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }    
        return v;
    }    
    
    // Operações tb_cor
    public ArrayList<Cor> SELECT_ALL_COR(){
            ArrayList<Cor> cor = new ArrayList<Cor>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM cor ORDER BY vc_nome_cor;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Cor aux = new Cor();
                
                aux.setId(rs.getInt("id_cor"));
                aux.setCor(rs.getString("vc_nome_cor"));
                
                cor.add(aux);
            }
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }     
        return cor;
    }
    
    public ArrayList<Cor> SELECT_COR(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
            ArrayList<Cor> cor = new ArrayList<Cor>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM cor WHERE "+camp+" = "+val+" ORDER BY vc_nome_cor;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Cor aux = new Cor();
                
                aux.setId(rs.getInt("id_cor"));
                aux.setCor(rs.getString("vc_nome_cor"));
                
                cor.add(aux);
            }
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }     
        return cor;
    }
    
    // Operações componente
    public ArrayList<Componente> SELECT_COMPONENTE(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Componente> componente = new ArrayList<Componente>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM componente WHERE "+camp+" = "+val+";");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("modelo_id_modelo")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("veiculo_id_veiculo")).get(0);
                Componente comp = new Componente();
                                
                comp.setId(rs.getInt("id_componente"));
                //comp.setCodigo(rs.getString(""));
                comp.setNome(rs.getString("vc_nome_componente"));
                comp.setRfid(rs.getString("vc_rfid_componente"));
                comp.setDescricao(rs.getString("tx_descricao_componente"));
                comp.setValidade(rs.getDate("dt_validade_componente"));
                comp.setRegistro(rs.getTimestamp("dh_registro_componente"));
            }       
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }
        
        return componente;
    }
    
    
    
    /*public void SELECT_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
    }
    
    public void DELETE_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
    }
    
    public void UPDATE_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
    }
    
    public void INSERT_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
    }*/
}
