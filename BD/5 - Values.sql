--Usuários--
INSERT INTO usuario VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), '08F9CE6B9E70DADB981D0E8249CB9042', 'Guilherme de Paiva Santos', 1, 'guilherme', '11122233345', TRUE, TRUE);

--Classes de Veículos e Componentes--
INSERT INTO classe VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Automóvel', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Caminhão', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Caminhão Trator', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Caminhonete', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Camioneta', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Chassi Plataforma', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Ciclomotor', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Microônibus', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Motocicleta', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Motoneta', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Ônibus', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Quadriciclo', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Reboque', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Semi-reboque', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Side-car', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Trator Esteira', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Trator Rodas', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Triciclo', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Utilitário', TRUE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Amortecedor', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Roda', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Pastilha de Freio', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Pneu', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Calota', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Farol/Lanterna', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Rack/Bagageiro', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Bateria', FALSE), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Parachoque', FALSE);

--Cores--
INSERT INTO cor VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Branco'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Preto'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Prata'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Marrom'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Amarelo'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Verde'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Laranja'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Azul'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Cinza'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Vermelho'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Dourado'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Rosa');

--Modelos--
INSERT INTO modelo VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), (SELECT id_classe FROM classe LIMIT 1), NEXTVAL('SEQ_CODIGO_REGISTRO'), 'Gol', 'Volkswagem', '4 portas'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), (SELECT id_classe FROM classe WHERE vc_nome_classe = 'Caminhonete'), NEXTVAL('SEQ_CODIGO_REGISTRO'), 'Hilux SRV 11/12','Toyota','Automática 3.0 Diesel 4x4 - 2011');
