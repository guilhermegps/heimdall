-- Trigger: veiculo_tbiu on veiculo

-- DROP TRIGGER veiculo_tbiu ON veiculo;

CREATE TRIGGER veiculo_tbiu
  BEFORE INSERT OR UPDATE
  ON veiculo
  FOR EACH ROW
  EXECUTE PROCEDURE f_veiculo_tbiu();

-------------------------------------------------------------------------

