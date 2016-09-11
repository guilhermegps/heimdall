
CREATE TABLE public.usuario (
                id_usuario INTEGER NOT NULL,
                vc_senha_usuario VARCHAR(32) NOT NULL,
                vc_nome_usuario VARCHAR(80) NOT NULL,
                nu_nivel_usuario INTEGER NOT NULL,
                vc_login_usuario VARCHAR(50) NOT NULL,
                vc_cpf_usuario VARCHAR(11) NOT NULL,
                bo_primeiro_login_usuario BOOLEAN NOT NULL,
                bo_registro_ativo_usuario BOOLEAN NOT NULL,
                bo_revisa_sem_agendamento BOOLEAN NOT NULL,
                CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
);
COMMENT ON COLUMN public.usuario.nu_nivel_usuario IS 'Níveis de usuários:
1 - Gestor
2 - Administrador
3 - Funcionário';


CREATE UNIQUE INDEX usuario_vc_cpf_usuario_key
 ON public.usuario USING BTREE
 ( vc_cpf_usuario );

CREATE UNIQUE INDEX usuario_vc_login_usuario_key
 ON public.usuario USING BTREE
 ( vc_login_usuario );

CREATE TABLE public.log_usuario (
                id_log INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                dh_registro_log TIMESTAMP NOT NULL,
                tx_acao_log TEXT NOT NULL,
                CONSTRAINT log_usuario_pkey PRIMARY KEY (id_log)
);


CREATE TABLE public.cor (
                id_cor INTEGER NOT NULL,
                vc_nome_cor VARCHAR(50) NOT NULL,
                CONSTRAINT cor_pkey PRIMARY KEY (id_cor)
);


CREATE TABLE public.classe (
                id_classe INTEGER NOT NULL,
                vc_nome_classe VARCHAR(50) NOT NULL,
                nu_tipo_classe INTEGER NOT NULL,
                CONSTRAINT classe_pkey PRIMARY KEY (id_classe)
);
COMMENT ON COLUMN public.classe.nu_tipo_classe IS '1 - Veiculo
2 - Componente';


CREATE TABLE public.modelo (
                id_modelo INTEGER NOT NULL,
                id_classe INTEGER NOT NULL,
                nu_codigo_modelo INTEGER NOT NULL,
                tx_descricao_modelo TEXT NOT NULL,
                vc_marca_modelo VARCHAR(80) NOT NULL,
                vc_layout_modelo VARCHAR(80),
                CONSTRAINT modelo_pkey PRIMARY KEY (id_modelo)
);


CREATE UNIQUE INDEX modelo_nu_codigo_modelo_key
 ON public.modelo USING BTREE
 ( nu_codigo_modelo );

CREATE TABLE public.veiculo (
                id_veiculo INTEGER NOT NULL,
                id_modelo INTEGER NOT NULL,
                id_cor INTEGER,
                nu_codigo_veiculo INTEGER NOT NULL,
                vc_nome_veiculo VARCHAR(50) NOT NULL,
                vc_rfid_veiculo VARCHAR(11),
                vc_placa_veiculo VARCHAR(8) NOT NULL,
                nu_km_veiculo NUMERIC(13),
                tx_observacao_veiculo TEXT,
                dh_registro_veiculo TIMESTAMP NOT NULL,
                bo_registro_ativo_veiculo BOOLEAN NOT NULL,
                CONSTRAINT veiculo_pkey PRIMARY KEY (id_veiculo)
);


CREATE UNIQUE INDEX veiculo_nu_codigo_veiculo_key
 ON public.veiculo USING BTREE
 ( nu_codigo_veiculo );

CREATE UNIQUE INDEX veiculo_vc_rfid_veiculo_key
 ON public.veiculo USING BTREE
 ( vc_rfid_veiculo );

CREATE TABLE public.revisao (
                id_revisao INTEGER NOT NULL,
                id_veiculo INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                nu_numero_revisao INTEGER NOT NULL,
                dh_execucao_revisao TIMESTAMP,
                tx_descricao_revisao TEXT,
                id_usuario_autorizador INTEGER NOT NULL,
                bo_executada BOOLEAN NOT NULL,
                CONSTRAINT revisao_pkey PRIMARY KEY (id_revisao)
);


CREATE TABLE public.agenda_revisao (
                id_agenda_revisao INTEGER NOT NULL,
                dh_data_inicio TIMESTAMP NOT NULL,
                dh_data_termino TIMESTAMP NOT NULL,
                hr_hora_inicio TIME NOT NULL,
                hr_hora_termino TIME NOT NULL,
                in_intervalo INTERVAL,
                bo_segunda BOOLEAN NOT NULL,
                bo_terca BOOLEAN NOT NULL,
                bo_quarta BOOLEAN NOT NULL,
                bo_quinta BOOLEAN NOT NULL,
                bo_sexta BOOLEAN NOT NULL,
                bo_sabado BOOLEAN NOT NULL,
                bo_domingo BOOLEAN NOT NULL,
                bo_feriados BOOLEAN NOT NULL,
                CONSTRAINT id_agenda_revisao PRIMARY KEY (id_agenda_revisao)
);


CREATE TABLE public.componente (
                id_componente INTEGER NOT NULL,
                id_modelo INTEGER NOT NULL,
                id_veiculo INTEGER NOT NULL,
                nu_codigo_componente INTEGER NOT NULL,
                vc_rfid_componente VARCHAR(11) NOT NULL,
                vc_nome_componente VARCHAR(50) NOT NULL,
                tx_descricao_componente TEXT,
                dh_validade_componente TIMESTAMP,
                dh_registro_componente TIMESTAMP NOT NULL,
                bo_registro_ativo_componente BOOLEAN NOT NULL,
                CONSTRAINT componente_pkey PRIMARY KEY (id_componente)
);


CREATE UNIQUE INDEX componente_nu_codigo_componente_key
 ON public.componente USING BTREE
 ( nu_codigo_componente );

CREATE UNIQUE INDEX componente_vc_rfid_componente_key
 ON public.componente USING BTREE
 ( vc_rfid_componente );

CREATE TABLE public.componente_revisao (
                id_componente INTEGER NOT NULL,
                id_revisao INTEGER NOT NULL,
                bo_identificado BOOLEAN NOT NULL,
                dh_identificacao_componente_revisao TIMESTAMP,
                tx_motivo_nao_identificacao TEXT,
                CONSTRAINT componente_revisao_pkey PRIMARY KEY (id_componente, id_revisao)
);


ALTER TABLE public.log_usuario ADD CONSTRAINT log_usuario_usuario_id_usuario_fkey
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.revisao ADD CONSTRAINT revisao_usuario_id_usuario_fkey
FOREIGN KEY (id_usuario_autorizador)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.revisao ADD CONSTRAINT usuario_revisao_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.veiculo ADD CONSTRAINT veiculo_cor_id_cor_fkey
FOREIGN KEY (id_cor)
REFERENCES public.cor (id_cor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.modelo ADD CONSTRAINT modelo_classe_id_classe_fkey
FOREIGN KEY (id_classe)
REFERENCES public.classe (id_classe)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.componente ADD CONSTRAINT componente_modelo_id_modelo_fkey
FOREIGN KEY (id_modelo)
REFERENCES public.modelo (id_modelo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.veiculo ADD CONSTRAINT veiculo_modelo_id_modelo_fkey
FOREIGN KEY (id_modelo)
REFERENCES public.modelo (id_modelo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.componente ADD CONSTRAINT componente_veiculo_id_veiculo_fkey
FOREIGN KEY (id_veiculo)
REFERENCES public.veiculo (id_veiculo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.revisao ADD CONSTRAINT revisao_veiculo_id_veiculo_fkey
FOREIGN KEY (id_veiculo)
REFERENCES public.veiculo (id_veiculo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.componente_revisao ADD CONSTRAINT componente_revisao_revisao_id_revisao_fkey
FOREIGN KEY (id_revisao)
REFERENCES public.revisao (id_revisao)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.agenda_revisao ADD CONSTRAINT revisao_agenda_revisao_fk
FOREIGN KEY (id_agenda_revisao)
REFERENCES public.revisao (id_revisao)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.componente_revisao ADD CONSTRAINT componente_revisao_componente_id_componente_fkey
FOREIGN KEY (id_componente)
REFERENCES public.componente (id_componente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
