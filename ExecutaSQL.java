/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

import heimdall.forms.JErro;
import heimdall.util.Classe;
import heimdall.util.Usuario;
import heimdall.util.Cor;
import heimdall.util.Componente;
import heimdall.util.ComponenteRevisao;
import heimdall.util.Veiculo;
import heimdall.util.Modelo;
import heimdall.util.Revisao;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class ExecutaSQL {
    private PreparedStatement comando;
    private ConexaoDB conexao;
    private TratarEntrada trata;
    private final String chavePrimaria = "NEXTVAL('SEQ_CHAVE_PRIMARIA')";
    private final String codigoregistro = "NEXTVAL('SEQ_CODIGO_REGISTRO')";

    public ExecutaSQL() {
        conexao = new ConexaoDB();
        trata = new TratarEntrada();
    }   
    
    public void BEGIN(){
        try{
            comando = conexao.getConexao().prepareStatement("BEGIN;");      
            
            comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
    }
    
    public void COMMIT(){
        try{
            comando = conexao.getConexao().prepareStatement("COMMIT;");      
            
            comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
    }
    
    public void ROLLBACK(){
        try{
            comando = conexao.getConexao().prepareStatement("ROLLBACK;");      
            
            comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
    }
    
    // Funções
    public Timestamp ConvertStringTimestamp(String dataHora){
        dataHora = trata.noSQLInjection(dataHora);
        Timestamp convertido = new Timestamp(0);
        try{
            comando = conexao.getConexao().prepareStatement("SELECT CAST(? AS TIMESTAMP);");            
            comando.setString(1, dataHora);
            
            ResultSet rs = comando.executeQuery();
            while(rs.next()){
                convertido = rs.getTimestamp(1);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
                
        return convertido;
    }
    
    // Operações usuario
    public ArrayList<Usuario> SELECT_USUARIO(String camp, String val){
        if(camp.compareTo("")==0 || val.compareTo("")==0 || camp==null || val==null)
            return new ArrayList<Usuario>();
        
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM usuario WHERE "+camp+" = "+val+" ORDER BY vc_nome_usuario;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Usuario user = new Usuario( 
                rs.getInt("id_usuario"),
                rs.getString("vc_nome_usuario"),
                rs.getString("vc_senha_usuario"),
                rs.getInt("nu_nivel_usuario"),
                rs.getString("vc_login_usuario"),
                rs.getString("vc_cpf_usuario"),
                rs.getBoolean("bo_primeiro_login_usuario"),
                rs.getBoolean("bo_registro_ativo_usuario"),
                rs.getBoolean("bo_revisa_sem_agendamento") );
                
                usuario.add(user);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return usuario;
    }
    
    public ArrayList<Usuario> SELECT_ALL_USUARIO(){        
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM usuario ORDER BY vc_nome_usuario;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Usuario user = new Usuario( 
                rs.getInt("id_usuario"),
                rs.getString("vc_nome_usuario"),
                rs.getString("vc_senha_usuario"),
                rs.getInt("nu_nivel_usuario"),
                rs.getString("vc_login_usuario"),
                rs.getString("vc_cpf_usuario"),
                rs.getBoolean("bo_primeiro_login_usuario"),
                rs.getBoolean("bo_registro_ativo_usuario"),
                rs.getBoolean("bo_revisa_sem_agendamento") );
                
                usuario.add(user);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return usuario;
    }
    
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
                Usuario user = new Usuario( 
                rs.getInt("id_usuario"),
                rs.getString("vc_nome_usuario"),
                rs.getString("vc_senha_usuario"),
                rs.getInt("nu_nivel_usuario"),
                rs.getString("vc_login_usuario"),
                rs.getString("vc_cpf_usuario"),
                rs.getBoolean("bo_primeiro_login_usuario"),
                rs.getBoolean("bo_registro_ativo_usuario"),
                rs.getBoolean("bo_revisa_sem_agendamento") );
                
                usuario.add(user);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return usuario;
    }
    
    public ArrayList<Usuario> SELECT_BUSCA_USUARIO(String val){
        val = trata.noSQLInjection(val);
        
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM usuario "
                    + "WHERE vc_nome_usuario ILIKE '%"+val+"%' "
                    + "OR vc_login_usuario ILIKE '%"+val+"%'"
                    + "OR vc_cpf_usuario ILIKE '%"+val+"%'"
                    + "AND bo_registro_ativo_usuario = TRUE");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Usuario user = new Usuario( 
                rs.getInt("id_usuario"),
                rs.getString("vc_nome_usuario"),
                rs.getString("vc_senha_usuario"),
                rs.getInt("nu_nivel_usuario"),
                rs.getString("vc_login_usuario"),
                rs.getString("vc_cpf_usuario"),
                rs.getBoolean("bo_primeiro_login_usuario"),
                rs.getBoolean("bo_registro_ativo_usuario"),
                rs.getBoolean("bo_revisa_sem_agendamento") );
                
                usuario.add(user);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return usuario;
    }
    
    public boolean INSERT_USUARIO(Usuario user){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO usuario VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?, ?, ?);");
            
            comando.setString(1, user.getSenha());
            comando.setString(2, user.getNome());
            comando.setInt(3,user.getNivel());
            comando.setString(4, user.getLogin());
            comando.setString(5, user.getCpf());
            comando.setBoolean(6, user.isPrimeiroLogin());
            comando.setBoolean(7, user.isAtivo());
            comando.setBoolean(8, user.isRevisaSemAgendamento());
            
            return !comando.execute();  
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }        
        return false;
    }
    
    public boolean UPDATE_USUARIO(Usuario user){
        try{
            comando = conexao.getConexao().prepareStatement("UPDATE usuario\n" +
                "   SET id_usuario=?, vc_senha_usuario=?, vc_nome_usuario=?, nu_nivel_usuario=?, \n" +
                "       vc_login_usuario=?, vc_cpf_usuario=?, bo_primeiro_login_usuario=?, \n" +
                "       bo_registro_ativo_usuario=?, bo_revisa_sem_agendamento=?"+
                " WHERE id_usuario=?");
            
            comando.setInt(1, user.getId());
            comando.setString(2, user.getSenha());
            comando.setString(3, user.getNome());
            comando.setInt(4,user.getNivel());
            comando.setString(5, user.getLogin());
            comando.setString(6, user.getCpf());
            comando.setBoolean(7, user.isPrimeiroLogin());
            comando.setBoolean(8, user.isAtivo());
            comando.setBoolean(9, user.isRevisaSemAgendamento());
            comando.setInt(10, user.getId());
            
            return !comando.execute();  
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }        
        return false;
    }
    
    public boolean DELETE_USUARIO(int id){
        try{
            comando = conexao.getConexao().prepareStatement("DELETE FROM usuario WHERE id_usuario=?;");
            
            comando.setInt(1, id);
            
            return !comando.execute(); 
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        return false;
    }
    
    // Operações da classe
    public ArrayList SELECT_CLASSE_TIPO(int busca){
        ArrayList<Classe> c = new ArrayList<Classe>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM classe WHERE nu_tipo_classe = "+busca+" ORDER BY vc_nome_classe;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Classe aux = new Classe(rs.getInt("id_classe"),
                rs.getString("vc_nome_classe"),
                rs.getInt("nu_tipo_classe") 
                );
                
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
                Classe aux = new Classe(rs.getInt("id_classe"),
                rs.getString("vc_nome_classe"),
                rs.getInt("nu_tipo_classe") );
                
                c.add(aux);
            }
             
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }        
        
        return c;
    }
    
    // Operações modelo
    public ArrayList<Modelo> SELECT_ALL_MODELO(){
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM modelo ORDER BY nu_codigo_modelo;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Classe classe = (Classe) SELECT_CLASSE("id_classe", Integer.toString(rs.getInt("id_classe"))).get(0);
                
                Modelo modelo = new Modelo(rs.getInt("id_modelo"),
                rs.getInt("nu_codigo_modelo"),
                classe,
                rs.getString("tx_descricao_modelo"),
                rs.getString("vc_marca_modelo"),
                rs.getString("vc_layout_modelo") );
                
                m.add(modelo);
            } 
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }    
        return m;
    }    
    
    public ArrayList<Modelo> SELECT_MODELO_TIPO_CLASSE(int tipo){
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT c.*, m.* FROM modelo AS m\n" +
                                    "INNER JOIN classe c ON (c.id_classe = m.id_classe)\n" +
                                    "WHERE c.nu_tipo_classe = "+tipo+"\n" +
                                    "ORDER BY c.vc_nome_classe,\n" +
                                    "m.vc_marca_modelo,\n" +
                                    "m.tx_descricao_modelo;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Classe classe = new Classe(rs.getInt("id_classe"),
                rs.getString("vc_nome_classe"),
                rs.getInt("nu_tipo_classe") );
                
                Modelo modelo = new Modelo(rs.getInt("id_modelo"),
                rs.getInt("nu_codigo_modelo"),
                classe,
                rs.getString("tx_descricao_modelo"),
                rs.getString("vc_marca_modelo"),
                rs.getString("vc_layout_modelo") );
                
                m.add(modelo);
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
                Classe classe = (Classe) SELECT_CLASSE("id_classe", ""+rs.getInt("id_classe")).get(0);
                
                Modelo modelo = new Modelo(rs.getInt("id_modelo"),
                rs.getInt("nu_codigo_modelo"),
                classe,
                rs.getString("tx_descricao_modelo"),
                rs.getString("vc_marca_modelo"),
                rs.getString("vc_layout_modelo") );
                
                m.add(modelo);
            } 
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }    
        return m;
    }    
    
    public boolean INSERT_MODELO(Modelo model){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO modelo(id_modelo, id_classe, nu_codigo_modelo, tx_descricao_modelo, vc_marca_modelo, vc_layout_modelo)\n" +
                                    "    VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?);");
            
            comando.setInt(1, model.getClasse().getId());
            comando.setInt(2,model.getCodigo());
            comando.setString(3, model.getModelo());
            comando.setString(4,model.getMarca());
            comando.setString(5, model.getLayout());
            
            return !comando.execute();
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
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", Integer.toString(rs.getInt("id_modelo"))).get(0);
                Cor cor = (SELECT_COR("id_cor", Integer.toString(rs.getInt("id_cor"))).size()>0) ? (Cor) SELECT_COR("id_cor", Integer.toString(rs.getInt("id_cor"))).get(0) : null;
                
                Veiculo veiculo = new Veiculo(
                    rs.getInt("id_veiculo"),
                    modelo,
                    cor,
                    rs.getInt("nu_codigo_veiculo"),
                    rs.getString("vc_nome_veiculo"),
                    rs.getString("vc_rfid_veiculo"),
                    rs.getString("vc_placa_veiculo"),
                    rs.getFloat("nu_km_veiculo"),
                    rs.getString("tx_observacao_veiculo"),
                    rs.getTimestamp("dh_registro_veiculo"),
                    rs.getBoolean("bo_registro_ativo_veiculo")
                );
                
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
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", Integer.toString(rs.getInt("id_modelo"))).get(0);
                Cor cor = (SELECT_COR("id_cor", Integer.toString(rs.getInt("id_cor"))).size()>0) ? (Cor) SELECT_COR("id_cor", Integer.toString(rs.getInt("id_cor"))).get(0) : null;
                
                Veiculo veiculo = new Veiculo(
                    rs.getInt("id_veiculo"),
                    modelo,
                    cor,
                    rs.getInt("nu_codigo_veiculo"),
                    rs.getString("vc_nome_veiculo"),
                    rs.getString("vc_rfid_veiculo"),
                    rs.getString("vc_placa_veiculo"),
                    rs.getFloat("nu_km_veiculo"),
                    rs.getString("tx_observacao_veiculo"),
                    rs.getTimestamp("dh_registro_veiculo"),
                    rs.getBoolean("bo_registro_ativo_veiculo")
                );
                
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
                    "            id_veiculo, id_modelo, id_cor, nu_codigo_veiculo, \n" +
                    "            vc_nome_veiculo, vc_rfid_veiculo, vc_placa_veiculo, nu_km_veiculo, \n" +
                    "            tx_observacao_veiculo, dh_registro_veiculo, bo_registro_ativo_veiculo)\n" +
                    "    VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            comando.setInt(1, veiculo.getModelo().getId());
            if(veiculo.getCor() != null)
                comando.setInt(2, veiculo.getCor().getId());
            else
                comando.setNull(2, 0);
            comando.setInt(3, veiculo.getCodigo());
            comando.setString(4,veiculo.getNome());
            comando.setString(5, veiculo.getRfid());
            comando.setString(6, veiculo.getPlaca());
            comando.setFloat(7, veiculo.getKm());
            comando.setString(8, veiculo.getObservacao());
            comando.setTimestamp(9, veiculo.getRegistro());
            comando.setBoolean(10, veiculo.isAtivo());
            
            return !comando.execute();
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
    public ArrayList<Componente> SELECT_ALL_COMPONENTE(){
        
        ArrayList<Componente> componente = new ArrayList<Componente>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM componente ORDER BY nu_codigo_componente;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("id_modelo")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("id_veiculo")).get(0);
                
                Componente comp = new Componente(                                
                    rs.getInt("id_componente"),
                    modelo,
                    veiculo,
                    rs.getInt("nu_codigo_componente"),
                    rs.getString("vc_rfid_componente"),
                    rs.getString("vc_nome_componente"),
                    rs.getString("tx_descricao_componente"),
                    rs.getTimestamp("dh_validade_componente"),
                    rs.getTimestamp("dh_registro_componente"),
                    rs.getBoolean("bo_registro_ativo_componente")
                );
                
                componente.add(comp);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return componente;
    }
    
    public ArrayList<Componente> SELECT_COMPONENTE(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Componente> componente = new ArrayList<Componente>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM componente WHERE "+camp+" = "+val+";");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("id_modelo")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("id_veiculo")).get(0);
                
                Componente comp = new Componente(                                
                    rs.getInt("id_componente"),
                    modelo,
                    veiculo,
                    rs.getInt("nu_codigo_componente"),
                    rs.getString("vc_rfid_componente"),
                    rs.getString("vc_nome_componente"),
                    rs.getString("tx_descricao_componente"),
                    rs.getTimestamp("dh_validade_componente"),
                    rs.getTimestamp("dh_registro_componente"),
                    rs.getBoolean("bo_registro_ativo_componente")
                );
                
                componente.add(comp);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return componente;
    }
    
    public Componente SELECT_COMPONENTE_VEICULO_RFID(String rfidComponente, int idVeiculo){
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM componente WHERE vc_rfid_componente = ?, id_veiculo = ?;");
            
            comando.setString(1,rfidComponente);
            comando.setInt(2, idVeiculo);
            
            ResultSet rs = comando.executeQuery();
            while(rs.next()){
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("id_modelo")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", Integer.toString(idVeiculo)).get(0);
                
                return new Componente(
                        rs.getInt("id_componente"), 
                        modelo, 
                        veiculo, 
                        rs.getInt("nu_codigo_componente"), 
                        rs.getString("vc_rfid_componente"),
                        rs.getString("vc_nome_componente"), 
                        rs.getString("tx_descricao_componente"), 
                        rs.getTimestamp("dh_validade_componente"), 
                        rs.getTimestamp("dh_registro_componente"), 
                        rs.getBoolean("bo_registro_ativo_componente")
                );
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return null;
    }
    
    public boolean INSERT_COMPONENTE(Componente componente){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO componente(\n" +
                            "            id_componente, id_modelo, id_veiculo, nu_codigo_componente, \n" +
                            "            vc_rfid_componente, vc_nome_componente, tx_descricao_componente, \n" +
                            "            dh_validade_componente, dh_registro_componente, bo_registro_ativo_componente)\n" +
                            "    VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            comando.setInt(1, componente.getModelo().getId());
            comando.setInt(2, componente.getVeiculo().getId());
            comando.setInt(3, componente.getCodigo());
            comando.setString(4,componente.getRfid());
            comando.setString(5, componente.getNome());
            comando.setString(6, componente.getDescricao());
            comando.setTimestamp(7, componente.getValidade());
            comando.setTimestamp(8, componente.getRegistro());
            comando.setBoolean(9, componente.isAtivo());
            
            return !comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }       
            return false;
    }   
    
    // Operações Revisao
    public ArrayList<Revisao> SELECT_REVISAO(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<Revisao> revisao = new ArrayList<Revisao>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM revisao WHERE "+camp+" = "+val+";");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Usuario usuarioRevisao = (Usuario) SELECT_USUARIO_ATIVO("id_usuario", ""+rs.getInt("id_usuario")).get(0);
                Usuario usuarioAutorizador = (Usuario) SELECT_USUARIO_ATIVO("id_usuario", ""+rs.getInt("id_usuario_autorizador")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("id_veiculo")).get(0);
                
                Revisao rev = new Revisao(
                        rs.getInt("id_revisao"), 
                        usuarioRevisao, 
                        veiculo, 
                        rs.getInt("nu_numero_revisao"),
                        rs.getTimestamp("dh_execucao_revisao"), 
                        rs.getString("tx_descricao_revisao"),
                        usuarioAutorizador,
                        rs.getBoolean("bo_executada")
                );
                
                revisao.add(rev);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return revisao;
    }
    
    public boolean SELECT_VERIFICA_REVISAO_COMPLETA(int idRevisao){ 
        try{
            comando = conexao.getConexao().prepareStatement("SELECT NOT EXISTS(SELECT 1 FROM componente_revisao "
                                + "WHERE id_revisao = ? AND bo_identificado = false) AS completa;");
            comando.setInt(1, idRevisao);
            
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                return rs.getBoolean("completa");
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return false;
    }
    
    public ArrayList<Revisao> SELECT_REVISAO_CONSULTA(int idVeiculo, Timestamp dataInicial, Timestamp dataFinal){        
        ArrayList<Revisao> revisao = new ArrayList<Revisao>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM revisao "
                            + "WHERE id_veiculo = ? "
                            + "AND dh_execucao_revisao BETWEEN ? AND ?;");
            comando.setInt(1, idVeiculo);
            comando.setTimestamp(2, dataInicial);
            comando.setTimestamp(3, dataFinal);
            
            ResultSet rs = comando.executeQuery();            
            while(rs.next()){
                Usuario usuarioRevisao = (Usuario) SELECT_USUARIO_ATIVO("id_usuario", ""+rs.getInt("id_usuario")).get(0);
                Usuario usuarioAutorizador = (Usuario) SELECT_USUARIO_ATIVO("id_usuario", ""+rs.getInt("id_usuario_autorizador")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("id_veiculo")).get(0);
                
                Revisao rev = new Revisao(
                        rs.getInt("id_revisao"), 
                        usuarioRevisao, 
                        veiculo, 
                        rs.getInt("nu_numero_revisao"),
                        rs.getTimestamp("dh_execucao_revisao"), 
                        rs.getString("tx_descricao_revisao"),
                        usuarioAutorizador,
                        rs.getBoolean("bo_executada")
                );
                
                revisao.add(rev);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return revisao;
    }
    
    public int INSERT_REVISAO(Revisao revisao){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO revisao(\n" +
                    "            id_revisao, id_veiculo, id_usuario, nu_numero_revisao, dh_execucao_revisao, \n" +
                    "            tx_descricao_revisao, id_usuario_autorizador, bo_executada)" +
                    "    VALUES ("+chavePrimaria+", ?, ?, NEXTVAL('SEQ_NUMERO_REVISAO'), ?, ?, ?, ?) RETURNING id_revisao;");
            
            comando.setInt(1, revisao.getVeiculo().getId());
            comando.setInt(2, revisao.getUsuarioRevisao().getId());
            comando.setTimestamp(3, revisao.getRegistro());
            comando.setString(4, revisao.getDescricao());
            comando.setInt(5, revisao.getUsuarioAutorizador().getId());
            comando.setBoolean(6, revisao.isExecutada());
            
            ResultSet rs = comando.executeQuery();
            
            if(rs.next())
                return rs.getInt("id_revisao");
            
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }    
        
        return 0;
    }   
    
    // Operações Revisao
    public ArrayList<ComponenteRevisao> SELECT_COMPONENTE_REVISAO(String camp, String val){
        camp = trata.noSQLInjection(camp);
        val = trata.noSQLInjection(val);
        
        ArrayList<ComponenteRevisao> componenteRevisao = new ArrayList<ComponenteRevisao>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM componente_revisao "
                            + "WHERE "+camp+" = "+val+" ORDER BY dh_identificacao_componente_revisao;");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Componente componente = (Componente) SELECT_COMPONENTE("id_componente", Integer.toString(rs.getInt("id_componente"))).get(0);
                Revisao revisao = (Revisao) SELECT_REVISAO("id_revisao", Integer.toString(rs.getInt("id_revisao"))).get(0);
                
                ComponenteRevisao rev = new ComponenteRevisao(
                        componente,
                        revisao,
                        rs.getBoolean("bo_identificado"),
                        rs.getTimestamp("dh_identificacao_componente_revisao"),
                        rs.getString("tx_motivo_nao_identificacao")
                );
                
                componenteRevisao.add(rev);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return componenteRevisao;
    }
    
    public boolean INSERT_COMPONENTE_REVISAO(ComponenteRevisao componenteRevisao){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO componente_revisao(\n" +
                        "            id_componente, id_revisao, bo_identificado, dh_identificacao_componente_revisao, \n" +
                        "            tx_motivo_nao_identificacao)\n" +
                            "    VALUES (?, ?, ?, ?, ?);");
            
            comando.setInt(1, componenteRevisao.getComponente().getId());
            comando.setInt(2, componenteRevisao.getRevisao().getId());
            comando.setBoolean(3, componenteRevisao.isIdentificado());
            comando.setTimestamp(4,componenteRevisao.getIdentificacao());
            comando.setString(5, componenteRevisao.getMotivo());
            
            return !comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
            return false;
        }       
    }   
    
    // Operações de Log
    public boolean REGISTRAR_LOG(int idUsuario, String acao, Timestamp dataHoraLog){
        acao = trata.noSQLInjection(acao);
        
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO log_usuario(\n" +
                        "            id_log, id_usuario, dh_registro_log, tx_acao_log)\n" +
                        "    VALUES ("+chavePrimaria+", ?, ?, ?);");
            
           String idEncriptada = encriptaLog(Integer.toString(idUsuario));
           acao = encriptaLog(acao);
            
            comando.setString(1, idEncriptada);
            comando.setTimestamp(2,dataHoraLog);
            comando.setString(3, acao);
            
            return !comando.execute();
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
            return false;
        }       
    }   
    
    private String encriptaLog(String valor){
        EncriptaDecriptaAES AES = new EncriptaDecriptaAES();
        SenhaAutomatica crypt = new SenhaAutomatica(0);
        try {
            valor = crypt.base64Encoder(AES.encriptaAES(valor.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException ex) {
            new JErro(true, ex, true, true, false);
        }
        return valor;
    }
    
    /*public void DELETE_USUARIO(){
        try{
            
            System.out.println("Executou a SQL");
    conexao.getConexao().close();    
            System.out.println("Fechou o banco");  
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }        
    }*/
}
