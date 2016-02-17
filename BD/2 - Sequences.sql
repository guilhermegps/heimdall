-- Sequence: seq_chave_primaria

-- DROP SEQUENCE seq_chave_primaria;

CREATE SEQUENCE seq_chave_primaria
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 589551
  CACHE 1;
ALTER TABLE seq_chave_primaria
  OWNER TO postgres;

------------------------------------------------------------------------

