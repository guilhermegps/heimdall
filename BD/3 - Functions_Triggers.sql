-- Function: f_veiculo_tbiu()

-- DROP FUNCTION f_veiculo_tbiu();

CREATE OR REPLACE FUNCTION f_veiculo_tbiu()
  RETURNS trigger AS
$BODY$
 BEGIN
	
 	NEW.vc_placa_veiculo := UPPER(NEW.vc_placa_veiculo);
 	
 	NEW.vc_rfid_veiculo := UPPER(NEW.vc_rfid_veiculo);
	
	IF (TG_OP = 'INSERT') THEN
 		IF (NEW.nu_codigo_veiculo = 0) THEN
			NEW.nu_codigo_veiculo = NEXTVAL('SEQ_CODIGO_REGISTRO');
		ELSIF (NEW.nu_codigo_veiculo < 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
			RETURN NULL;
		END IF;
	ELSE
 		IF (NEW.nu_codigo_veiculo <= 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
			RETURN OLD;
		END IF;
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
  RETURNS trigger AS
$BODY$
 BEGIN
	
	IF (TG_OP = 'INSERT') THEN
 		IF (NEW.nu_codigo_modelo = 0) THEN
			NEW.nu_codigo_modelo = NEXTVAL('SEQ_CODIGO_REGISTRO');
		ELSIF (NEW.nu_codigo_modelo < 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
			RETURN NULL;
		END IF;
	ELSE
 		IF (NEW.nu_codigo_modelo <= 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
			RETURN OLD;
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
  RETURNS trigger AS
$BODY$
 BEGIN
	
	IF (TG_OP = 'INSERT') THEN
 		IF (NEW.nu_codigo_componente = 0) THEN
			NEW.nu_codigo_componente = NEXTVAL('SEQ_CODIGO_REGISTRO');
		ELSIF (NEW.nu_codigo_componente < 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
			RETURN NULL;
		END IF;
	ELSE
 		IF (NEW.nu_codigo_componente <= 0) THEN
			RAISE EXCEPTION 'Valor inválido para o campo do código.';
			RETURN OLD;
		END IF;
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
