-- Function: f_veiculo_tbiu()

-- DROP FUNCTION f_veiculo_tbiu();

CREATE OR REPLACE FUNCTION f_veiculo_tbiu()
  RETURNS TRIGGER AS
$BODY$
 BEGIN
 	NEW.vc_placa_veiculo := UPPER(NEW.vc_placa_veiculo);
 	
 	NEW.vc_rfid_veiculo := UPPER(NEW.vc_rfid_veiculo);
	
	IF (TG_OP = 'INSERT') THEN
 		IF (NEW.nu_codigo_veiculo = 0) THEN
			NEW.nu_codigo_veiculo = NEXTVAL('SEQ_CODIGO_REGISTRO');
			WHILE(EXISTS(SELECT 1 FROM veiculo WHERE nu_codigo_veiculo = NEW.nu_codigo_veiculo)) LOOP
				NEW.nu_codigo_veiculo = NEXTVAL('SEQ_CODIGO_REGISTRO');
			END LOOP;
		ELSIF (NEW.nu_codigo_veiculo < 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
		END IF;
	ELSE
 		IF (NEW.nu_codigo_veiculo <= 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
		END IF;
	END IF;

	IF (EXISTS (SELECT 1 FROM veiculo WHERE vc_rfid_veiculo = NEW.vc_rfid_veiculo)) THEN
		RAISE EXCEPTION 'Já existe um registro na tabela [veiculo] vinculado a este código RFID.';
	ELSIF (EXISTS (SELECT 1 FROM componente WHERE vc_rfid_componente = NEW.vc_rfid_veiculo)) THEN
		RAISE EXCEPTION 'Já existe um registro na tabela [componente] vinculado a este código RFID.';
	END IF;
 	
 	RETURN NEW;
 END;
 $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_veiculo_tbiu()
  OWNER TO postgres;
  
-- Function: f_modelo_tbiud()

-- DROP FUNCTION f_modelo_tbiud();

CREATE OR REPLACE FUNCTION f_modelo_tbiud()
  RETURNS TRIGGER AS
$BODY$
 BEGIN
	IF (TG_OP = 'INSERT') THEN
 		IF (NEW.nu_codigo_modelo = 0) THEN
			NEW.nu_codigo_modelo = NEXTVAL('SEQ_CODIGO_REGISTRO');
			WHILE(EXISTS(SELECT 1 FROM modelo WHERE nu_codigo_modelo = NEW.nu_codigo_modelo)) LOOP
				NEW.nu_codigo_modelo = NEXTVAL('SEQ_CODIGO_REGISTRO');
			END LOOP;
		ELSIF (NEW.nu_codigo_modelo < 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
		END IF;
	ELSE
 		IF (NEW.nu_codigo_modelo <= 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
		END IF;
	END IF;
 	
 	RETURN NEW;
 END;
 $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_modelo_tbiud()
  OWNER TO postgres;
  
-- Function: f_componente_tbiud()

-- DROP FUNCTION f_componente_tbiud();

CREATE OR REPLACE FUNCTION f_componente_tbiud()
  RETURNS TRIGGER AS
$BODY$
 BEGIN
	IF (TG_OP = 'INSERT') THEN
 		IF (NEW.nu_codigo_componente = 0) THEN
			NEW.nu_codigo_componente = NEXTVAL('SEQ_CODIGO_REGISTRO');
			WHILE(EXISTS(SELECT 1 FROM componente WHERE nu_codigo_componente = NEW.nu_codigo_componente)) LOOP
				NEW.nu_codigo_componente = NEXTVAL('SEQ_CODIGO_REGISTRO');
			END LOOP;
		ELSIF (NEW.nu_codigo_componente < 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
		END IF;
	ELSE
 		IF (NEW.nu_codigo_componente <= 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
		END IF;
	END IF;
 	
	NEW.vc_rfid_componente := UPPER(NEW.vc_rfid_componente);

	IF (EXISTS (SELECT 1 FROM veiculo WHERE vc_rfid_veiculo = NEW.vc_rfid_componente)) THEN
		RAISE EXCEPTION 'Já existe um registro na tabela [veiculo] vinculado a este código RFID.';
	ELSIF (EXISTS (SELECT 1 FROM componente WHERE vc_rfid_componente = NEW.vc_rfid_componente)) THEN
		RAISE EXCEPTION 'Já existe um registro na tabela [componente] vinculado a este código RFID.';
	END IF;
 	
 	RETURN NEW;
 END;
 $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_componente_tbiud()
  OWNER TO postgres;

/*-- Function: f_usuario_tbiud()

-- DROP FUNCTION f_usuario_tbiud();

CREATE OR REPLACE FUNCTION f_usuario_tbiud()
  RETURNS TRIGGER AS
$BODY$
 BEGIN
 
 	IF (TG_OP = 'INSERT') THEN
 		IF(EXISTS(SELECT 1 FROM usuario WHERE vc_login_usuario = NEW.vc_login_usuario)) THEN
			RAISE EXCEPTION 'Já existe um registro de usuário com este mesmo login [%]', NEW.vc_login_usuario;
		ELSIF (EXISTS(SELECT 1 FROM usuario WHERE vc_cpf_usuario = NEW.vc_cpf_usuario)) THEN
			RAISE EXCEPTION 'Já existe um registro de usuário com este mesmo CPF [%]', NEW.vc_cpf_usuario;
		END IF;
	END IF;
 	
 	RETURN NEW;
 END;
 $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_usuario_tbiud()
  OWNER TO postgres;

-- Function: f_usuario_tbiud()

-- DROP FUNCTION f_usuario_tbiud();

CREATE OR REPLACE FUNCTION f_usuario_tbiud()
  RETURNS trigger AS
$BODY$
 BEGIN
 
 	IF (TG_OP = 'INSERT') THEN
 		
	END IF;
 	
 	RETURN NEW;
 END;
 $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_usuario_tbiud()
  OWNER TO postgres;*/



/* -----Exemplo------

-- Function: f_item_tbiu()

-- DROP FUNCTION f_item_tbiu();

CREATE OR REPLACE FUNCTION f_item_tbiu()
  RETURNS trigger AS
$BODY$
 BEGIN
 	IF (TG_OP = 'UPDATE') THEN
 		IF (OLD.guid_item != NEW.guid_item) THEN	
 			INSERT INTO historico_registro_excluido
 				(id_historico_registro_excluido,
 				guid,
 				entidade,
 				data_exclusao,
 				versao_registro)
 			VALUES (NEXTVAL('seq_chave_primaria'),
 				OLD.guid_item,
 				1,
 				CURRENT_TIMESTAMP,
 				NEXTVAL('seq_versao_registro'));				
 		END IF;
 	END IF;
 	
 	NEW.versao_registro := NEXTVAL('SEQ_VERSAO_REGISTRO');
 	
 	RETURN NEW;
 END;
 $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_item_tbiu()
  OWNER TO postgres;*/
