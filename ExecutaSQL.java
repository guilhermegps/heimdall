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
import heimdall.Util.ComponenteRevisao;
import heimdall.Util.Veiculo;
import heimdall.Util.Modelo;
import heimdall.Util.Revisao;
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
                rs.getInt("in_nivel_usuario"),
                rs.getString("vc_login_usuario"),
                rs.getString("vc_cpf_usuario"),
                rs.getBoolean("bo_primeiro_login_usuario"),
                rs.getBoolean("bo_registro_ativo_usuario") );
                
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
                rs.getInt("in_nivel_usuario"),
                rs.getString("vc_login_usuario"),
                rs.getString("vc_cpf_usuario"),
                rs.getBoolean("bo_primeiro_login_usuario"),
                rs.getBoolean("bo_registro_ativo_usuario") );
                
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
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                user.setNome(rs.getString("vc_nome_usuario"));
                user.setSenha(rs.getString("vc_senha_usuario"));
                user.setNivel(rs.getInt("in_nivel_usuario"));
                user.setLogin(rs.getString("vc_login_usuario"));
                user.setCpf(rs.getString("vc_cpf_usuario"));
                user.setPrimeiroLogin(rs.getBoolean("bo_primeiro_login_usuario"));
                user.setAtivo(rs.getBoolean("bo_registro_ativo_usuario"));
                
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
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                user.setNome(rs.getString("vc_nome_usuario"));
                user.setSenha(rs.getString("vc_senha_usuario"));
                user.setNivel(rs.getInt("in_nivel_usuario"));
                user.setLogin(rs.getString("vc_login_usuario"));
                user.setCpf(rs.getString("vc_cpf_usuario"));
                user.setPrimeiroLogin(rs.getBoolean("bo_primeiro_login_usuario"));
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
            comando = conexao.getConexao().prepareStatement("INSERT INTO usuario VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?, ?);");
            
            comando.setString(1, user.getSenha());
            comando.setString(2, user.getNome());
            comando.setInt(3,user.getNivel());
            comando.setString(4, user.getLogin());
            comando.setString(5, user.getCpf());
            comando.setBoolean(6, user.isPrimeiroLogin());
            comando.setBoolean(7, user.isAtivo());
            
            return !comando.execute();  
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }        
        return false;
    }
    
    public boolean UPDATE_USUARIO(Usuario user){
        try{
            comando = conexao.getConexao().prepareStatement("UPDATE usuario\n" +
                "   SET id_usuario=?, vc_senha_usuario=?, vc_nome_usuario=?, in_nivel_usuario=?, \n" +
                "       vc_login_usuario=?, vc_cpf_usuario=?, bo_primeiro_login_usuario=?, \n" +
                "       bo_registro_ativo_usuario=?"+
                " WHERE id_usuario=?");
            
            comando.setInt(1, user.getId());
            comando.setString(2, user.getSenha());
            comando.setString(3, user.getNome());
            comando.setInt(4,user.getNivel());
            comando.setString(5, user.getLogin());
            comando.setString(6, user.getCpf());
            comando.setBoolean(7, user.isPrimeiroLogin());
            comando.setBoolean(8, user.isAtivo());
            comando.setInt(9, user.getId());
            
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
    
    // Operações modelo
    public ArrayList<Modelo> SELECT_ALL_MODELO(){
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM modelo ORDER BY vc_descricao_modelo");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo modelo = new Modelo();
                Classe classe = (Classe) SELECT_CLASSE("id_classe", ""+rs.getInt("classe_id_classe")).get(0);
                
                modelo.setId(rs.getInt("id_modelo"));
                modelo.setClasse(classe);
                modelo.setCodigo(rs.getInt("nu_codigo_modelo"));
                modelo.setModelo(rs.getString("vc_descricao_modelo"));
                modelo.setMarca(rs.getString("vc_marca_modelo"));
                modelo.setLayout(rs.getString("vc_layout_modelo"));
                
                m.add(modelo);
            } 
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }    
        return m;
    }    
    
    public ArrayList<Modelo> SELECT_MODELO_TIPO_CLASSE(boolean tipo){
        ArrayList<Modelo> m = new ArrayList<Modelo>();
        try{
            comando = conexao.getConexao().prepareStatement("SELECT c.*, m.* FROM modelo AS m\n" +
                                    "INNER JOIN classe c ON (c.id_classe = m.classe_id_classe)\n" +
                                    "WHERE c.bo_tipo_classe = "+tipo+"\n" +
                                    "ORDER BY c.vc_nome_classe,\n" +
                                    "m.vc_marca_modelo,\n" +
                                    "m.vc_descricao_modelo");
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                Modelo modelo = new Modelo();
                Classe classe = new Classe();
                classe.setId(rs.getInt("id_classe"));
                classe.setNome(rs.getString("vc_nome_classe"));
                classe.setTipo(rs.getBoolean("bo_tipo_classe"));
                
                modelo.setId(rs.getInt("id_modelo"));
                modelo.setClasse(classe);
                modelo.setCodigo(rs.getInt("nu_codigo_modelo"));
                modelo.setModelo(rs.getString("vc_descricao_modelo"));
                modelo.setMarca(rs.getString("vc_marca_modelo"));
                modelo.setLayout(rs.getString("vc_layout_modelo"));
                
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
                Modelo model = new Modelo();
                Classe classe = (Classe) SELECT_CLASSE("id_classe", ""+rs.getInt("classe_id_classe")).get(0);
                
                model.setClasse(classe);
                model.setId(rs.getInt("id_modelo"));
                model.setCodigo(rs.getInt("nu_codigo_modelo"));
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
            comando = conexao.getConexao().prepareStatement("INSERT INTO modelo(id_modelo, classe_id_classe, nu_codigo_modelo, vc_descricao_modelo, vc_marca_modelo, vc_layout_modelo)\n" +
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
                Veiculo veiculo = new Veiculo();
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", Integer.toString(rs.getInt("modelo_id_modelo"))).get(0);
                Cor cor = (SELECT_COR("id_cor", Integer.toString(rs.getInt("cor_id_cor"))).size()>0) ? (Cor) SELECT_COR("id_cor", Integer.toString(rs.getInt("cor_id_cor"))).get(0) : null;
                
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setId(rs.getInt("id_veiculo"));
                veiculo.setCodigo(rs.getInt("nu_codigo_veiculo"));
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
                Cor cor = (SELECT_COR("id_cor", Integer.toString(rs.getInt("cor_id_cor"))).size()>0) ? (Cor) SELECT_COR("id_cor", Integer.toString(rs.getInt("cor_id_cor"))).get(0) : null;
                
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setId(rs.getInt("id_veiculo"));
                veiculo.setCodigo(rs.getInt("nu_codigo_veiculo"));
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
                    "            id_veiculo, modelo_id_modelo, cor_id_cor, nu_codigo_veiculo, \n" +
                    "            vc_nome_veiculo, vc_rfid_veiculo, vc_placa_veiculo, nu_km_veiculo, \n" +
                    "            tx_observacao_veiculo, dh_registro_veiculo)\n" +
                    "    VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
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
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("modelo_id_modelo")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("veiculo_id_veiculo")).get(0);
                Componente comp = new Componente();
                                
                comp.setId(rs.getInt("id_componente"));
                comp.setModelo(modelo);
                comp.setVeiculo(veiculo);
                comp.setCodigo(rs.getInt("nu_codigo_componente"));
                comp.setNome(rs.getString("vc_nome_componente"));
                comp.setRfid(rs.getString("vc_rfid_componente"));
                comp.setDescricao(rs.getString("tx_descricao_componente"));
                comp.setValidade(rs.getTimestamp("dh_validade_componente"));
                comp.setRegistro(rs.getTimestamp("dh_registro_componente"));
                
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
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("modelo_id_modelo")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("veiculo_id_veiculo")).get(0);
                Componente comp = new Componente();
                                
                comp.setId(rs.getInt("id_componente"));
                comp.setModelo(modelo);
                comp.setVeiculo(veiculo);
                comp.setCodigo(rs.getInt("nu_codigo_componente"));
                comp.setNome(rs.getString("vc_nome_componente"));
                comp.setRfid(rs.getString("vc_rfid_componente"));
                comp.setDescricao(rs.getString("tx_descricao_componente"));
                comp.setValidade(rs.getTimestamp("dh_validade_componente"));
                comp.setRegistro(rs.getTimestamp("dh_registro_componente"));
                
                componente.add(comp);
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return componente;
    }
    
    public Componente SELECT_COMPONENTE_VEICULO_RFID(String rfidComponente, int idVeiculo){
        try{
            comando = conexao.getConexao().prepareStatement("SELECT * FROM componente WHERE vc_rfid_componente = ?, veiculo_id_veiculo = ?;");
            
            comando.setString(1,rfidComponente);
            comando.setInt(2, idVeiculo);
            
            ResultSet rs = comando.executeQuery();
            while(rs.next()){
                Modelo modelo = (Modelo) SELECT_MODELO("id_modelo", ""+rs.getInt("modelo_id_modelo")).get(0);
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
                        rs.getTimestamp("dh_registro_componente") );
            }       
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }
        
        return null;
    }
    
    public boolean INSERT_COMPONENTE(Componente componente){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO componente(\n" +
                            "            id_componente, modelo_id_modelo, veiculo_id_veiculo, nu_codigo_componente, \n" +
                            "            vc_rfid_componente, vc_nome_componente, tx_descricao_componente, \n" +
                            "            dh_validade_componente, dh_registro_componente)\n" +
                            "    VALUES ("+chavePrimaria+", ?, ?, ?, ?, ?, ?, ?, ?);");
            
            comando.setInt(1, componente.getModelo().getId());
            comando.setInt(2, componente.getVeiculo().getId());
            comando.setInt(3, componente.getCodigo());
            comando.setString(4,componente.getRfid());
            comando.setString(5, componente.getNome());
            comando.setString(6, componente.getDescricao());
            comando.setTimestamp(7, componente.getValidade());
            comando.setTimestamp(8, componente.getRegistro());
            
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
                Usuario usuario = (Usuario) SELECT_USUARIO_ATIVO("id_usuario", ""+rs.getInt("usuario_id_usuario")).get(0);
                Veiculo veiculo = (Veiculo) SELECT_VEICULO("id_veiculo", ""+rs.getInt("veiculo_id_veiculo")).get(0);
                
                Revisao rev = new Revisao(
                        rs.getInt("id_revisao"), 
                        usuario, 
                        veiculo, 
                        rs.getTimestamp("dh_registro_revisao"), 
                        rs.getString("tx_descricao_revisao") );
                
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
                            "            id_revisao, usuario_id_usuario, veiculo_id_veiculo, dh_registro_revisao, \n" +
                            "            tx_descricao_revisao)\n" +
                            "    VALUES ("+chavePrimaria+", ?, ?, ?, ?) RETURNING id_revisao;");
            
            comando.setInt(1, revisao.getUsuario().getId());
            comando.setInt(2,revisao.getVeiculo().getId());
            comando.setTimestamp(3, revisao.getRegistro());
            comando.setString(4, revisao.getDescricao());
            
            ResultSet rs = comando.executeQuery();
            
            if(rs.next())
                return rs.getInt("id_revisao");
            
        }catch(Exception ex){
            new JErro(true, ex, true, true, false);
        }    
        
        return 0;
    }   
    
    // Operações Revisao
    public boolean INSERT_COMPONENTE_REVISAO(ComponenteRevisao componenteRevisao){
        try{
            comando = conexao.getConexao().prepareStatement("INSERT INTO componente_revisao(\n" +
                            "            componente_id_componente, revisao_id_revisao, bo_identificado, \n" +
                            "            dh_identificacao_componente_revisao, tx_motivo_nao_identificacao)\n" +
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
