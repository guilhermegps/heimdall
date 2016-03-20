CREATE TABLE cor (
  id_cor INTEGER NOT NULL,
  vc_nome_cor VARCHAR(50) NOT NULL,
  PRIMARY KEY(id_cor)
);

CREATE TABLE usuario (
  id_usuario INTEGER NOT NULL,
  vc_senha_usuario VARCHAR(32) NOT NULL,
  vc_nome_usuario VARCHAR(80) NOT NULL,
  in_nivel_usuario INTEGER NOT NULL,
  vc_login_usuario VARCHAR(50) NOT NULL,
  vc_cpf_usuario VARCHAR(11) NOT NULL,
  bo_primeiro_login_usuario BOOLEAN NOT NULL,
  bo_registro_ativo_usuario BOOLEAN NOT NULL,
  PRIMARY KEY(id_usuario)
);

CREATE TABLE classe (
  id_classe INTEGER NOT NULL,
  vc_nome_classe VARCHAR(50) NOT NULL,
  bo_tipo_classe BOOLEAN NOT NULL,
  PRIMARY KEY(id_classe)
);

CREATE TABLE modelo (
  id_modelo INTEGER NOT NULL,
  classe_id_classe INTEGER NOT NULL,
  nu_codigo_modelo INTEGER NOT NULL,
  vc_descricao_modelo VARCHAR(80) NOT NULL,
  vc_marca_modelo VARCHAR(50) NOT NULL,
  vc_layout_modelo VARCHAR(80) NULL,
  PRIMARY KEY(id_modelo),
  FOREIGN KEY(classe_id_classe)
    REFERENCES classe(id_classe)
);

CREATE TABLE log_usuario (
  id_logs INTEGER NOT NULL,
  usuario_id_usuario INTEGER NOT NULL,
  dh_registro_log TIMESTAMP NOT NULL,
  id_origem_log INTEGER NOT NULL,
  tx_acao_log VARCHAR NOT NULL,
  vc_nome_origem_log VARCHAR(80) NOT NULL,
  PRIMARY KEY(id_logs),
  FOREIGN KEY(usuario_id_usuario)
    REFERENCES usuario(id_usuario)
);

CREATE TABLE veiculo (
  id_veiculo INTEGER NOT NULL,
  modelo_id_modelo INTEGER NOT NULL,
  cor_id_cor INTEGER NULL,
  nu_codigo_veiculo INTEGER NOT NULL,
  vc_nome_veiculo VARCHAR(50) NOT NULL,
  vc_rfid_veiculo VARCHAR(11) NULL,
  vc_placa_veiculo VARCHAR(8) NOT NULL,
  nu_km_veiculo NUMERIC NULL,
  tx_observacao_veiculo TEXT NULL,
  dh_registro_veiculo TIMESTAMP NOT NULL,
  PRIMARY KEY(id_veiculo),
  FOREIGN KEY(cor_id_cor)
    REFERENCES cor(id_cor),
  FOREIGN KEY(modelo_id_modelo)
    REFERENCES modelo(id_modelo)
);

CREATE TABLE revisao (
  id_revisao INTEGER NOT NULL,
  usuario_id_usuario INTEGER NOT NULL,
  veiculo_id_veiculo INTEGER NOT NULL,
  dh_registro_revisao TIMESTAMP NOT NULL,
  tx_descricao_revisao TEXT NULL,
  PRIMARY KEY(id_revisao),
  FOREIGN KEY(veiculo_id_veiculo)
    REFERENCES veiculo(id_veiculo),
  FOREIGN KEY(usuario_id_usuario)
    REFERENCES usuario(id_usuario)
);

CREATE TABLE componente (
  id_componente INTEGER NOT NULL,
  modelo_id_modelo INTEGER NOT NULL,
  veiculo_id_veiculo INTEGER NOT NULL,
  nu_codigo_componente INTEGER NOT NULL,
  vc_rfid_componente VARCHAR(11) NOT NULL,
  vc_nome_componente VARCHAR(50) NOT NULL,
  tx_descricao_componente TEXT NULL,
  dh_validade_componente TIMESTAMP NULL,
  dh_registro_componente TIMESTAMP NOT NULL,
  PRIMARY KEY(id_componente),
  FOREIGN KEY(veiculo_id_veiculo)
    REFERENCES veiculo(id_veiculo),
  FOREIGN KEY(modelo_id_modelo)
    REFERENCES modelo(id_modelo)
);

CREATE TABLE componente_revisao (
  componente_id_componente INTEGER NOT NULL,
  revisao_id_revisao INTEGER NOT NULL,
  bo_identificado BOOLEAN NOT NULL,
  dh_identificacao_componente_revisao TIMESTAMP NOT NULL,
  tx_motivo_nao_identificacao TEXT NULL,
  PRIMARY KEY(componente_id_componente, revisao_id_revisao),
  FOREIGN KEY(componente_id_componente)
    REFERENCES componente(id_componente),
  FOREIGN KEY(revisao_id_revisao)
    REFERENCES revisao(id_revisao)
);


