--Usuários--
INSERT INTO usuario(
            id_usuario, vc_senha_usuario, vc_nome_usuario, nu_nivel_usuario, 
            vc_login_usuario, vc_cpf_usuario, bo_primeiro_login_usuario, 
            bo_registro_ativo_usuario, bo_revisa_sem_agendamento) VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), '1BADB7678EA292D3E42439D07B6AFEAC', 'Guilherme de Paiva Santos', 1, 'admin', '11122233345', TRUE, TRUE, TRUE);

--Classes de Veículos e Componentes--
INSERT INTO classe(
            id_classe, vc_nome_classe, nu_tipo_classe) VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Automóvel', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Caminhão', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Caminhão Trator', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Caminhonete', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Camioneta', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Chassi Plataforma', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Ciclomotor', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Microônibus', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Motocicleta', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Motoneta', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Ônibus', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Quadriciclo', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Reboque', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Semi-reboque', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Side-car', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Trator Esteira', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Trator Rodas', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Triciclo', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Utilitário', 1), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Amortecedor', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Roda', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Pastilha de Freio', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Pneu', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Calota', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Farol/Lanterna', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Rack/Bagageiro', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Bateria', 2), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Parachoque', 2);

--Cores--
INSERT INTO cor(
            id_cor, vc_nome_cor) VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), 'Branco'), 
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
INSERT INTO modelo(
            id_modelo, id_classe, nu_codigo_modelo, tx_descricao_modelo, 
            vc_marca_modelo, vc_layout_modelo) VALUES (NEXTVAL('SEQ_CHAVE_PRIMARIA'), (SELECT id_classe FROM classe LIMIT 1), NEXTVAL('SEQ_CODIGO_REGISTRO'), 'Gol', 'Volkswagem', '4 portas'), 
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), (SELECT id_classe FROM classe WHERE vc_nome_classe = 'Caminhonete'), NEXTVAL('SEQ_CODIGO_REGISTRO'), 'Hilux SRV 11/12','Toyota','Automática 3.0 Diesel 4x4 - 2011'),
		(NEXTVAL('SEQ_CHAVE_PRIMARIA'), (SELECT id_classe FROM classe WHERE vc_nome_classe = 'Pneu'), NEXTVAL('SEQ_CODIGO_REGISTRO'),'175/65r14 ','Pirelli','82t Formula Spider');
