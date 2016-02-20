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
    private final String chavePrimaria = "NEXTVAL('SEQ_CHAVE_PRIMARIA')";

    public ExecutaSQL() {
        conexao = new ConexaoDB();
        trata = new TratarEntrada();
    }    
    
    // Operações tb_usuario
    public ArrayList<Usuario> SELECT_USUARIO_ATIVO(String camp, String val){
        if(camp.compareTo("")==0 || val.compareTo("")==0 || camp==null || val==null)
            return new ArrayList<Usuario>();
        
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM usuario WHERE "+camp+" = "+val+" AND bo_registro_ativo_usuario = TRUE");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                user.setNome(rs.getString("vc_nome_usuario"));
                user.setSenha(rs.getString("vc_senha_usuario"));
                user.setNivel(rs.getInt("in_nivel_usuario"));
                user.setLogin(rs.getString("vc_login_usuario"));
                user.setCpf(rs.getString("vc_cpf_usuario"));
                user.setAtivo(rs.getBoolean("bo_registro_ativo_usuario"));
                
                usuario.add(user);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return usuario;
    }
    
    public boolean INSERT_USUARIO(Usuario user){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO usuario VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?);");
            
            comando.setString(1, user.getSenha());
            comando.setString(2, user.getNome());
            comando.setInt(3,user.getNivel());
            comando.setString(4, user.getLogin());
            comando.setString(5, user.getCpf());
            comando.setBoolean(6, user.isAtivo());
            
            return comando.execute();  
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }        
        return false;
    }
    
    public boolean UPDATE_USUARIO(Usuario user){
        try{
            comando = conexao.getConexao().prepareStatement("UPDATE usuario\n" +
                "   SET id_usuario=?, vc_senha_usuario=?, vc_nome_usuario=?, in_nivel_usuario=?, \n" +
                "       vc_login_usuario=?, vc_cpf_usuario=?, bo_registro_ativo_usuario=?\n" +
                " WHERE id_usuario=?");
            
            comando.setInt(1, user.getId());
            comando.setString(2, user.getSenha());
            comando.setString(3, user.getNome());
            comando.setInt(4,user.getNivel());
            comando.setString(5, user.getLogin());
            comando.setString(6, user.getCpf());
            comando.setBoolean(7, user.isAtivo());
            comando.setInt(8, user.getId());
            
            return comando.execute();  
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }        
        return false;
    }
    
    public void DELETE_USUARIO(String cnd){
        try{
             
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
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
            new JErro(true, ex, true, true, false);
        }        
        
        return c;
    }
    
    public ArrayList<Classe> SELECT_CLASSE(String camp, String val){
        if(camp.compareTo("")==0 || val.compareTo("")==0 || camp==null || val==null)
            return new ArrayList<Classe>();
        
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
            new JErro(true, ex, true, true, false);
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
            new JErro(true, ex, true, true, false);
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
            new JErro(true, ex, true, true, false);
        }    
        return m;
    }    
    
    public ArrayList<Modelo> SELECT_MODELO(String camp, String val){
        if(camp.compareTo("")==0 || val.compareTo("")==0 || camp==null || val==null)
            return new ArrayList<Modelo>();
        
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
            new JErro(true, ex, true, true, false);
        }    
        return m;
    }    
    
    public boolean INSERT_MODELO(Modelo model){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO modelo(\n" +
"            id_modelo, classe_id_classe, vc_descricao_modelo, vc_marca_modelo, \n" +
"            vc_layout_modelo) VALUES ("+chavePrimaria+", ?, ?, ?, ?);");
            
            comando.setInt(1, model.getClasse().getId());
            comando.setString(2, model.getModelo());
            comando.setString(3,model.getMarca());
            comando.setString(4, model.getLayout());
            
            return comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }       
        return false;
    }
    
    // Operações tb_veiculo
    public ArrayList<Veiculo> SELECT_ALL_VEICULO(){
        ArrayList<Veiculo> v = new ArrayList<Veiculo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM veiculo ORDER BY dh_registro_veiculo;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", Integer.toString(rs.getInt("modelo_id_modelo"))).get(0);
                Cor cor = (SELECT_COR("id_cor", Integer.toString(rs.getInt("cor_id_cor"))).size()>0) ? (Cor) SELECT_COR("id_cor", Integer.toString(rs.getInt("cor_id_cor"))).get(0) : null;
                
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setId(rs.getInt("id_veiculo"));
                veiculo.setNome(rs.getString("vc_nome_veiculo"));
                veiculo.setRfid(rs.getString("vc_rfid_veiculo"));
                veiculo.setPlaca(rs.getString("vc_placa_veiculo"));
                veiculo.setKm(rs.getFloat("nu_km_veiculo"));
                veiculo.setObservacao(rs.getString("tx_observacao_veiculo"));
                veiculo.setRegistro(rs.getTimestamp("dh_registro_veiculo"));
                
                v.add(veiculo);
            }
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
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
                Veiculo veiculo = new Veiculo();
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", Integer.toString(rs.getInt("modelo_id_modelo"))).get(0);
                Cor cor = (Cor) SELECT_COR("id_cor", Integer.toString(rs.getInt("cor_id_cor"))).get(0);
                
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setId(rs.getInt("id_veiculo"));
                veiculo.setNome(rs.getString("vc_nome_veiculo"));
                veiculo.setRfid(rs.getString("vc_rfid_veiculo"));
                veiculo.setPlaca(rs.getString("vc_placa_veiculo"));
                veiculo.setKm(rs.getFloat("nu_km_veiculo"));
                veiculo.setObservacao(rs.getString("tx_observacao_veiculo"));
                veiculo.setRegistro(rs.getTimestamp("dh_registro_veiculo"));
                
                v.add(veiculo);
            }
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }    
        return v;
    } 
    
    public boolean INSERT_VEICULO(Veiculo veiculo){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO veiculo(\n" +
"            id_veiculo, modelo_id_modelo, cor_id_cor, vc_nome_veiculo, vc_rfid_veiculo, \n" +
"            vc_placa_veiculo, nu_km_veiculo, tx_observacao_veiculo, dh_registro_veiculo)\n" +
"    VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?, ?, ?);");
            
            comando.setInt(1, veiculo.getModelo().getId());
            if(veiculo.getCor() != null)
                comando.setInt(2, veiculo.getCor().getId());
            else
                comando.setNull(2, 0);
            comando.setString(3,veiculo.getNome());
            comando.setString(4, veiculo.getRfid());
            comando.setString(5, veiculo.getPlaca());
            comando.setFloat(6, veiculo.getKm());
            comando.setString(7, veiculo.getObservacao());
            comando.setTimestamp(8, veiculo.getRegistro());
            
            return comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }       
        return false;
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
            new JErro(true, ex, true, true, false);
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
            new JErro(true, ex, true, true, false);
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
            new JErro(true, ex, true, true, false);
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
