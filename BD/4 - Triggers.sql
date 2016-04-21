-- Trigger: veiculo_tbiu on veiculo

-- DROP TRIGGER veiculo_tbiu ON veiculo;

CREATE TRIGGER veiculo_tbiu
  BEFORE INSERT OR UPDATE
  ON veiculo
  FOR EACH ROW
  EXECUTE PROCEDURE f_veiculo_tbiu();

-- Trigger: modelo_tbiud on modelo

-- DROP TRIGGER modelo_tbiud ON modelo;

CREATE TRIGGER modelo_tbiud
  BEFORE INSERT OR UPDATE
  ON modelo
  FOR EACH ROW
  EXECUTE PROCEDURE f_modelo_tbiud();

-- Trigger: componente_tbiud on componente

-- DROP TRIGGER componente_tbiud ON componente;

CREATE TRIGGER componente_tbiud
  BEFORE INSERT OR UPDATE
  ON componente
  FOR EACH ROW
  EXECUTE PROCEDURE f_componente_tbiud();

/*-- Trigger: usuario_tbiud on usuario

-- DROP TRIGGER usuario_tbiud ON usuario;

CREATE TRIGGER usuario_tbiud
  BEFORE INSERT OR UPDATE
  ON usuario
  FOR EACH ROW
  EXECUTE PROCEDURE f_usuario_tbiud();*/























